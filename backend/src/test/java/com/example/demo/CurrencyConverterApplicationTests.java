package com.example.demo;

import com.example.demo.web.WebController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CurrencyConverterApplicationTests {

	@Autowired
	private WebController controller;

	@Test
	void contextLoads(){
		assertThat(controller).isNotNull();
	}

}
