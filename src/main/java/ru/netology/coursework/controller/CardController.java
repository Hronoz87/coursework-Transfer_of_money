package ru.netology.coursework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.netology.coursework.service.CardFormDTO;
import ru.netology.coursework.service.CardService;
import ru.netology.coursework.service.ConfirmOperationDTO;
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
    public ResponseEntity<TransferResponse> transfer(@Valid @RequestBody CardFormDTO cardFormDTO) {
        System.out.println("Подтвердите код");
        return  new ResponseEntity<>(cardService.transferCardToCard(cardFormDTO), HttpStatus.OK);
    }

    @PostMapping("/confirmOperation")
    public ResponseEntity<TransferResponse> confirmOperation(@Valid @RequestBody ConfirmOperationDTO confirmOperationDTO) {
        String operationId = cardService.confirmOperation(confirmOperationDTO);
        System.out.println("Операция прошла успешно");
        return new ResponseEntity<>(new TransferResponse(operationId), HttpStatus.OK);
    }

}
