package com.conde.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conde.demo.interfaceService.IProductoService;
import com.conde.demo.interfaces.IProductos;
import com.conde.demo.model.Productos;

@Service
public class ProductosService implements IProductoService {

	@Autowired
	IProductos data;
	@Override
	public List<Productos> listar() {
		return (List<Productos>)data.findAll();

	}

	@Override
	public Optional<Productos> listarId(int idProductos) {
		return data.findById(idProductos);
	}

	@Override
	public int save(Productos productos) {
		int res=0;
		Productos cliente=data.save(productos);
		if(!cliente.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(int idProductos) {
		data.deleteById(idProductos);
		
	}

}
