package com.yukproduktif.models;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.config.ScheduledTask;

import com.yukproduktif.models.Adzan;
import com.yukproduktif.models.AdzanCalculator;
import com.yukproduktif.models.AdzanKemenag;


public class PrayerTimes {
	//private static final Logger log =  LoggerFactory.getLogger(ScheduledTask.class);
	
	public static Adzan getAdzan(int tanggal, int bulan, int tahun, String lokasi){
		Adzan ad = new Adzan();
		
		if(AdzanKemenag.CekKemenag(tanggal, bulan, tahun, lokasi) == true){ 
			//Kemenag dari pras
			ad = AdzanKemenag.get();
		}
		else { //Calculator jika tidak ada di kemenag
			double latitude = -6.90389;
	        double longitude = 107.6191;
			if(lokasi == "bandung"){
				latitude = -6.90389;
		        longitude = 107.6191;
			}
			ad = AdzanCalculator.get(tanggal, bulan, tahun, latitude, longitude);
		}
		return ad;
	}
	
	@Scheduled(fixedRate = 5000)
	public static void get_datakemenag(){ // Mengambil data dari Kemenag
		//Crowling
		//log.info("Get GET ");
	}
	
}
	