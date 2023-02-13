package com.hm.service;

import java.util.List;
import java.util.Optional;

import com.hm.entity.Fruit;


public interface FruitService {
	List<Fruit> getlistFruit();
	void deleteFruit(Long id);
	void saveFruit(Fruit fruit);
	Optional<Fruit> findFruitById(Long id);
	

}
