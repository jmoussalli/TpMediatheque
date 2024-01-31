package fr.moussalli.tpmediatheque.repository;

import fr.moussalli.tpmediatheque.domain.Emprunt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpruntRepository extends JpaRepository<Emprunt, Long> {

    Integer countAllByAdherent_Id(Long adherent_id);

    @Query("SELECT COUNT(DISTINCT e.adherent) FROM Emprunt e WHERE e.document.id = :documentId AND e.adherent.id <> :adherentId")
    Integer countDistinctAdherentByDocumentId(@Param("adherentId") Long adherentId, @Param("documentId") Long documentId);
}
