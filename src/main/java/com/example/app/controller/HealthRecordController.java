package com.example.app.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.app.domain.HealthRecord;
import com.example.app.domain.Pet;
import com.example.app.service.HealthRecordService;
import com.example.app.service.PetService;

@Controller
public class HealthRecordController {

    // 健康記録に関する処理を行うService
    private final HealthRecordService healthRecordService;

    // ペット情報に関する処理を行うService
    private final PetService petService;


    // Serviceを使えるようにする
    public HealthRecordController(
            HealthRecordService healthRecordService,
            PetService petService) {

        this.healthRecordService = healthRecordService;
        this.petService = petService;
    }


    // ========================================
    // 健康記録画面を表示する
    // ========================================
    @GetMapping("/pets/{petId}/records")
    public String showRecords(
            @PathVariable Integer petId,
            @RequestParam(required = false) LocalDate date,
            Model model) {

        // 対象のペット情報を取得する
        Pet pet = petService.getPetById(petId);

        // このペットの健康記録をすべて取得する
        List<HealthRecord> recordList =
                healthRecordService.getHealthRecordList(petId);

        // 日付が指定されていない場合は今日の日付を使用する
        LocalDate selectedDate =
                (date != null) ? date : LocalDate.now();

        // 選択された日付の健康記録を取得する
        HealthRecord selectedRecord =
                healthRecordService.getHealthRecordByDate(
                        petId,
                        selectedDate);

        // 画面へ渡す
        model.addAttribute("pet", pet);
        model.addAttribute("recordList", recordList);
        model.addAttribute("selectedDate", selectedDate);
        model.addAttribute("selectedRecord", selectedRecord);

        // 健康記録画面を表示する
        return "health/records";
    }


    // ========================================
    // 健康記録登録画面を表示する
    // ========================================
    @GetMapping("/pets/{petId}/records/add")
    public String showAddForm(
            @PathVariable Integer petId,
            Model model) {

        // 対象のペット情報を取得する
        Pet pet = petService.getPetById(petId);

        // 新しく入力する健康記録を作る
        HealthRecord healthRecord = new HealthRecord();

        // ペットIDを設定する
        healthRecord.setPetId(petId);

        // 初期表示では今日の日付を設定する
        healthRecord.setRecordDate(LocalDate.now());

        // 「食べていない」の初期値をfalseにする
        healthRecord.setMorningNoMeal(false);
        healthRecord.setEveningNoMeal(false);

        // 嘔吐の初期値を「なし」にする
        healthRecord.setVomiting(false);

        // 画面へ渡す
        model.addAttribute("pet", pet);
        model.addAttribute("healthRecord", healthRecord);

        // 健康記録登録画面を表示する
        return "health/recordAdd";
    }


    // ========================================
    // 健康記録を登録する
    // ========================================
    @PostMapping("/pets/{petId}/records/add")
    public String addHealthRecord(
            @PathVariable Integer petId,
            HealthRecord healthRecord) {

        // URLから受け取ったペットIDを設定する
        healthRecord.setPetId(petId);

        // 健康記録をDBへ登録する
        healthRecordService.addHealthRecord(healthRecord);

        // 登録後は健康記録画面へ戻る
        return "redirect:/pets/" + petId + "/records";
    }


    // ========================================
    // 健康記録編集画面を表示する
    // ========================================
    @GetMapping("/pets/{petId}/records/edit/{id}")
    public String showEditForm(
            @PathVariable Integer petId,
            @PathVariable Integer id,
            Model model) {

        // 対象のペット情報を取得する
        Pet pet = petService.getPetById(petId);

        // 編集する健康記録を取得する
        HealthRecord healthRecord =
                healthRecordService.getHealthRecordById(id);

        // 画面へ渡す
        model.addAttribute("pet", pet);
        model.addAttribute("healthRecord", healthRecord);

        // 健康記録編集画面を表示する
        return "health/recordEdit";
    }


    // ========================================
    // 健康記録を更新する
    // ========================================
    @PostMapping("/pets/{petId}/records/edit/{id}")
    public String updateHealthRecord(
            @PathVariable Integer petId,
            @PathVariable Integer id,
            HealthRecord healthRecord) {

        // URLの健康記録IDを設定する
        healthRecord.setId(id);

        // URLのペットIDを設定する
        healthRecord.setPetId(petId);

        // DBの健康記録を更新する
        healthRecordService.updateHealthRecord(healthRecord);

        // 更新した日付の健康記録画面へ戻る
        return "redirect:/pets/"
                + petId
                + "/records?date="
                + healthRecord.getRecordDate();
    }


    // ========================================
    // 健康記録を削除する
    // ========================================
    @PostMapping("/pets/{petId}/records/delete/{id}")
    public String deleteHealthRecord(
            @PathVariable Integer petId,
            @PathVariable Integer id) {

        // 指定した健康記録をDBから削除する
        healthRecordService.deleteHealthRecord(id);

        // 削除完了の情報を付けて健康記録画面へ戻る
        return "redirect:/pets/" + petId + "/records?deleted=true";
    }

}