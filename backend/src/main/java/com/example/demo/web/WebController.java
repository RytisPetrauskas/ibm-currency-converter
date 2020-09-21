package com.example.demo.web;

import java.util.Date;
import java.util.List;

import com.example.demo.domain.ActivityEntity;
import com.example.demo.repo.ActivityRepository;
import com.example.demo.repo.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller

public class WebController {
	@Autowired
	private CurrencyRepository currencyRepository;

	@Autowired
	private ActivityRepository activityRepository;

	@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
	@RequestMapping(value = "/currencies", method = RequestMethod.GET)
	public @ResponseBody List<Object> returnCurrencyList() {
		return currencyRepository.returnAbvs();
	}

	@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
	@RequestMapping(value = "/currencyRate/{firstAbv}/{secondAbv}", method = RequestMethod.GET)
	public @ResponseBody List<Object> returnCurrencyRate(@PathVariable("firstAbv") String firstAbv,
	@PathVariable("secondAbv") String secondAbv) {
		activityRepository.save(new ActivityEntity(firstAbv,secondAbv));
		return currencyRepository.getCurrencyRates(firstAbv,secondAbv);
	}

	@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
	@RequestMapping(value = "/activities", method = RequestMethod.GET)
	public @ResponseBody List<ActivityEntity> returnActivities() {
		return activityRepository.findAll();
	}

}
