package com.exemplo.receitas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.exemplo.receitas.model.Categoria;
import com.exemplo.receitas.repository.CategoriaRepository;
import java.util.List;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;
    
    public List<Categoria> buscarTodas() {
        return categoriaRepository.findAll();
    }
    
    public Categoria buscarPorId(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }
    
    public Categoria salvar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }
    
    public void deletar(Long id) {
        categoriaRepository.deleteById(id);
    }
} 