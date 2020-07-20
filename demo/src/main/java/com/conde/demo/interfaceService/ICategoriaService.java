package com.conde.demo.interfaceService;

import java.util.List;
import java.util.Optional;

import com.conde.demo.model.Categorias;

public interface ICategoriaService {

	public List<Categorias>listar();
	public Optional<Categorias>listarId(int idCategorias);
	public int save(Categorias categorias);
	public void delete(int idCategorias);
}
