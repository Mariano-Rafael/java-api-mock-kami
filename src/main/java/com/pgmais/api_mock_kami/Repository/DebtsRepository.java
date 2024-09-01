package com.pgmais.api_mock_kami.Repository;

import com.pgmais.api_mock_kami.Models.Debts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DebtsRepository extends JpaRepository<Debts, Long> {
    List<Debts> findByClientId(int clientId);
}

