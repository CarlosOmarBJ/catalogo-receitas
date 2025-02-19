package com.exemplo.receitas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.exemplo.receitas.service.CategoriaService;
import com.exemplo.receitas.service.ReceitaService;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {
    
    @Autowired
    private CategoriaService categoriaService;
    
    @Autowired
    private ReceitaService receitaService;
    
    @GetMapping
    public String listarCategorias(Model model) {
        model.addAttribute("categorias", categoriaService.buscarTodas());
        return "categorias";
    }
    
    @GetMapping("/{id}")
    public String verReceitasPorCategoria(@PathVariable Long id, Model model) {
        model.addAttribute("categoria", categoriaService.buscarPorId(id));
        model.addAttribute("receitas", receitaService.buscarPorCategoria(id));
        return "receitas-categoria";
    }
} 