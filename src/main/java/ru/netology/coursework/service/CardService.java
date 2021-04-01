package ru.netology.coursework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.netology.coursework.repository.Card;
import ru.netology.coursework.repository.CardRepository;

import java.util.Map;

@Service
public class CardService {

    public CardRepository cardRepository;

    @Autowired
    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public TransferResponse transferCardToCard(CardFormDTO cardFormDTO) {
        TransferResponse transferResponse = new TransferResponse();
        for (Card card : cardRepository.cards) {
            Integer amountCard = card.getAmount().getValue();
            Integer amount = cardFormDTO.getAmount().getValue();
            if (cardFormDTO.getCardFromNumber().equals(card.getCardFromNumber()) &&
                    cardFormDTO.getCardFromValidTill().equals(card.getCardFromValidTill()) &&
                    cardFormDTO.getCardFromCVV().equals(card.getCardFromCVV()) &&
                    cardFormDTO.getCardToNumber().equals(card.getCardToNumber())) {
                if (amountCard > amount) {
                    Integer temp = amountCard - (amount + (amount / 100));
                    transferResponse.operationId = String.valueOf(Math.round(Math.random() * 1000));
                    String verificationCode = String.valueOf(Math.round(Math.random() * 1000));
                    cardRepository.repositoryCodeAndId.put(transferResponse.operationId, verificationCode);
                    card.getAmount().setValue(temp);
                } else {
                    throw new IllegalStateException("Not enough money to perform operation");
                }
                return transferResponse;
            }
        }
        throw new IllegalStateException("Card is not found or has wrong requisites");
    }


    public String confirmOperation(ConfirmOperationDTO confirmOperationDTO) {
        for (Map.Entry<String, String> entry : cardRepository.repositoryCodeAndId.entrySet()) {
            if (confirmOperationDTO.getOperationId().equals(entry.getKey()) && confirmOperationDTO.getVerificationCode().equals(entry.getValue())) {
                return confirmOperationDTO.operationId;
            } else {
                throw new IllegalStateException(" Error input data");
            }

        }
        throw new IllegalStateException(" Error confirmation");
    }


}
