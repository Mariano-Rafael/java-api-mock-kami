package com.pgmais.api_mock_kami.Repository;

import com.pgmais.api_mock_kami.Models.Agreements;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AgreementsRepository extends JpaRepository<Agreements, Long> {
    List<Agreements> findByClientId(int clientId);
}
