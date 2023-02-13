package com.hm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.entity.Fruit;
import com.hm.repository.FruitRepository;

@Service
public class FruitServiceImpl implements FruitService{
	@Autowired
	private FruitRepository fruitrepo;

	@Override
	public List<Fruit> getlistFruit() {
		List<Fruit> list = (List<Fruit>) fruitrepo.findAll();
		
		return list;
	}

	@Override
	public void deleteFruit(Long id) {
		fruitrepo.deleteById(id);
		
	}

	@Override
	public void saveFruit(Fruit fruit) {
		fruitrepo.save(fruit);
		
	}

	@Override
	public Optional<Fruit> findFruitById(Long id) {
		return fruitrepo.findById(id);
	}

}
