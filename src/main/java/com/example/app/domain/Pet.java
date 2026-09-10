package com.example.app.domain;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class Pet {

	// ペットID
	private Integer id;

	// ペット名
	private String name;

	// 種類
	private String species;

	// 品種
	private String breed;

	// 性別
	private String gender;

	// 生年月日
	// HTMLの日付形式（yyyy-MM-dd）をLocalDateとして受け取る
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthDate;

	// 体高
	private Double height;

	// 首回り
	private Double neckSize;

	// 胴回り
	private Double chestSize;

	// 背丈
	private Double bodyHeight;

	// 避妊・去勢の有無
	private Boolean neutered;

	// 活動量レベル
	private String activityLevel;

	// メモ
	private String memo;

	// ===== Getter / Setter =====

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public Double getNeckSize() {
		return neckSize;
	}

	public void setNeckSize(Double neckSize) {
		this.neckSize = neckSize;
	}

	public Double getChestSize() {
		return chestSize;
	}

	public void setChestSize(Double chestSize) {
		this.chestSize = chestSize;
	}

	public Double getBodyHeight() {
		return bodyHeight;
	}

	public void setBodyHeight(Double bodyHeight) {
		this.bodyHeight = bodyHeight;
	}

	public Boolean getNeutered() {
		return neutered;
	}

	public void setNeutered(Boolean neutered) {
		this.neutered = neutered;
	}

	public String getActivityLevel() {
		return activityLevel;
	}

	public void setActivityLevel(String activityLevel) {
		this.activityLevel = activityLevel;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
}