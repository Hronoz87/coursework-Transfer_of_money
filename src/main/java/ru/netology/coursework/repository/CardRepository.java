package ru.netology.coursework.repository;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.concurrent.CopyOnWriteArrayList;

@Repository
public class CardRepository {

    CopyOnWriteArrayList<Card> cards = new CopyOnWriteArrayList<>();

    @PostConstruct
    public CopyOnWriteArrayList<Card> addCardsToList() {
        cards.add(new Card("1112111111111111", "1022", "100", new Card.Amount(1500, "rub")));
        cards.add(new Card("1211111111111111", "1022", "110", new Card.Amount(500, "rub")));
        cards.add(new Card("1112111111111111", "1022", "101", new Card.Amount(700, "rub")));
        cards.add(new Card("1113111111111111", "1022", "102", new Card.Amount(2500, "rub")));
        cards.add(new Card("1114111111111111", "1022", "103", new Card.Amount(11400, "rub")));
        cards.add(new Card("1115111111111111", "1022", "113", new Card.Amount(11500, "rub")));
        cards.add(new Card("1116111111111111", "1022", "125", new Card.Amount(15000, "rub")));
        cards.add(new Card("1117111111111111", "1022", "145", new Card.Amount(15050, "rub")));
        cards.add(new Card("1118111111111111", "1022", "156", new Card.Amount(15500, "rub")));

        return cards;
    }
}
