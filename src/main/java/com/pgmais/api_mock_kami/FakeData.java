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
import java.util.ArrayList;

@Component
public class FakeData implements CommandLineRunner {

    private final DebtsRepository debtsRepository;
    private final OffersRepository offersRepository;
    private final AgreementsRepository agreementsRepository;

    public FakeData(DebtsRepository debtsRepository, OffersRepository offersRepository, AgreementsRepository agreementsRepository) {
        this.debtsRepository = debtsRepository;
        this.offersRepository = offersRepository;
        this.agreementsRepository = agreementsRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker();

        // gera registros fakes de debts, definido para 100 registros toda vez que iniciar a aplicação;
        for (int i = 0; i<= 100; i++) {
            Debts debts = new Debts();
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
            offers.setProduct(faker.commerce().productName());
            offers.setDueDate(LocalDate.now().plusDays(faker.number().numberBetween(1, 365)));
            offers.setInputLimitDate(LocalDate.now().plusDays(faker.number().numberBetween(1, 60)));
/*
            ArrayList<Offers.PaymentOption> paymentOptions = new ArrayList<>();
            for (int x = 0; x <= 3; x++) {
                Offers.PaymentOption option = new Offers.PaymentOption();
                option.setValue(faker.number().randomDouble(2, 100, 10000));
                option.setInstallmentsNumber(faker.number().numberBetween(1, 12));
                option.setInstallmentValue(faker.number().randomDouble(2, 50, 500));
                paymentOptions.add(option);
            }

            offers.setPaymentOptions(paymentOptions);

            offersRepository.save(offers);*/

        }

        // registros no agreements
        for (int y = 0; y < 100; y++) {
            Agreements agreements = new Agreements();
            agreements.setDueDate(LocalDate.now().plusDays(faker.number().numberBetween(1, 365)));
            agreements.setDigitableLine(faker.number().digits(47));

            agreementsRepository.save(agreements);
    }
}}

