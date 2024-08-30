package com.pgmais.api_mock_kami.Controllers;
import com.pgmais.api_mock_kami.Models.Agreements;
import com.pgmais.api_mock_kami.Models.Debts;
import com.pgmais.api_mock_kami.Models.Offers;
import com.pgmais.api_mock_kami.Services.AgreementsService;
import com.pgmais.api_mock_kami.Services.DebtsService;
import com.pgmais.api_mock_kami.Services.OffersService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    @GetMapping("/debts")
    public List<Debts> getDebts() {
        return debtsService.getAllDebts();
    }

    @GetMapping("/offers")
    public List<Offers> getOffers() {
        return offersService.getAllOffers();
    }

    @GetMapping("/agreements")
    public List<Agreements> getAgreements() {
        return agreementsService.getAllAgreements();

    }
}
