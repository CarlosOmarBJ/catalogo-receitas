package com.exemplo.receitas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.exemplo.receitas.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
} 