package com.sefa.anket.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sefa.anket.model.FansOfTeam;

@Repository
public interface TeamRepository extends CrudRepository<FansOfTeam, Integer> {

}
