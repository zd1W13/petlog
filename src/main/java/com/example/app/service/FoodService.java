package com.example.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.app.domain.Food;
import com.example.app.mapper.FoodMapper;

@Service
public class FoodService {

	private final FoodMapper foodMapper;
	
	public FoodService(FoodMapper foodMapper) {
		this.foodMapper = foodMapper;
	}
	
	// 指定したペットのフード一覧を取得する
	public List<Food> getFoodList(Integer petId) {
		return foodMapper.selectByPetId(petId);
	}
	
	// IDを指定してフードを1件取得する
	public Food getFoodById(Integer id) {
		return foodMapper.selectById(id);
	}
	
	// フードを登録する
	public void addFood(Food food) {
		foodMapper.insert(food);
	}
	
	// フードを更新する
	public void updateFood(Food food) {
		foodMapper.update(food);
	}
	
	// フードを削除する
	public void deleteFood(Integer id) {
		foodMapper.delete(id);
	}
}
