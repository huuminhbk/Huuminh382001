package com.hm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hm.entity.Fruit;

@Repository
public interface FruitRepository extends CrudRepository<Fruit, Long>{

}
