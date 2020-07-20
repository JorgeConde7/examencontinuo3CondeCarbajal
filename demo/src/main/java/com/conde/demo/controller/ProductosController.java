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

import com.conde.demo.interfaceService.IProductoService;
import com.conde.demo.model.Productos;


@Controller
@RequestMapping
public class ProductosController {

	@Autowired
	private IProductoService productoService;
		
	
	@GetMapping("/listarProductos")
	public String listar(Model model) {
		List<Productos>productos=productoService.listar();
		model.addAttribute("productos",productos);
		return "Producto";
	}
	
	@GetMapping("/newProductos")
	public String agregar(Model model) {		
		model.addAttribute("productos",new Productos());
		return "formProducto";
	}
	
	@PostMapping("/saveProductos")
	public String save( Productos p,Model model) {		
		productoService.save(p);
		return "redirect:/listarProductos";
	}
	
	@GetMapping("/editarProductos/{id}")
	public String editar(@PathVariable int id, Model model) {
		Optional<Productos>productos=productoService.listarId(id);
		model.addAttribute("productos",productos);
		return "formProducto";
	}	
	
	@GetMapping("/eliminarProductos/{id}")
	public String delete(Model model, @PathVariable int id) {
		productoService.delete(id);
		return "redirect:/listarProductos";
	}
}
