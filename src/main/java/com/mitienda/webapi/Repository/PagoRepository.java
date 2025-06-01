package com.mitienda.webapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mitienda.webapi.Entity.Pago;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Integer> {

}
