package com.example.app.domain;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Food {

	 // フードID
    private Integer id;

    // ペットID
    private Integer petId;

    // フード名
    @NotBlank(message = "フード名を入力してください")
    @Size(max = 50, message = "フード名は50文字以内で入力してください")
    private String foodName;

    // カロリー（100gあたり）
    @NotNull(message = "カロリーを入力してください")
    @Min(value = 1, message = "カロリーは1以上で入力してください")
    private Integer calorie;

    // 食いつき
    @NotNull(message = "食いつきを選択してください")
    private Integer palatability;

    // メモ
    @Size(max = 200, message = "メモは200文字以内で入力してください")
    private String memo;

 // ===== Getter / Setter =====
    
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
