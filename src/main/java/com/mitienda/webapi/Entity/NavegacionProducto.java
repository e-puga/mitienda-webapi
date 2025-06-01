package com.mitienda.webapi.Entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "NavegacionProducto")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NavegacionProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNavegacionProducto;

    @Column(name = "idProducto", nullable = false)
    private int idProducto;

    @Column(name = "idCliente", nullable = false)
    private int idCliente;

    @Column(name = "esSeleccionado")
    private Boolean esSeleccionado;

    @Column(name = "fechaNavegacion")
    private LocalDateTime fechaNavegacion;
}
