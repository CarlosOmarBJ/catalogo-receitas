package com.exemplo.receitas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.exemplo.receitas.model.Receita;
import com.exemplo.receitas.model.Categoria;
import java.util.List;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long> {
    List<Receita> findByNomeContaining(String termo);
    List<Receita> findByCategoria(Categoria categoria);
    List<Receita> findByCategoria_Id(Long categoriaId);
} 