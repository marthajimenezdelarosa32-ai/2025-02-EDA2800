package services;

import java.util.List;
import java.util.Optional;
import model.Loans;
import repositories.LoansRepository;

public class LoansService implements ILoansService {
    private final LoansRepository repository;

    public LoansService() {
        this.repository = new LoansRepository();
    }

    @Override
    public Loans save(Loans loan) {
        return repository.save(loan);
    }

    @Override
    public Optional<Loans> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<Loans> findAll() {
        return repository.findAll();
    }

    @Override
    public boolean deleteById(String id) {
        return repository.deleteById(id);
    }
}
