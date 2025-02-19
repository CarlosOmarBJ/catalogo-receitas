package com.exemplo.receitas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.exemplo.receitas.model.Receita;
import com.exemplo.receitas.repository.ReceitaRepository;
import com.exemplo.receitas.model.Categoria;
import java.util.List;

@Service
public class ReceitaService {
    @Autowired
    private ReceitaRepository receitaRepository;
    
    @Autowired
    private CategoriaService categoriaService;
    
    public List<Receita> buscarTodas() {
        return receitaRepository.findAll();
    }
    
    public Receita buscarPorId(Long id) {
        return receitaRepository.findById(id).orElse(null);
    }
    
    public Receita salvar(Receita receita) {
        try {
            // Se tiver categoria, garante que ela existe
            if (receita.getCategoria() != null && receita.getCategoria().getId() != null) {
                Categoria categoria = categoriaService.buscarPorId(receita.getCategoria().getId());
                if (categoria != null) {
                    receita.setCategoria(categoria);
                }
            }
            
            return receitaRepository.save(receita);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar receita: " + e.getMessage());
        }
    }
    
    public void deletar(Long id) {
        receitaRepository.deleteById(id);
    }
    
    public List<Receita> buscarPorNome(String termo) {
        return receitaRepository.findByNomeContaining(termo);
    }
    
    public List<Receita> buscarPorCategoria(Long categoriaId) {
        return receitaRepository.findByCategoria_Id(categoriaId);
    }
} 