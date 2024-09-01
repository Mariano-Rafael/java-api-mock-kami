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

    public List<Debts> getDebtsByClientId(Integer clientId) {
        if (clientId == null) {
            throw new IllegalArgumentException("O parâmetro id é obrigatório");
        }
        return debtsRepository.findByClientId(clientId);
    }
}

