package com.example.app.domain;

import java.time.LocalDate;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class HealthRecord {

    // 健康記録ID
    private Integer id;

    // ペットID
    private Integer petId;

    // 記録日
    @NotNull(message = "記録日を入力してください")
    @PastOrPresent(message = "記録日は本日以前の日付を入力してください")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate recordDate;

    // 体重
    @NotNull(message = "体重を入力してください")
    @Positive(message = "体重は0より大きい数値を入力してください")
    private Double weight;

    // うんちの状態
    @NotNull(message = "うんちの状態を選択してください")
    private String poopCondition;

    // おしっこの回数
    @NotNull(message = "おしっこの回数を入力してください")
    @Min(value = 0, message = "おしっこの回数は0回以上で入力してください")
    private Integer urinationCount;

 // 嘔吐の有無
    @NotNull(message = "嘔吐の有無を選択してください")
    private Boolean vomiting;

    // 食事量（朝）
    @Min(value = 1, message = "朝の食事量は1g以上で入力してください")
    private Integer morningFoodAmount;

    // 食べていない（朝）
    private Boolean morningNoMeal;

    // 食事量（晩）
    @Min(value = 1, message = "晩の食事量は1g以上で入力してください")
    private Integer eveningFoodAmount;

    // 食べていない（晩）
    private Boolean eveningNoMeal;

    // メモ
    @Size(max = 255, message = "メモは255文字以内で入力してください")
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