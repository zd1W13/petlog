package com.example.app.domain;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class Pet {

	// ペットID
	private Integer id;

	// ペット名
	@NotBlank(message = "ペット名を入力してください")
	@Size(max = 50, message = "ペット名は50文字以内で入力してください")
	private String name;

	// 種類
	@NotBlank(message = "種類を入力してください")
	private String species;

	// 品種
	@NotBlank(message = "品種を入力してください")
	private String breed;

	// 性別
	@NotBlank(message = "性別を入力してください")
	private String gender;

	// 生年月日
	// HTMLの日付形式（yyyy-MM-dd）をLocalDateとして受け取る
	@NotNull(message = "生年月日を入力してください")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthDate;

	// 体高
	@Positive(message = "体高は0より大きい数値を入力してください")
	private Double height;

	// 首回り
	@Positive(message = "首回りは0より大きい数値を入力してください")
	private Double neckSize;

	// 胴回り
	@Positive(message = "胴回りは0より大きい数値を入力してください")
	private Double chestSize;

	// 背丈
	@Positive(message = "背丈は0より大きい数値を入力してください")
	private Double bodyHeight;

	// 避妊・去勢の有無
	@NotNull(message = "避妊・去勢の有無を選択してください")
	private Boolean neutered;

	// 活動量レベル
	@NotBlank(message = "活動量を選択してください")
	private String activityLevel;

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