package repositories;

import java.util.*;
import model.Cards;

public class CardsRepository {
    private final List<Cards> storage = new ArrayList<>();

    public Cards save(Cards card) {
        if (card == null || card.getCardNumber() == null)
            throw new IllegalArgumentException("Card o cardNumber no puede ser null");
        storage.removeIf(c -> c.getCardNumber().equals(card.getCardNumber()));
        storage.add(card);
        return card;
    }

    public Optional<Cards> findById(String id) {
        return storage.stream().filter(c -> c.getCardNumber().equals(id)).findFirst();
    }

    public List<Cards> findAll() {
        return new ArrayList<>(storage);
    }

    public boolean deleteById(String id) {
        return findById(id).map(storage::remove).orElse(false);
    }
}
