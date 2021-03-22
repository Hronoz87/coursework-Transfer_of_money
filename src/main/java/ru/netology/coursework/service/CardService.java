package ru.netology.coursework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.netology.coursework.repository.Card;
import ru.netology.coursework.repository.CardRepository;

@Service
public class CardService {

    private final CardRepository cardRepository;
    String id;

    @Autowired
    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public String transferCardToCard(String cardFromNumber, String cardFromValidTill, String cardFromCVV, String cardToNumber, Card.Amount amount, Card card) {
        if ((cardFromNumber.equals(card.getCardFromNumber()) &&
                (cardFromValidTill.equals(card.getCardFromValidTill())) &&
                (cardFromCVV.equals(card.getCardFromCVV())) &&
                (cardToNumber.equals(card.getCardToNumber())))) {
            if (amount.getValue() > amount.getValue()) {
                System.out.println("нет необходимой суммы");
            }

        }
        return id;
    }

    public String operationId() {
        return id;
    }
}
