package com.mitienda.webapi.Entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "Factura")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFactura;

    @Column(name = "idPedido", nullable = false)
    private int idPedido;

    @Column(name = "numFactura", nullable = false)
    private String numFactura;

    @Column(name = "fechaEmision")
    private LocalDateTime fechaEmision;

    @Column(name = "subTotal")
    private Double subTotal;

    @Column(name = "descuento")
    private Double descuento;

    @Column(name = "iva")
    private Double iva;

    @Column(name = "total")
    private Double total;
}
