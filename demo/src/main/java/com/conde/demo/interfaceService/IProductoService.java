package com.conde.demo.interfaceService;

import java.util.List;
import java.util.Optional;

import com.conde.demo.model.Productos;

public interface IProductoService {

	public List<Productos>listar();
	public Optional<Productos>listarId(int idProductos);
	public int save(Productos productos);
	public void delete(int idProductos);
}
