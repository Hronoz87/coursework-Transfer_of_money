package ru.netology.coursework.repository;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.concurrent.CopyOnWriteArrayList;

@Repository
public class CardRepository {

    CopyOnWriteArrayList<Card> cards = new CopyOnWriteArrayList<>();

    @PostConstruct
    public CopyOnWriteArrayList<Card> addCardsToList() {
        cards.add(new Card( "1112 - 1111 - 1111 - 1111", "10 / 22","100",  new Card.Amount(1500, "rub")));
        cards.add(new Card( "1211 - 1111 - 1111 - 111", "10 / 22", "110", new Card.Amount(500, "rub")));
        cards.add(new Card( "1112 - 1111 - 1111 - 1111", "10 / 22", "101",  new Card.Amount(700, "rub")));
        cards.add(new Card( "1113 - 1111 - 1111 - 1111", "10 / 22", "102",  new Card.Amount(2500, "rub")));
        cards.add(new Card("1114 - 1111 - 1111 - 1111", "10 / 22", "103",  new Card.Amount(11400, "rub")));
        cards.add(new Card(  "1115 - 1111 - 1111 - 1111", "10 / 22", "113",  new Card.Amount(11500, "rub")));
        cards.add(new Card( "1116 - 1111 - 1111 - 1111", "10 / 22", "125",  new Card.Amount(15000, "rub")));
        cards.add(new Card( "1117 - 1111 - 1111 - 1111", "10 / 22", "145",  new Card.Amount(15050, "rub")));
        cards.add(new Card( "1118 - 1111 - 1111 - 1111", "10 / 22", "156",  new Card.Amount(15500, "rub")));

        return cards;
    }
}
