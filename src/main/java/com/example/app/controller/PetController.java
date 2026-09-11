package com.example.app.controller;

import java.time.LocalDate;
import java.time.Period;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.app.domain.Pet;
import com.example.app.service.PetService;

@Controller
public class PetController {

	// ペットに関する処理を行うService
	private final PetService petService;

	// PetServiceを受け取って使えるようにする
	public PetController(PetService petService) {
		this.petService = petService;
	}

	// ペット詳細画面を表示する
	@GetMapping("/pets/{id}")
	public String showDetail(
			@PathVariable Integer id,
			Model model) {

		// IDを使って対象のペット情報を1件取得する
		Pet pet = petService.getPetById(id);

		// 生年月日から現在の年齢を計算する
		int age = Period.between(
				pet.getBirthDate(),
				LocalDate.now()).getYears();

		// ペット情報を画面へ渡す
		model.addAttribute("pet", pet);

		// 計算した年齢を画面へ渡す
		model.addAttribute("age", age);

		return "pet/petDetail";
	}

	// ペット登録画面を表示する
	@GetMapping("/pets/add")
	public String showAddForm(Model model) {

		// 登録フォームで使用する空のPetオブジェクトを渡す
		model.addAttribute("pet", new Pet());

		return "pet/petAdd";
	}

	// ペット登録処理
	@PostMapping("/pets/add")
	public String add(@Valid Pet pet,
			BindingResult result) {

		// バリデーションエラーがある場合は登録画面へ戻る
		if (result.hasErrors()) {
			return "pet/petAdd";
		}

		// 入力されたペット情報をDBへ登録する
		petService.addPet(pet);

		// 登録後はTOP画面へ戻る
		return "redirect:/";
	}

	// ペット編集画面を表示する
	@GetMapping("/pets/edit/{id}")
	public String showEditForm(
			@PathVariable Integer id,
			Model model) {

		// 編集するペット情報をDBから取得する
		Pet pet = petService.getPetById(id);

		// 現在のペット情報を編集画面へ渡す
		model.addAttribute("pet", pet);

		return "pet/petEdit";
	}

	// ペット情報を更新する
	@PostMapping("/pets/edit/{id}")
	public String edit(
			@PathVariable Integer id,
			@Valid Pet pet,
			BindingResult result) {

		// URLから受け取ったIDをPetオブジェクトに設定する
		pet.setId(id);

		// バリデーションエラーがある場合は編集画面へ戻る
		if (result.hasErrors()) {
			return "pet/petEdit";
		}

		// 入力された内容でDBを更新する
		petService.updatePet(pet);

		// 更新後はTOP画面へ戻る
		return "redirect:/";
	}

	// ペット情報を削除する
	@PostMapping("/pets/delete/{id}")
	public String delete(@PathVariable Integer id) {

		// 指定されたIDのペット情報を削除する
		petService.deletePet(id);

		// 削除後は「削除完了」の情報を付けてTOP画面へ戻る
		return "redirect:/?deleted=true";
	}
}