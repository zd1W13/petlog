package com.example.app.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.app.domain.HealthRecord;
import com.example.app.service.HealthRecordService;



@Controller
@RequestMapping("/pets/{petId}/health/graph")

public class HealthGraphController {

	private final HealthRecordService healthRecordService;

	public HealthGraphController(HealthRecordService healthRecordService) {
		this.healthRecordService = healthRecordService;
	}

	@GetMapping
	public String showGraph(@PathVariable int petId, Model model) {

		List<HealthRecord> records = healthRecordService.getLastMonthHealthRecords(petId);
		
		model.addAttribute("records", records);
		model.addAttribute("petId", petId);
		
		return "health/graph";
	}

}
