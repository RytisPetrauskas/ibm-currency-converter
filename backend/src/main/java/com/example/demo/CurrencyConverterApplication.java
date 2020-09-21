package com.example.demo;

import com.example.demo.Xml.CcyNtry;
import com.example.demo.Xml.CcyTbl;
import com.example.demo.Xml.FxRate;
import com.example.demo.Xml.FxRates;
import com.example.demo.domain.CurrencyEntity;
import com.example.demo.repo.CurrencyRepository;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

@SpringBootApplication
public class CurrencyConverterApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConverterApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CurrencyRepository currencyRepository) {
		return (args) -> {
			System.setProperty("http.agent", "Chrome");
			CcyTbl currencies = returnCurrencyList();
			FxRates fxRates = returnCurrencyRates();
			currencyRepository.save(new CurrencyEntity("EUR", "Euras",1.0));
			for(FxRate fxRate : fxRates.getValues()) {
				for(CcyNtry ccyNtry : currencies.getValues()) {
					if(fxRate.getCcyAmts().get(1).getCcy()
							.equals(ccyNtry.getCcy())) {
						currencyRepository.save(new CurrencyEntity(ccyNtry.getCcy(),ccyNtry.getCcyNm().get(0).getValue(),
								fxRate.getCcyAmts().get(1).getAmt()));
						break;
					}
				}
			}
		};
	}

	private CcyTbl returnCurrencyList(){
		URL url = null;
		CcyTbl value = null;
		try {
			url = new URL("http://www.lb.lt/webservices/FxRates/FxRates.asmx/getCurrencyList");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			InputStream response = con.getInputStream();
			String result = new BufferedReader(new InputStreamReader(response))
					.lines().collect(Collectors.joining("\n"));

			XmlMapper xmlMapper = new XmlMapper();
			value
					= xmlMapper.readValue(result, CcyTbl.class);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return value;
	}

	private FxRates returnCurrencyRates(){
		URL url = null;
		FxRates value = null;
		try {
			url = new URL("http://www.lb.lt/webservices/FxRates/FxRates.asmx/getCurrentFxRates?tp=LT");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			InputStream response = con.getInputStream();
			String result = new BufferedReader(new InputStreamReader(response))
					.lines().collect(Collectors.joining("\n"));

			XmlMapper xmlMapper = new XmlMapper();
			value
					= xmlMapper.readValue(result, FxRates.class);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return value;
	}
}

