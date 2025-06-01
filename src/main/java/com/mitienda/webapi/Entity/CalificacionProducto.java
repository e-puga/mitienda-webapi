package com.mitienda.webapi.Entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "CalificacionProducto")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CalificacionProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCalificacionProducto;

    @Column(name = "idProducto", nullable = false)
    private int idProducto;

    @Column(name = "idCliente", nullable = false)
    private int idCliente;

    @Column(name = "fechaCalificacion")
    private LocalDateTime fechaCalificacion;

    @Column(name = "puntuacion", nullable = false)
    private int puntuacion;

    @Column(name = "comentario")
    private String comentario;
}
