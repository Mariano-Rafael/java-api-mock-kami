package com.pgmais.api_mock_kami;

import com.pgmais.api_mock_kami.Models.Offers;
import com.pgmais.api_mock_kami.Repository.OffersRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class DataLoader {

    @Bean
    public CommandLineRunner loadData(OffersRepository repository) {
        return args -> {
            Offers offers = new Offers();
            offers.setContract("12345");
            offers.setProduct("Produto A");
            offers.setDueDate(LocalDate.now());
            offers.setInputLimitDate(LocalDate.now().plusDays(30));
            // Configure payment options here

            repository.save(offers);
            System.out.println("Dados carregados");
        };
    }
}
