package com.sefa.anket.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sefa.anket.model.FansOfTeam;
import com.sefa.anket.service.TeamService;

@Controller
public class TeamController {

	@Autowired
	private TeamService teamService;

	@GetMapping("/fans")
	public String fans(Model model) {
		model.addAttribute("fans", teamService.getAllFans());
		return "fans";
	}

	@RequestMapping(value = "/saveFans", method = { RequestMethod.POST, RequestMethod.PUT, RequestMethod.GET })
	public String saveFans(FansOfTeam fan) {
		teamService.saveFans(fan);
		return "redirect:/fans";
	}

	@GetMapping("/findFan")
	@ResponseBody
	public Optional<FansOfTeam> find(Integer id) {
		return teamService.getFansById(id);
	}

	@RequestMapping(value = "/deleteFans", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String deleteFans(Integer id) {
		teamService.deleteFans(id);
		return "redirect:/fans";
	}

}
