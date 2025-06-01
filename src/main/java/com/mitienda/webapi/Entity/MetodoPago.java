package com.mitienda.webapi.Entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "MetodoPago")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MetodoPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMetodoPago;

    @Column(name = "tipoPago", nullable = false)
    private String tipoPago;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "estado", nullable = false)
    private String estado;
}
