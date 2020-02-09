package com.sefa.anket.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sefa.anket.model.FansOfTeam;
import com.sefa.anket.repository.TeamRepository;

@Service
public class TeamService {
	@Autowired
	private TeamRepository teamRepo;
	
	// Read/all
	public List<FansOfTeam> getAllFans(){
		return (List<FansOfTeam>) teamRepo.findAll();
	}
	// Read/byId
	public Optional<FansOfTeam> getFansById(Integer id){
		return teamRepo.findById(id);
	}
	// Create and Update
	public void saveFans(FansOfTeam fan) {
		teamRepo.save(fan);
	}
	// Delete
	public void deleteFans(Integer id) {
		teamRepo.deleteById(id);
	}

}
