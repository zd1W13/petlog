package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.app.service.PetService;

@Controller
public class TopController {

    // ペット情報を扱うService
    private final PetService petService;

    // PetServiceを使えるようにする
    public TopController(PetService petService) {
        this.petService = petService;
    }

    // TOP画面を表示する
    @GetMapping("/")
    public String showTop(Model model) {

        // 登録されているペット一覧を取得して画面へ渡す
        model.addAttribute("petList", petService.getPetList());

        return "top";
    }
}