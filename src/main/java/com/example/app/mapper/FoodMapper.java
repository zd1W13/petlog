package com.example.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.domain.Food;

@Mapper
public interface FoodMapper {

	// 指定したペットのフードをすべて取得する
	public List<Food> selectByPetId(Integer petId);
	
	// IDを指定してフードを1件取得する
	public Food selectById(Integer id);
	
	// フードを登録する
	public void insert(Food food);
	
	// フードを更新する
	public void update(Food food);
	
	// フードを削除する
	public void delete(Integer id);
	
}
