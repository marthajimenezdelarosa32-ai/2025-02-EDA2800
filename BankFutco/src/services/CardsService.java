package services;

import java.util.List;
import java.util.Optional;
import model.Cards;
import repositories.CardsRepository;

public class CardsService implements ICardsService {
    private final CardsRepository repository;

    public CardsService() {
        this.repository = new CardsRepository();
    }

    @Override
    public Cards save(Cards card) {
        return repository.save(card);
    }

    @Override
    public Optional<Cards> findById(String cardNumber) {
        return repository.findById(cardNumber);
    }

    @Override
    public List<Cards> findAll() {
        return repository.findAll();
    }

    @Override
    public boolean deleteById(String cardNumber) {
        return repository.deleteById(cardNumber);
    }
}