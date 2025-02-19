package com.exemplo.receitas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.exemplo.receitas.service.ReceitaService;
import com.exemplo.receitas.service.CategoriaService;
import com.exemplo.receitas.model.Receita;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/receitas")
public class ReceitaController {
    
    @Autowired
    private ReceitaService receitaService;
    
    @Autowired
    private CategoriaService categoriaService;
    
    @GetMapping
    public String listarReceitas(Model model) {
        model.addAttribute("receitas", receitaService.buscarTodas());
        return "home";
    }
    
    @GetMapping("/nova")
    public String novaReceita(Model model) {
        Receita receita = new Receita();
        model.addAttribute("receita", receita);
        model.addAttribute("todasCategorias", categoriaService.buscarTodas());
        return "form-receita";
    }
    
    @PostMapping("/salvar")
    public String salvarReceita(@ModelAttribute Receita receita, RedirectAttributes redirectAttributes) {
        try {
            // Validação básica
            if (receita.getNome() == null || receita.getNome().trim().isEmpty() ||
                receita.getDescricao() == null || receita.getDescricao().trim().isEmpty()) {
                redirectAttributes.addFlashAttribute("erro", "Por favor, preencha todos os campos obrigatórios");
                return "redirect:/receitas/nova";
            }
            
            // Salva a receita
            Receita receitaSalva = receitaService.salvar(receita);
            
            if (receitaSalva != null && receitaSalva.getId() != null) {
                redirectAttributes.addFlashAttribute("mensagem", "Receita salva com sucesso!");
                return "redirect:/receitas";
            } else {
                redirectAttributes.addFlashAttribute("erro", "Erro ao salvar a receita. Tente novamente.");
                return "redirect:/receitas/nova";
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "Erro ao salvar a receita: " + e.getMessage());
            return "redirect:/receitas/nova";
        }
    }
    
    @GetMapping("/{id}")
    public String verReceita(@PathVariable Long id, Model model) {
        Receita receita = receitaService.buscarPorId(id);
        if (receita == null) {
            return "redirect:/receitas";
        }
        model.addAttribute("receita", receita);
        return "receita";
    }
    
    @GetMapping("/{id}/editar")
    public String editarReceita(@PathVariable Long id, Model model) {
        model.addAttribute("receita", receitaService.buscarPorId(id));
        model.addAttribute("todasCategorias", categoriaService.buscarTodas());
        return "form-receita";
    }
    
    @PostMapping("/{id}/deletar")
    public String deletarReceita(@PathVariable Long id) {
        receitaService.deletar(id);
        return "redirect:/";
    }
    
    @GetMapping("/buscar")
    public String buscarReceitas(@RequestParam String termo, Model model) {
        model.addAttribute("receitas", receitaService.buscarPorNome(termo));
        model.addAttribute("termoBusca", termo);
        return "resultados-busca";
    }
} 