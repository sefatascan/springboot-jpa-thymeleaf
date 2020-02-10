package com.sefa.anket.service;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Service;

import com.sefa.anket.model.FansOfTeam;
import com.sefa.anket.repository.TeamRepository;

@Service
public class TeamService {
	@Autowired
	private TeamRepository teamRepo;

	// Read/all
	public List<FansOfTeam> getAllFans() {
		return (List<FansOfTeam>) teamRepo.findAll();
	}

	// Read/byId
	public Optional<FansOfTeam> getFansById(Integer id) {
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

	// create hashtable -- key = unique teamName , value = counter
	public Map<String, Integer> creatHashtable() {
		Map<String, Integer> map = new Hashtable<>();
		List<FansOfTeam> listFans = (List<FansOfTeam>) teamRepo.findAll();
		for (FansOfTeam fans : listFans) {
			try {
				int count = map.containsKey(fans.getChosenTeam()) ? map.get(fans.getChosenTeam()) : 0;
				map.put(fans.getChosenTeam(), count + 1);

			} catch (Exception e) {
				System.err.println(e);
			}

		}
		return map;
	}
}
