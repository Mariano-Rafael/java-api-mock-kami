package com.pgmais.api_mock_kami.Repository;

import com.pgmais.api_mock_kami.Models.Debts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DebtsRepository extends JpaRepository<Debts, Long> {
}

