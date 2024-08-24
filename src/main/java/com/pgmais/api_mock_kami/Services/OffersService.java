package com.pgmais.api_mock_kami.Services;

import com.pgmais.api_mock_kami.Models.Offers;
import com.pgmais.api_mock_kami.Repository.OffersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OffersService {
    private final OffersRepository offersRepository;
    
    public OffersService(OffersRepository offersRepository) {
        this.offersRepository = offersRepository;
    }

    public List<Offers> getAllOffers() {
        return offersRepository.findAll();
    }
}
