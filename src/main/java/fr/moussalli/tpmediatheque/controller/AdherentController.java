package fr.moussalli.tpmediatheque.controller;

import fr.moussalli.tpmediatheque.domain.Adherent;
import fr.moussalli.tpmediatheque.service.AdherentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class AdherentController {

    @Autowired
    private AdherentService adherentService;

    @GetMapping("adherents")
    public List<Adherent> getAdherents() {
        return adherentService.getAll();
    }

    // POST /adherents
    @PostMapping("adherents")
    public ResponseEntity<?> addAdherent(@RequestBody Adherent adherent) {
        if (adherent.getNom() != null && adherent.getNom().isBlank())
            return ResponseEntity
                    .badRequest()
                    .body("le nom de l'adhérent est obligatoire");
        else {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(adherentService.add(adherent));
        }
    }

    // GET /adherents/4
    @GetMapping("adherents/{id}")
    public ResponseEntity getById(@PathVariable("id") Long id) {
        Optional<Adherent> optional = adherentService.findById(id);
        if (optional.isEmpty())
            return ResponseEntity.notFound().build();
        else {
            return ResponseEntity.ok(optional.get());
        }
    }

    // DELETE /adherents/4
    @DeleteMapping("adherents/{id}")
    public void delete(@PathVariable("id") Long id) {
        adherentService.delete(id);
    }

    // PUT /adherents/4
    @PutMapping("adherents/{id}")
    public void update(@RequestBody Adherent adherent
            , @PathVariable("id") Integer id) {
        adherentService.update(adherent);
    }


}
