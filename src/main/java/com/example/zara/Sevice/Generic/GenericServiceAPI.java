package com.example.zara.Sevice.Generic;

import java.io.Serializable;
import java.util.List;

//********************************************************//
//************* Interface Generic Service ****************//
//********************************************************//


public interface GenericServiceAPI<T, ID extends Serializable> {

	T save(T entity);

	List<T> saveAll(Iterable<T> entityList);

	void delete(ID id);
	
	T get(ID id);
	
	List<T> getAll();
}