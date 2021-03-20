package ru.netology.coursework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.netology.coursework.exciption.ErrorInputData;
import ru.netology.coursework.repository.Card;
import ru.netology.coursework.service.CardService;

import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping("/")
public class CardController {

    private final CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping("/transfer")
    public CopyOnWriteArrayList<Card> transferCardToCard(@RequestParam("cardFromNumber") String cardFromNumber,
                                                         @RequestParam("cardFromValidTill") String cardFromValidTill,
                                                         @RequestParam("cardFromCVV") String cardFromCVV,
                                                         @RequestParam("cardToNumber") String cardToNumber,
                                                         @RequestParam("amount") Card.Amount amount) {
        return cardService.transferCardToCard(cardFromNumber, cardFromValidTill, cardFromCVV, cardToNumber, amount);
    }

    @ExceptionHandler(ErrorInputData.class)
    ResponseEntity<String> InvalidCredentialsEx(ErrorInputData e) {
        System.out.println("Error input data: " + e.getMessage());
        return new ResponseEntity<>("Error customer message:" + e.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
