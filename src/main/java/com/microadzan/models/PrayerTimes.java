package com.microadzan.models;
import com.microadzan.models.Adzan_Calculator;
import com.microadzan.models.Adzan;
public class PrayerTimes {
	public static Adzan getAdzan(int tanggal, int bulan, int tahun){
		Adzan ad = new Adzan();
		//ad.SetPrayerTimes(pray);	
		if(PrayerTimes.CekKemenag() == true){
			
		}
		else { //Calculator
			ad = Adzan_Calculator.get(tanggal, bulan, tahun);
		}
		return ad;
	}
	public static Boolean CekKemenag(){
		return false;
	}
}
