package ru.netology.coursework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.netology.coursework.exciption.ErrorInputData;
import ru.netology.coursework.repository.Card;
import ru.netology.coursework.service.CardService;

@RestController
@RequestMapping("/")
public class CardController {

    private final CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping("/transfer")
    public String transferCardToCard(@RequestBody String cardFromNumber, String cardFromValidTill, String cardFromCVV, String cardToNumber, Card.Amount amount, Card card){
        return cardService.operationId();
    }

    @ExceptionHandler(ErrorInputData.class)
    ResponseEntity<String> InvalidCredentialsEx(ErrorInputData e) {
        System.out.println("Error input data: " + e.getMessage());
        return new ResponseEntity<>("Error customer message:" + e.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
