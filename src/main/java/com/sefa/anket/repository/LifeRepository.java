package com.sefa.anket.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sefa.anket.model.LifeQuality;

@Repository
public interface LifeRepository extends CrudRepository<LifeQuality, Integer> {

}
