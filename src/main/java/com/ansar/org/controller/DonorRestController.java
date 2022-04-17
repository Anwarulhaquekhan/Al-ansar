package com.ansar.org.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ansar.org.domain.Donor;
import com.ansar.org.services.DonorService;
import com.ansar.org.vo.DonorVo;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/donor")
@RequiredArgsConstructor
public class DonorRestController {

	private final DonorService donorservice;

	@PostMapping("/add")
	public void addDonorDetail(@RequestBody DonorVo criteria) throws ParseException {
		donorservice.addDonorDetail(criteria);

	}

	@GetMapping("/donor/fetch")
	public List<Donor> fetchAll() {
		return donorservice.fetchAll();
	}

	@GetMapping("fetchAll/amount")
	public List<Donor> fetchByAmount(@RequestParam Double amount) throws Exception {

		return donorservice.fetchByAmount(amount);

	}

}
