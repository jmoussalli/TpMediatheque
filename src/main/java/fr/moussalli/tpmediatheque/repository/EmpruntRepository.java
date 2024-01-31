package fr.moussalli.tpmediatheque.repository;

import fr.moussalli.tpmediatheque.domain.Emprunt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpruntRepository extends JpaRepository<Emprunt, Integer> {

}
