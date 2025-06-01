package com.mitienda.webapi.Entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "DetallePedido")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DetallePedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDetallePedido;

    @Column(name = "idPedido", nullable = false)
    private int idPedido;

    @Column(name = "idProducto", nullable = false)
    private int idProducto;

    @Column(name = "precio", nullable = false)
    private Double precio;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    @Column(name = "subtotal", nullable = false)
    private Double subtotal;
}
