package com.yukproduktif.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yukproduktif.models.AdzanCalculator;
import com.yukproduktif.models.PrayerTimes;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
@RestController
public class MicroAdzan {
	@RequestMapping(value = "/get_adzan", params = {"tanggal","bulan","tahun", "lokasi"}, method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String get_Adzan(Model model,@RequestParam(value = "tanggal") int tanggal,
			@RequestParam(value = "bulan") int bulan,
			@RequestParam(value = "tahun") int tahun, 
			@RequestParam(value = "lokasi") String lokasi){		
		
		return PrayerTimes.getAdzan(tanggal, bulan, tahun).ToJson();
		
		
	
	}
}
