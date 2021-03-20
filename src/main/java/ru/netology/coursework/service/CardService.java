package ru.netology.coursework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.netology.coursework.repository.Card;
import ru.netology.coursework.repository.CardRepository;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class CardService {

    private final CardRepository cardRepository;
    AtomicInteger id = new AtomicInteger();

    @Autowired
    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public CopyOnWriteArrayList<Card> transferCardToCard(String cardFromNumber, String cardFromValidTill, String cardFromCVV, String cardToNumber, Card.Amount amount) {
        return null;
    }
}
