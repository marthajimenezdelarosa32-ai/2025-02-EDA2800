package repositories;

import java.util.*;
import java.time.LocalDate;
import model.Loans;

public class LoansRepository {
    private final List<Loans> storage = new ArrayList<>();

    public Loans save(Loans loan) {
        if (loan == null || loan.getDate() == null)
            throw new IllegalArgumentException("Loan o fecha no puede ser null");
        storage.removeIf(l -> l.getDate().equals(loan.getDate()));
        storage.add(loan);
        return loan;
    }

    public Optional<Loans> findById(String id) {
        try {
            LocalDate date = LocalDate.parse(id);
            return storage.stream().filter(l -> l.getDate().equals(date)).findFirst();
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public List<Loans> findAll() {
        return new ArrayList<>(storage);
    }

    public boolean deleteById(String id) {
        return findById(id).map(storage::remove).orElse(false);
    }
}
