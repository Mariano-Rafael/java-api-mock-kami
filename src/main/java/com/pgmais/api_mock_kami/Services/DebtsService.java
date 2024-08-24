package com.pgmais.api_mock_kami.Services;

import com.pgmais.api_mock_kami.Models.Debts;
import com.pgmais.api_mock_kami.Repository.DebtsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DebtsService {
    private final DebtsRepository debtsRepository;

    public DebtsService(DebtsRepository debtsRepository) {
        this.debtsRepository = debtsRepository;
    }

    public List<Debts> getAllDebts() {
        return debtsRepository.findAll();
    }
}

