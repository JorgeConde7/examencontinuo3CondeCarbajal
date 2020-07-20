package com.conde.demo.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.conde.demo.interfaces.IProductos;
import com.conde.demo.model.Productos;

@RestController
@RequestMapping("/rest_pro")
public class restProducto {

	

	@Autowired
	private IProductos data;		
	
	@GetMapping
	public List<Productos> listar() {	
	return (List<Productos>)data.findAll();
	}
	
	
	

	@PostMapping
	public void insertar(@RequestBody Productos pro) {
	data.save(pro);
	}

	@PutMapping
    public void modificar(@RequestBody Productos pro) {
        data.save(pro);
    }
    
    @DeleteMapping(value ="/{idproducto}")
    public void eliminar(@PathVariable("idproducto") Integer idproducto) {
        data.deleteById(idproducto);
    }  
    
    
    //LISTAR POR ID
    @GetMapping(value ="/{idproducto}")
	public Optional<Productos> listar(@PathVariable("idproducto") Integer id) {	
	return data.findById(id);
	}
}