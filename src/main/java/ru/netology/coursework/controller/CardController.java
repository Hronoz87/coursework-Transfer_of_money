package ru.netology.coursework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.netology.coursework.exciption.ErrorInputData;
import ru.netology.coursework.service.CardFormDTO;
import ru.netology.coursework.service.CardService;
import ru.netology.coursework.service.TransferResponse;

import javax.validation.Valid;


@RestController
@RequestMapping("/")
public class CardController {

    public final CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping("/transfer")
    @ResponseBody
    public String transfer(@Valid @RequestBody CardFormDTO cardFormDTO) {
       return cardService.transferCardToCard(cardFormDTO);
    }

    @PostMapping("/confirmOperation")
    public String confirmOperation(@Valid @RequestBody TransferResponse transferResponse) {
        return transferResponse.getOperationId();
    }

//    @ExceptionHandler(ErrorInputData.class)
//    ResponseEntity<String> InvalidCredentialsEx(ErrorInputData e) {
//        System.out.println("Error input data: " + e.getMessage());
//        return new ResponseEntity<>("Error customer message:" + e.getMessage(), HttpStatus.BAD_REQUEST);
//    }

}
