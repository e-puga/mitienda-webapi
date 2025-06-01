package com.mitienda.webapi.Entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "Pago")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPago;

    @Column(name = "idPedido", nullable = false)
    private int idPedido;

    @Column(name = "idMetodoPago", nullable = false)
    private int idMetodoPago;

    @Column(name = "montoPagado", nullable = false)
    private Double montoPagado;

    @Column(name = "fechaPago")
    private LocalDateTime fechaPago;

    @Column(name = "codReferencia")
    private String codReferencia;

    @Column(name = "estadoPago")
    private String estadoPago;
}
