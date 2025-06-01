package com.mitienda.webapi.Entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.*;

@Data
@Table(name = "Subcategoria")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SubCategoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSubCategoriaProducto;

    @Column(name = "idCategoriaProducto", nullable = false)
    private int idCategoriaProducto;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fechaCreacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "usuarioCreacion")
    private String usuarioCreacion;

    @Column(name = "estacionCreacion")
    private String estacionCreacion;

    @Column(name = "fechaModificacion")
    private LocalDateTime fechaModificacion;

    @Column(name = "usuarioModificacion")
    private String usuarioModificacion;

    @Column(name = "estacionModificacion")
    private String estacionModificacion;
}
