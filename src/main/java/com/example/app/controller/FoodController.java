package com.example.app.controller;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.app.domain.Food;
import com.example.app.domain.HealthRecord;
import com.example.app.domain.Pet;
import com.example.app.service.FeedingCalculationService;
import com.example.app.service.FoodService;
import com.example.app.service.HealthRecordService;
import com.example.app.service.PetService;

@Controller
@RequestMapping("/pets/{petId}/foods")
public class FoodController {

    private final FoodService foodService;
    private final PetService petService;
    private final FeedingCalculationService feedingCalculationService;
    private final HealthRecordService healthRecordService;

    public FoodController(
            FoodService foodService,
            PetService petService,
            FeedingCalculationService feedingCalculationService,
            HealthRecordService healthRecordService) {

        this.foodService = foodService;
        this.petService = petService;
        this.feedingCalculationService = feedingCalculationService;
        this.healthRecordService = healthRecordService;
    }


    // フード管理画面を表示する
    @GetMapping
    public String showFoodList(
            @PathVariable Integer petId,
            Model model) {

        model.addAttribute("pet", petService.getPetById(petId));
        model.addAttribute("foodList", foodService.getFoodList(petId));

        return "foods/list";
    }


    // フード登録画面を表示する
    @GetMapping("/add")
    public String showAddForm(
            @PathVariable Integer petId,
            Model model) {

        Food food = new Food();

        food.setPetId(petId);

        model.addAttribute("food", food);
        model.addAttribute("pet", petService.getPetById(petId));

        return "foods/add";
    }


    // フードを登録する
    @PostMapping("/add")
    public String addFood(
            @PathVariable Integer petId,
            @Valid Food food,
            BindingResult result,
            Model model) {

        // URLから受け取ったペットIDをFoodに設定する
        food.setPetId(petId);

        // バリデーションエラーがある場合
        if (result.hasErrors()) {

            // 入力画面で必要なペット情報を再度渡す
            model.addAttribute("pet", petService.getPetById(petId));

            // 登録画面へ戻る
            return "foods/add";
        }

        // エラーがなければ登録する
        foodService.addFood(food);

        return "redirect:/pets/" + petId + "/foods";
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
            @Valid Food food,
            BindingResult result,
            Model model) {

        // URLから受け取ったIDをFoodに設定する
        food.setId(id);
        food.setPetId(petId);

        // バリデーションエラーがある場合
        if (result.hasErrors()) {

            // 編集画面で必要なペット情報を再度渡す
            model.addAttribute("pet", petService.getPetById(petId));

            // 編集画面へ戻る
            return "foods/edit";
        }

        // エラーがなければ更新する
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


    // フード給餌量計算画面を表示する
    @GetMapping("/calculation")
    public String showCalculation(
            @PathVariable Integer petId,
            Model model) {

        // ペット情報を取得して画面に渡す
        model.addAttribute("pet", petService.getPetById(petId));

        // このペットに登録されているフード一覧を取得して画面に渡す
        model.addAttribute("foodList", foodService.getFoodList(petId));

        return "foods/calculation";
    }


    // 「計算」ボタンを押したときの処理
    @PostMapping("/calculation")
    public String calculateFeedingAmount(
            @PathVariable Integer petId,
            Integer foodId,
            Model model) {

        // ペット情報を取得する
        Pet pet = petService.getPetById(petId);

        // 選択されたフードの情報を取得する
        Food food = foodService.getFoodById(foodId);

        // 最新の健康記録を取得する
        HealthRecord latestRecord =
                healthRecordService.getLatestHealthRecord(petId);

        // 最新の健康記録があり、体重も登録されている場合
        if (latestRecord != null
                && latestRecord.getWeight() != null) {

            try {

                // 1日の必要カロリーを計算する
                double dailyCalories =
                        feedingCalculationService.calculateDailyCalories(
                                latestRecord.getWeight(),
                                pet.getSpecies(),
                                pet.getActivityLevel(),
                                Boolean.TRUE.equals(pet.getNeutered()));

                // 1日の給餌量を計算する
                double feedingAmount =
                        feedingCalculationService.calculateFeedingAmount(
                                dailyCalories,
                                food.getCalorie());

                // 計算結果を画面に渡す
                model.addAttribute(
                        "dailyCalories",
                        Math.round(dailyCalories));

                model.addAttribute(
                        "feedingAmount",
                        Math.round(feedingAmount));

            } catch (IllegalArgumentException e) {

                // 犬・猫以外の場合はメッセージを画面に渡す
                model.addAttribute(
                        "calculationError",
                        e.getMessage());
            }

        } else {

            // 健康記録または体重が登録されていない場合
            model.addAttribute(
                    "calculationError",
                    "健康記録に体重を登録してください。");
        }

        // ペット情報とフード一覧を画面に渡す
        model.addAttribute("pet", pet);
        model.addAttribute(
                "foodList",
                foodService.getFoodList(petId));

        return "foods/calculation";
    }
}