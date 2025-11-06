package repositories;

import java.util.*;
import model.Balance;
import java.time.LocalDate;

public class BalanceRepository {
    private final List<Balance> storage = new ArrayList<>();

    public Balance save(Balance balance) {
        if (balance == null || balance.getDate() == null)
            throw new IllegalArgumentException("Balance o fecha no puede ser null");
        storage.removeIf(b -> b.getDate().equals(balance.getDate()));
        storage.add(balance);
        return balance;
    }

    public Optional<Balance> findById(String id) {
        try {
            LocalDate date = LocalDate.parse(id);
            return storage.stream().filter(b -> b.getDate().equals(date)).findFirst();
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public List<Balance> findAll() {
        return new ArrayList<>(storage);
    }

    public boolean deleteById(String id) {
        return findById(id).map(storage::remove).orElse(false);
    }
}
