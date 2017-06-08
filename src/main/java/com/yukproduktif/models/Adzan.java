package com.yukproduktif.models;

import org.joda.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import org.joda.time.chrono.IslamicChronology;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.Chronology;
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
	private LocalDate tanggal;
	public Adzan(){		
		this.CreatePrayerNames();
	}
	private void CreatePrayerNames(){
		/*prayerNames.add("shubuh");
		prayerNames.add("sunrise");
		prayerNames.add("dzuhur");
		prayerNames.add("ashar");
		prayerNames.add("sunset");
		prayerNames.add("magrib");
		prayerNames.add("isya");*/
		
		prayerNames.add("shubuh");
		//prayerNames.add("sunrise"); //1
		prayerNames.add("dzuhur"); //2
		prayerNames.add("ashar"); //3
		//prayerNames.add("sunset"); //4
		prayerNames.add("magrib");
		prayerNames.add("isya");
	}
	public Adzan(ArrayList<String> pray){
		this.CreatePrayerNames();
		this.prayerTimes = pray;
		
		this.tanggal = LocalDate.now();		
	}
	public Adzan(ArrayList<String> pray, int d, int m, int y){
		this.CreatePrayerNames();
		this.prayerTimes = pray;
		
		this.SetDate(d, m, y);
	}
	
	
	public void SetDate(int d, int m, int y){
		Chronology iso = ISOChronology.getInstanceUTC();
		this.tanggal = new LocalDate(y,m,d,iso);
	}
	public String ToJson(){
		int d = tanggal.getDayOfMonth();
		int m = tanggal.getMonthOfYear();
		int y = tanggal.getYear();
		String n = "{ \"masehi\" : \"" + Integer.toString(d) + "/" + Integer.toString(m) + "/" + Integer.toString(y) + "\"";
		//Hijriyah
		Chronology hijri = IslamicChronology.getInstanceUTC();
		LocalDate todayHijri = new LocalDate(tanggal.toDateTimeAtStartOfDay(),
                 hijri);		
		d = todayHijri.getDayOfMonth();
		m = todayHijri.getMonthOfYear();
		y = todayHijri.getYear();
		n = n + ", \"hijriyah\" : \"" + Integer.toString(d) + "/" + Integer.toString(m) + "/" + Integer.toString(y) + "\"";
		n = n + ", \"wajib\" : {";   	 		
        for (int i = 0; i < prayerTimes.size(); i++) {
            n = n + "\"" + prayerNames.get(i) + "\" : \"" + prayerTimes.get(i) + "\"";
            if(i < prayerTimes.size() - 1){
            	n = n + ",";
            }
        }
        n = n + "}, \"sunnah\" :{  \"dhuha\" : \"08:00\", \"tahajud\" : \"02:00\" } ";
        
        n = n + "}";
        return n;
	}
	public void SetPrayerTimes(ArrayList<String> pray){		
		this.prayerTimes = pray;
	}
}
