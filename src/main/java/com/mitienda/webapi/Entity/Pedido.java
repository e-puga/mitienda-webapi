package com.mitienda.webapi.Entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "Pedido")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPedido;

    @Column(name = "idCliente", nullable = false)
    private int idCliente;

    @Column(name = "fechaPedido")
    private LocalDateTime fechaPedido;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "estado", nullable = false)
    private String estado;

    @Column(name = "total")
    private Double total;

    @Column(name = "descuento")
    private Double descuento;

    @Column(name = "totalFinal")
    private Double totalFinal;

    @Column(name = "fechaCreacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "usuarioCreacion")
    private String usuarioCreacion;

    @Column(name = "estacionCreacion")
    private String estacionCreacion;

    @Column(name = "fechaModificacion")
    private LocalDateTime fechaModificacion;

    @Column(name = "estacionModificacion")
    private String estacionModificacion;

    @Column(name = "usuarioModificacion")
    private String usuarioModificacion;
}
