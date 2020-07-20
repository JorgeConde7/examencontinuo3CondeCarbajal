package com.conde.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.conde.demo.interfaceService.ICategoriaService;
import com.conde.demo.model.Categorias;

@Controller
@RequestMapping
public class CategoriasController {

	@Autowired
	private ICategoriaService service;
	
	
	@GetMapping("/listarCategorias")
	public String listar(Model model) {
		List<Categorias>categorias=service.listar();
		model.addAttribute("categorias",categorias);
		return "Categoria";
	}
	
	@GetMapping("/newCategorias")
	public String agregar(Model model) {		
		model.addAttribute("categorias",new Categorias());
		return "formCategoria";
	}
	
	@PostMapping("/saveCategorias")
	public String save( Categorias p,Model model) {		
		service.save(p);
		return "redirect:/listarCategorias";
	}
	
	@GetMapping("/editarCategorias/{id}")
	public String editar(@PathVariable int id, Model model) {
		Optional<Categorias>categorias=service.listarId(id);
		model.addAttribute("categorias",categorias);
		return "formCategoria";
	}	
	
	@GetMapping("/eliminarCategorias/{id}")
	public String delete(Model model, @PathVariable int id) {
		service.delete(id);
		return "redirect:/listarCategorias";
	}
	
}
