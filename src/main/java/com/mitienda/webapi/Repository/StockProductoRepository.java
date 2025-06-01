package com.mitienda.webapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mitienda.webapi.Entity.StockProducto;

@Repository
public interface StockProductoRepository extends JpaRepository<StockProducto, Integer> {

}
