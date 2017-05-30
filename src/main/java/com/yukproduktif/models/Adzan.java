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
		prayerNames.add("Shubuh");
		prayerNames.add("Sunrise");
		prayerNames.add("Dzuhur");
		prayerNames.add("Ashar");
		prayerNames.add("Sunset");
		prayerNames.add("Magrib");
		prayerNames.add("Isya");
	}
	public Adzan(ArrayList<String> pray){
		/*prayerNames.add("Fajr");
		prayerNames.add("Sunrise");
		prayerNames.add("Dhuhr");
		prayerNames.add("Asr");
		prayerNames.add("Sunset");
		prayerNames.add("Maghrib");
		prayerNames.add("Isha");*/
		prayerNames.add("Shubuh");
		prayerNames.add("Sunrise");
		prayerNames.add("Dzuhur");
		prayerNames.add("Ashar");
		prayerNames.add("Sunset");
		prayerNames.add("Magrib");
		prayerNames.add("Isya");
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
