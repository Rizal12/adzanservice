package com.microadzan.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.microadzan.models.Adzan_Calculator;
import com.microadzan.models.PrayerTimes;
@RestController
public class microadzan {
	@RequestMapping(value = "/get_adzan", params = {"tanggal","bulan","tahun", "lokasi"}, method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String get_Adzan(Model model,@RequestParam(value = "tanggal") int tanggal,
			@RequestParam(value = "bulan") int bulan,
			@RequestParam(value = "tahun") int tahun, 
			@RequestParam(value = "lokasi") String lokasi){		
		
		return PrayerTimes.getAdzan(tanggal, bulan, tahun).ToJson();
		
		
		//return Adzan_Calculator.getAdzan_2(tanggal, bulan, tahun);
		/*return "{ "
				+ "\"Shubuh\" : \"05:00\", "
				+ "\"Dzuhur\" : \"12:00\", "
				+ "\"Ashar\" : \"15:00\", "
				+ "\"Magrib\" : \"06:00\", "
				+ "\"Isya\" : \"07:00\" "
				+ "}";*/
	}
}
