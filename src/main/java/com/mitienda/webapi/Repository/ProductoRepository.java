package com.mitienda.webapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mitienda.webapi.Entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
