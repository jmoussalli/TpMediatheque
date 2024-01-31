package fr.moussalli.tpmediatheque.repository;

import fr.moussalli.tpmediatheque.domain.Adherent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdherentRepository extends JpaRepository<Adherent, Integer> {

}
