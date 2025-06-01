package com.mitienda.webapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mitienda.webapi.Entity.Factura;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Integer> {

}
