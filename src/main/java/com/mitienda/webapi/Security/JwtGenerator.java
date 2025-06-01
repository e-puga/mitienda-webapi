package com.mitienda.webapi.Security;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtGenerator {

	// Clave secreta (debe tener al menos 32 caracteres para HS256)
	private static final String JWT_SECRET = ConstantesSeguridad.JWT_FIRMA;

	// Clave generada a partir del secreto
	private static final SecretKey SECRET_KEY = Keys.hmacShaKeyFor(JWT_SECRET.getBytes(StandardCharsets.UTF_8));

	// Método para generar un token JWT con el username
	public String generarToken(String username) {
		Date now = new Date();
		Date expiryDate = new Date(now.getTime() + ConstantesSeguridad.JWT_EXPIRATION_TOKEN);

		return Jwts.builder().subject(username).issuedAt(now).expiration(expiryDate)
				.signWith(SECRET_KEY, SignatureAlgorithm.HS256).compact();
	}

	// Método para obtener el username a partir del token JWT
	public String obtenerUsernameJwt(String token) {
		JwtParser parser = Jwts.parser().verifyWith(SECRET_KEY).build();

		Claims claims = parser.parseSignedClaims(token).getPayload();
		return claims.getSubject();
	}

	// Método para validar el token JWT
	public boolean validarToken(String token) {
		try {
			Jwts.parser().verifyWith(SECRET_KEY).build().parseSignedClaims(token);
			return true;
		} catch (Exception e) {
			throw new RuntimeException("Token inválido o expirado", e);
		}
	}
}
