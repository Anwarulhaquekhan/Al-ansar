package com.ansar.org.controller;

import java.text.ParseException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ansar.org.services.DonorService;
import com.ansar.org.vo.DonorVo;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("donor")
@RequiredArgsConstructor
public class DonorController {

	private final DonorService donorservice;

	@GetMapping("/")
	public String addDonorDetail(Model model) throws ParseException {
		model.addAttribute("donors", donorservice.convertDonorsToDonorVo(donorservice.fetchAll()));
		return "donor";
	}
}
