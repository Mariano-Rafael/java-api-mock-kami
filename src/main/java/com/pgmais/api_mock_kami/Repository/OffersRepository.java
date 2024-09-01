package com.pgmais.api_mock_kami.Repository;

import com.pgmais.api_mock_kami.Models.Offers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OffersRepository extends JpaRepository<Offers, Long> {
    List<Offers> findByClientId(int clientId);
}
