package com.mitienda.webapi.Entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "CategoriaCliente")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CategoriaCliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCategoriaCliente;

    @Column(name = "categoria", nullable = false)
    private String categoria;

    @Column(name = "descripcion")
    private String descripcion;

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

    @Column(name = "usuarioModificacion")
    private String usuarioModificacion;
}
