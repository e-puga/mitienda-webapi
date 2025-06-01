package com.mitienda.webapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mitienda.webapi.Entity.CalificacionProducto;

@Repository
public interface CalificacionProductoRepository extends JpaRepository<CalificacionProducto, Integer> {

}
