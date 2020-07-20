package com.conde.demo.interfaces;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.conde.demo.model.Usuario;

@Repository
public interface IUsuario  extends CrudRepository<Usuario,Integer>{

	Usuario findBynombre(String username);



}
