package com.mitienda.webapi.Entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.*;

@Data
@Table(name = "Producto")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProducto;

    @Column(name = "codigo", nullable = false)
    private String codigo;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "imagen")
    private String imagen;

    @Column(name = "talla")
    private String talla;

    @Column(name = "descuento")
    private Double descuento;

    @Column(name = "idSubCategoriaProducto", nullable = false)
    private int idSubCategoriaProducto;

    @Column(name = "marca")
    private String marca;

    @Column(name = "precio", nullable = false)
    private Double precio;

    @Column(name = "estado", nullable = false)
    private String estado;

    @Column(name = "fechaCreacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "estacionCreacion")
    private String estacionCreacion;

    @Column(name = "usuarioCreacion")
    private String usuarioCreacion;

    @Column(name = "fechaModificacion")
    private LocalDateTime fechaModificacion;

    @Column(name = "estacionModificacion")
    private String estacionModificacion;

    @Column(name = "usuarioModificacion")
    private String usuarioModificacion;
}
