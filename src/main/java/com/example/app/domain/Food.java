package com.example.app.domain;

public class Food {

	// フードID
	private Integer id;
	
	// ペットID
	private Integer petId;
	
	// フード名
	private String foodName;
	
	// カロリー（100gあたり）
	private Integer calorie;
	
	// 食いつき
	private Integer palatability;
	
	// メモ
	private String memo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPetId() {
		return petId;
	}

	public void setPetId(Integer petId) {
		this.petId = petId;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public Integer getCalorie() {
		return calorie;
	}

	public void setCalorie(Integer calorie) {
		this.calorie = calorie;
	}

	public Integer getPalatability() {
		return palatability;
	}

	public void setPalatability(Integer palatability) {
		this.palatability = palatability;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	
}
