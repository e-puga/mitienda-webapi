package com.mitienda.webapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mitienda.webapi.Entity.CategoriaCliente;

@Repository
public interface CategoriaClienteRepository extends JpaRepository<CategoriaCliente, Integer> {

}
