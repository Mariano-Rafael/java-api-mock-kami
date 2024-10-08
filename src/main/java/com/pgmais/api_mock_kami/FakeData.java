package com.pgmais.api_mock_kami;

import com.github.javafaker.Faker;
import com.pgmais.api_mock_kami.Models.Agreements;
import com.pgmais.api_mock_kami.Models.Debts;
import com.pgmais.api_mock_kami.Models.Offers;
import com.pgmais.api_mock_kami.Repository.AgreementsRepository;
import com.pgmais.api_mock_kami.Repository.DebtsRepository;
import com.pgmais.api_mock_kami.Repository.OffersRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class FakeData implements CommandLineRunner {

    private final DebtsRepository debtsRepository;
    private final AgreementsRepository agreementsRepository;
    private final OffersRepository offersRepository;

    public FakeData(DebtsRepository debtsRepository, OffersRepository offersRepository, AgreementsRepository agreementsRepository, OffersRepository offersRepository1) {
        this.debtsRepository = debtsRepository;
        this.agreementsRepository = agreementsRepository;
        this.offersRepository = offersRepository1;
    }

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker();

        // gera registros fakes de debts, definido para 100 registros toda vez que iniciar a aplicação;
        for (int i = 0; i <= 100; i++) {
            Debts debts = new Debts();
            debts.setClientId(i);
            debts.setContract(faker.number().digits(10));
            debts.setPaymentValue(faker.number().randomDouble(2, 100, 10000));
            debts.setPaymentValue(faker.number().randomDouble(2, 100, 10000));
            debts.setAllowRenegociation(faker.bool().bool());
            debts.setProduct(faker.commerce().productName());
            debts.setStatus("Em Aberto");
            debts.setDueDate(LocalDate.now().minusDays(faker.number().numberBetween(1, 365)));
            debts.setOverDueDays(faker.number().numberBetween(1, 100));
            debts.setClientCode(faker.number().digits(8));
            debts.setMinimumInstallmentNumber(1);
            debts.setMaximumInstallmentNumber(faker.number().numberBetween(2, 12));
            debts.setMinimumInstallmentDueDate(LocalDate.now());
            debts.setMaximumInstallmentDueDate(LocalDate.now().plusDays(faker.number().numberBetween(1, 60)));

            debtsRepository.save(debts);

        }

        // gera registros fakes de offers, definido para 100 registros toda vez que iniciar a aplicação;
        for (int i = 0; i<= 100; i++) {
            Offers offers = new Offers();
            offers.setContract(faker.number().digits(10));
            offers.setClientId(i);
            offers.setProduct(faker.commerce().productName());
            offers.setDueDate(LocalDate.now().plusDays(faker.number().numberBetween(1, 365)));
            offers.setInputLimitDate(LocalDate.now().plusDays(faker.number().numberBetween(1, 60)));

            offersRepository.save(offers);
        }

        // registros no agreements
        for (int i = 0; i < 100; i++) {
            Agreements agreements = new Agreements();
            agreements.setClientId(i);
            agreements.setDueDate(LocalDate.now().plusDays(faker.number().numberBetween(1, 365)));
            agreements.setDigitableLine(faker.number().digits(47));

            agreementsRepository.save(agreements);
        }
    }
}

