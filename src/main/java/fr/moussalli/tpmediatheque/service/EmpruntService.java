package fr.moussalli.tpmediatheque.service;

import fr.moussalli.tpmediatheque.domain.Emprunt;
import fr.moussalli.tpmediatheque.repository.EmpruntRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpruntService {

    @Autowired
    private EmpruntRepository empruntRepository;

    public EmpruntService(EmpruntRepository empruntRepository) {
        this.empruntRepository = empruntRepository;
    }

    public Emprunt add(Emprunt a) {
        return empruntRepository.save(a);
    }

    public List<Emprunt> getAll() {
        return empruntRepository.findAll();
    }

    public Optional<Emprunt> findById(Long id) {
        return empruntRepository.findById(id);
    }

    public void delete(Long id) {
        empruntRepository.deleteById(id);
    }

    public void update(Emprunt emprunt) {
        empruntRepository.save(emprunt);
    }

    public Boolean adherentADejaEmprunteLeMaximum(Long adherent_id) {
        return empruntRepository.countAllByAdherent_Id(adherent_id) > 2;
    }

}
