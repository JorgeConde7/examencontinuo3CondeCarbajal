package com.conde.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conde.demo.interfaceService.ICategoriaService;
import com.conde.demo.interfaces.ICategorias;
import com.conde.demo.model.Categorias;

@Service
public class CategoriasService implements ICategoriaService {

	@Autowired
	ICategorias data;
	@Override
	public List<Categorias> listar() {
		return (List<Categorias>)data.findAll();
	}

	@Override
	public Optional<Categorias> listarId(int idCategorias) {
		return data.findById(idCategorias);
	}

	@Override
	public int save(Categorias categorias) {
		int res=0;
		Categorias cliente=data.save(categorias);
		if(!cliente.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(int idCategorias) {
		data.deleteById(idCategorias);
		
	}

}
