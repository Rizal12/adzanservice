package com.yukproduktif.controllers;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yukproduktif.models.AdzanCalculator;
import com.yukproduktif.models.PrayerTimes;

import net.minidev.json.JSONArray;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.HttpURLConnection;


import javax.net.ssl.HttpsURLConnection;
@RestController
public class MicroAdzan {
	private final String USER_AGENT = "Mozilla/5.0";
	/* 
	 * @RequestMapping(value = "/get_adzan", params = {"tanggal","bulan","tahun", "lokasi"}, method = RequestMethod.GET, produces = "application/json")
	 public String get_Adzan(Model model,@RequestParam(value = "tanggal") int tanggal,
			@RequestParam(value = "bulan") int bulan,
			@RequestParam(value = "tahun") int tahun, 
			@RequestParam(value = "lokasi") String lokasi){		
		
	 */
	@RequestMapping(value = "get_adzan/{tanggal}/{bulan}/{tahun}/{lokasi}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String get_Adzan(Model model,@PathVariable("tanggal") int tanggal,
			@PathVariable("bulan") int bulan,
			@PathVariable("tahun") int tahun, 
			@PathVariable("lokasi") String lokasi){		
		
		return PrayerTimes.getAdzan(tanggal, bulan, tahun, lokasi).ToJson();		
	}
	
	@RequestMapping(value = "get_adzan", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String get_Adzan_today(Model model){		
		Date date = new Date();
		
		return PrayerTimes.getAdzan(date.getDay(), date.getMonth(), date.getYear(), "bandung").ToJson();		
	}
	
	
	@RequestMapping(value = "get_adzan/{lokasi}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String get_Adzan_location(Model model,
			@PathVariable("lokasi") String lokasi){		
		Date date = new Date();
		
		return PrayerTimes.getAdzan(date.getDay(), date.getMonth(), date.getYear(), lokasi).ToJson();			
	}
	
	
	
	
}
