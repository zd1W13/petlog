package com.example.app.domain;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class HealthRecord {

    // 健康記録ID
    private Integer id;

    // ペットID
    private Integer petId;

    // 記録日
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate recordDate;

    // 体重
    private Double weight;

    // うんちの状態
    private String poopCondition;

    // おしっこの回数
    private Integer urinationCount;

    // 嘔吐の有無
    private Boolean vomiting;

    // 食事量（朝）
    private Integer morningFoodAmount;

    // 食べていない（朝）
    private Boolean morningNoMeal;

    // 食事量（晩）
    private Integer eveningFoodAmount;

    // 食べていない（晩）
    private Boolean eveningNoMeal;

    // メモ
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

    public LocalDate getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(LocalDate recordDate) {
        this.recordDate = recordDate;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getPoopCondition() {
        return poopCondition;
    }

    public void setPoopCondition(String poopCondition) {
        this.poopCondition = poopCondition;
    }

    public Integer getUrinationCount() {
        return urinationCount;
    }

    public void setUrinationCount(Integer urinationCount) {
        this.urinationCount = urinationCount;
    }

    public Boolean getVomiting() {
        return vomiting;
    }

    public void setVomiting(Boolean vomiting) {
        this.vomiting = vomiting;
    }

    public Integer getMorningFoodAmount() {
        return morningFoodAmount;
    }

    public void setMorningFoodAmount(Integer morningFoodAmount) {
        this.morningFoodAmount = morningFoodAmount;
    }

    public Boolean getMorningNoMeal() {
        return morningNoMeal;
    }

    public void setMorningNoMeal(Boolean morningNoMeal) {
        this.morningNoMeal = morningNoMeal;
    }

    public Integer getEveningFoodAmount() {
        return eveningFoodAmount;
    }

    public void setEveningFoodAmount(Integer eveningFoodAmount) {
        this.eveningFoodAmount = eveningFoodAmount;
    }

    public Boolean getEveningNoMeal() {
        return eveningNoMeal;
    }

    public void setEveningNoMeal(Boolean eveningNoMeal) {
        this.eveningNoMeal = eveningNoMeal;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}