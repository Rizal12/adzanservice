package com.yukproduktif.models;

import java.util.ArrayList;
import java.util.Calendar;

public class Adzan {
	/*     
	Fajr
    Sunrise
    Dhuhr
   	Asr
    Sunset
    Maghrib
    Isha
    */
	
     
	ArrayList<String> prayerTimes;
	ArrayList<String> prayerNames = new ArrayList<String>();
	public Adzan(){		
		this.CreatePrayerNames();
	}
	private void CreatePrayerNames(){
		prayerNames.add("shubuh");
		prayerNames.add("sunrise");
		prayerNames.add("dzuhur");
		prayerNames.add("ashar");
		prayerNames.add("sunset");
		prayerNames.add("magrib");
		prayerNames.add("isya");
	}
	public Adzan(ArrayList<String> pray){
		this.CreatePrayerNames();
		this.prayerTimes = pray;
	}
	public String ToJson(){
		String n = "{";   	 		
        for (int i = 0; i < prayerTimes.size(); i++) {
            n = n + "\"" + prayerNames.get(i) + "\" : \"" + prayerTimes.get(i) + "\"";
            if(i < prayerTimes.size() - 1){
            	n = n + ",";
            }
        }
        n = n + "}";
        return n;
	}
	public void SetPrayerTimes(ArrayList<String> pray){		
		this.prayerTimes = pray;
	}
}
