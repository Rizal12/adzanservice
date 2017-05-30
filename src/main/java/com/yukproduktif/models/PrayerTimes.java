package com.yukproduktif.models;
import com.yukproduktif.models.Adzan;
import com.yukproduktif.models.AdzanCalculator;
public class PrayerTimes {
	public static Adzan getAdzan(int tanggal, int bulan, int tahun){
		Adzan ad = new Adzan();
		//ad.SetPrayerTimes(pray);	
		if(PrayerTimes.CekKemenag() == true){
			
		}
		else { //Calculator
			ad = AdzanCalculator.get(tanggal, bulan, tahun);
		}
		return ad;
	}
	public static Boolean CekKemenag(){
		return false;
	}
}
