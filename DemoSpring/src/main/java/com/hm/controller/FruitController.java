package com.hm.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.hm.entity.Fruit;
import com.hm.service.FruitService;

@Controller

public class FruitController {

	@Autowired
	private FruitService fruitService;

	@RequestMapping("/")
	public String index(Model model) {
		List<Fruit> fruits = fruitService.getlistFruit();
		model.addAttribute("fruit", fruits);

		return "index";

	}

	@RequestMapping(value = "add")
	public String addUser(Model model) {
		model.addAttribute("fruit", new Fruit());
		return "Add";
	}

	@GetMapping("/edit")
	public String editUser(@RequestParam("id") Long fruitId, Model model) {
		Optional<Fruit> fruitEdit = fruitService.findFruitById(fruitId);
		fruitEdit.ifPresent(fr -> model.addAttribute("fruit", fr));
		return "Edit";
	}

	@PostMapping("save")
	public String save(Fruit fruit) {
		fruitService.saveFruit(fruit);
		return "redirect:/";
	}

	@DeleteMapping("/delete")
	public String deleteFruit(@RequestParam("id") Long fruitId) {
		fruitService.deleteFruit(fruitId);
		return "redirect:/";
	}

}
