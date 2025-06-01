package com.mitienda.webapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mitienda.webapi.Entity.SubCategoria;

@Repository
public interface SubCategoriaRepository extends JpaRepository<SubCategoria, Integer> {

}
