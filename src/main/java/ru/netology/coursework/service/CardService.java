package ru.netology.coursework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.netology.coursework.repository.Card;
import ru.netology.coursework.repository.CardRepository;

import java.util.Map;
import java.util.UUID;

@Service
public class CardService {

    public CardRepository cardRepository;

    @Autowired
    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public String transferCardToCard(CardFormDTO cardFormDTO) {
        for (Card card : cardRepository.cards) {
            if (cardFormDTO.getCardFromNumber().equals(card.getCardFromNumber()) &&
                    cardFormDTO.getCardFromValidTill().equals(card.getCardFromValidTill()) &&
                    cardFormDTO.getCardFromCVV().equals(card.getCardFromCVV()) &&
                    cardFormDTO.getCardToNumber().equals(card.getCardToNumber())) {
                Integer amountCard = card.getAmount().getValue();
                Integer amount = cardFormDTO.getAmount().getValue();
                if (amountCard > amount) {
                    Integer temp = amountCard - (amount + (amount / 100));
                    holdMoney();
                    card.getAmount().setValue(temp);
                } else {
                    throw new IllegalStateException("Not enough money to perform operation");
                }
            }
            throw new IllegalStateException("Card is not found or has wrong requisites");
        }
        return operationId();
    }


    public void holdMoney() {
        String varificationCode = String.valueOf(UUID.randomUUID());
        String operationId = String.valueOf(UUID.randomUUID());
        cardRepository.repositoryCodeAndId.put(operationId, varificationCode);
    }

    public String operationId() {
        for (Map.Entry<String, String> entry : cardRepository.repositoryCodeAndId.entrySet()) {
            TransferResponse transferResponse = new TransferResponse();
            transferResponse.operationId = entry.getKey();
            return transferResponse.operationId;


        }
        return operationId();
    }
}
