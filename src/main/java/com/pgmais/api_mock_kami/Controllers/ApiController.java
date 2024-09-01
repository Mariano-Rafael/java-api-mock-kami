package com.pgmais.api_mock_kami.Controllers;
import com.pgmais.api_mock_kami.Models.*;
import com.pgmais.api_mock_kami.Services.AgreementsService;
import com.pgmais.api_mock_kami.Services.DebtsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.pgmais.api_mock_kami.Services.OffersService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {
    private final DebtsService debtsService;
    private final OffersService offersService;
    private final AgreementsService agreementsService;

    public ApiController(DebtsService debtsService, OffersService offersService, AgreementsService agreementsService) {
        this.debtsService = debtsService;
        this.offersService = offersService;
        this.agreementsService = agreementsService;
    }

    @PostMapping("/debts")
    public ResponseEntity<List<Debts>> getDebts(@RequestBody DebtsRequest request) {
        Integer clientId = request.getClientId();
        if (clientId == null) {
            return ResponseEntity.badRequest().body(null);
        }
        List<Debts> debts = debtsService.getDebtsByClientId(clientId);
        return ResponseEntity.ok(debts);
    }


    @PostMapping("/offers")
    public ResponseEntity<List<Offers>> getOffers(@RequestBody OffersRequest request) {
        Integer clientId = request.getClientId();
        if (clientId == null) {
            return ResponseEntity.badRequest().body(null);
        }
        List<Offers> offers = offersService.getOffersByClientId(clientId);
        return ResponseEntity.ok(offers);
    }


    @PostMapping("/agreements")
    public ResponseEntity<List<Agreements>> getAgreements(@RequestBody AgreementsRequest request) {
        Integer clientId = request.getClientId();
        if (clientId == null) {
            return ResponseEntity.badRequest().body(null);
        }
        List<Agreements> agreements = agreementsService.getAgreementsByClientId(clientId);
        return ResponseEntity.ok(agreements);

    }
}
