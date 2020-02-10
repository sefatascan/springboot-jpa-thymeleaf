package com.sefa.anket.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sefa.anket.model.LifeQuality;
import com.sefa.anket.model.LifeQuality;
import com.sefa.anket.repository.LifeRepository;

@Service
public class LifeService {

	@Autowired
	private LifeRepository lifeRepo;

	// Read/all
	public List<LifeQuality> getAllLifes() {
		return (List<LifeQuality>) lifeRepo.findAll();
	}

	// Read/byId
	public Optional<LifeQuality> getLifesById(Integer id) {
		return lifeRepo.findById(id);
	}

	// Create and Update
	public void saveLifes(LifeQuality fan) {
		lifeRepo.save(fan);
	}

	// Delete
	public void deleteLifes(Integer id) {
		lifeRepo.deleteById(id);
	}

	public String getLifeStatistic() {
		double count = 0;
		List<LifeQuality> listLifes =  (List<LifeQuality>) lifeRepo.findAll();
		for(LifeQuality life : listLifes) {
			count = count + life.getLifeQuality();
		}
		
		return Double.toString(( count / listLifes.size()) * 10);
	}
}
