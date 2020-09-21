package com.example.demo;

import com.example.demo.repo.CurrencyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CurrencyRepositoryTests {

    @Autowired
    CurrencyRepository currencyRepository;

    @Test
    public void findCurrencyRate(){
        List<Object> rates = currencyRepository.getCurrencyRates("EUR","USD");

        assertThat(rates).hasSize(2);
    }

    @Test
    public void findCurrencyNames(){
        List<Object> names = currencyRepository.returnAbvs();

        assertThat(names).isNotNull();
    }

}
