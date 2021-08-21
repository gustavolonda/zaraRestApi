package com.example.zara.Sevice.Generic;
import java.io.Serializable;


import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public abstract class GenericServiceImpl<T, ID extends Serializable> implements GenericServiceAPI<T, ID> {

	@Override
	public T save(T entity) {
       	return getDao().save(entity);
	}
	@Override
	public List<T> saveAll(Iterable<T> entityList) {
       	return getDao().saveAll(entityList);
	}


	@Override
	public void delete(ID id) {
        
		getDao().deleteById(id);
	}

	@Override
	public T get(ID id) {
		Optional<T> obj = getDao().findById(id);
		if (obj.isPresent()) {
			return obj.get();
		}
		return null;
	}

	@Override
	public List<T> getAll() {
		List<T> returnList = new ArrayList<>();
		getDao().findAll().forEach(obj -> returnList.add(obj));
		return returnList;
	}

	public abstract JpaRepository<T, ID> getDao();
}