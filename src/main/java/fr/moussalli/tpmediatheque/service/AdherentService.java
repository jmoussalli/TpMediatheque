package fr.moussalli.tpmediatheque.service;

import fr.moussalli.tpmediatheque.domain.Adherent;
import fr.moussalli.tpmediatheque.repository.AdherentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdherentService {

    @Autowired
    private AdherentRepository adherentRepository;

    public AdherentService(AdherentRepository adherentRepository) {
        this.adherentRepository = adherentRepository;
    }

    public Adherent add(Adherent a) {
        return adherentRepository.save(a);
    }

    public List<Adherent> getAll() {
        return adherentRepository.findAll();
    }

    public Optional<Adherent> findById(Long id) {
        return adherentRepository.findById(id);
    }

    public void delete(Long id) {
        adherentRepository.deleteById(id);
    }

    public void update(Adherent adherent) {
        adherentRepository.save(adherent);
    }

}
