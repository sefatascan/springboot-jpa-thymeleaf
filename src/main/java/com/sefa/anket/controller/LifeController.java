package com.sefa.anket.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sefa.anket.model.FansOfTeam;
import com.sefa.anket.model.LifeQuality;
import com.sefa.anket.service.LifeService;

@Controller
public class LifeController {

	@Autowired
	private LifeService lifeService;

	@GetMapping("/lifes")
	public String lifes(Model model) {
		model.addAttribute("lifes", lifeService.getAllLifes());
		return "lifes";
	}

	@RequestMapping(value = "/saveLife", method = { RequestMethod.POST, RequestMethod.PUT, RequestMethod.GET })
	public String save(LifeQuality life) {
		lifeService.saveLifes(life);
		return "redirect:/lifes";
	}

	@GetMapping("/findLife")
	@ResponseBody
	public Optional<LifeQuality> find(Integer id) {
		return lifeService.getLifesById(id);
	}
	@RequestMapping(value = "/deleteLifes", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String deleteLifes(Integer id) {
		lifeService.deleteLifes(id);
		return "redirect:/lifes";
	}

}
