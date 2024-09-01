package com.pgmais.api_mock_kami.Services;

import com.pgmais.api_mock_kami.Models.Agreements;
import com.pgmais.api_mock_kami.Repository.AgreementsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgreementsService {
    private final AgreementsRepository agreementsRepository;

    public AgreementsService(AgreementsRepository agreementsRepository) {
        this.agreementsRepository = agreementsRepository;
    }

    public List<Agreements> getAgreementsByClientId(Integer clientId) {
        if (clientId == null) {
            throw new IllegalArgumentException("O parâmetro id é obrigatório");
        }
        return agreementsRepository.findByClientId(clientId);
    }
}
