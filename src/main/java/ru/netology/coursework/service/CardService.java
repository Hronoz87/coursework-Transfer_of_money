package ru.netology.coursework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.netology.coursework.repository.Card;
import ru.netology.coursework.repository.CardRepository;

import javax.annotation.PostConstruct;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class CardService {

    public CardRepository cardRepository;

    @Autowired
    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @PostConstruct
    public CardFormDTO convertCardFormDTO(Card card) {
        CardFormDTO cardFormDTO = new CardFormDTO();
        cardFormDTO.setCardFromNumber(card.getCardFromNumber());
        cardFormDTO.setCardFromValidTill(card.getCardFromValidTill());
        cardFormDTO.setCardFromCVV(card.getCardFromCVV());
        cardFormDTO.setCardToNumber(card.getCardToNumber());
        cardFormDTO.setAmount(card.getAmount());
        return cardFormDTO;
    }

    @PostConstruct
    public String transferCardToCard(CopyOnWriteArrayList<Card> cards, CardFormDTO cardFormDTO) {
        for (Card card : cards) {
            if (cardFormDTO.getCardFromNumber().equals(card.getCardFromNumber()) &&
                    cardFormDTO.getCardFromValidTill().equals(card.getCardFromValidTill()) &&
                    cardFormDTO.getCardFromCVV().equals(card.getCardFromCVV()) &&
                    cardFormDTO.getCardToNumber().equals(card.getCardToNumber())) {
                Integer amount = cardFormDTO.getAmount().getValue();
                Integer amountCard = card.getAmount().getValue();
                if(amount > amountCard) {
                    System.out.println("Не достаточно стредств");
                } else {
                    Integer temp = amountCard - (amount - (amount / 100));
                    card.getAmount().setValue(temp);
                    Integer temp1 = amountCard + amount;
                    cardFormDTO.getAmount().setValue(temp1);
                }
            }


        }
        return operationId();
    }


    public String operationId() {
        Random id1 = new Random();
        return String.valueOf(id1);
    }

}
