package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.app.domain.Food;
import com.example.app.service.FoodService;
import com.example.app.service.PetService;

@Controller
@RequestMapping("/pets/{petId}/foods")
public class FoodController {

	private final FoodService foodService;
	private final PetService petService;
	
	public FoodController(FoodService foodService, PetService petService) {
		this.foodService = foodService;
		this.petService = petService;
	}
	
	// フード管理画面を表示する
	@GetMapping
	public String showFoodList(@PathVariable Integer petId, Model model) {
		
		model.addAttribute("pet", petService.getPetById(petId));
		model.addAttribute("foodList", foodService.getFoodList(petId));
		
		return "foods/list";
	}
	
	// フード登録画面を表示する
	@GetMapping("/add")
	public String showAddForm(@PathVariable Integer petId, Model model) {
		
		Food food = new Food();
		food.setPetId(petId);
		
		model.addAttribute("food", food);
		model.addAttribute("pet", petService.getPetById(petId));
		
		return "foods/add";
	}
	
	// フードを登録する
	@PostMapping("/add")
	public String addFood(@PathVariable Integer petId, Food food) {
		
		food.setPetId(petId);
		foodService.addFood(food);
		
		return "redirect:/pets/" + petId  + "/foods";
	}
	
	 // フード編集画面を表示する
	@GetMapping("/edit/{id}")
	public String showEditForm(
			@PathVariable Integer petId,
			@PathVariable Integer id,
			Model model) {
		
		model.addAttribute("food", foodService.getFoodById(id));
		model.addAttribute("pet", petService.getPetById(petId));
		return "foods/edit";
		
	}
	
	// フードを更新する
	@PostMapping("/edit/{id}")
	public String updateFood(
			@PathVariable Integer petId,
			@PathVariable Integer id,
			Food food) {
		
		food.setId(id);
		food.setPetId(petId);
		
		foodService.updateFood(food);
		
		return "redirect:/pets/" + petId + "/foods";
		
	}
	
	// フードを削除する
	@PostMapping("/delete/{id}")
	public String deleteFood(
			@PathVariable Integer petId,
			@PathVariable Integer id) {
		
		foodService.deleteFood(id);
		
		return "redirect:/pets/" + petId + "/foods";
	}
	
	
}
