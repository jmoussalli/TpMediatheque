package fr.moussalli.tpmediatheque.controller;

import fr.moussalli.tpmediatheque.domain.Emprunt;
import fr.moussalli.tpmediatheque.service.EmpruntService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class EmpruntController {

    @Autowired
    private EmpruntService empruntService;

    @GetMapping("emprunts")
    public List<Emprunt> getEmprunts() {
        return empruntService.getAll();
    }

    // POST /emprunts
    @PostMapping("emprunts")
    public ResponseEntity<?> addEmprunt(@RequestBody Emprunt emprunt) {
        if (emprunt.getAdherent() == null || emprunt.getDocument() == null)
            return ResponseEntity
                    .badRequest()
                    .body("les informations adhérent et document emprunté sont obligatoires");
        else {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(empruntService.add(emprunt));
        }
    }

    // GET /emprunts/4
    @GetMapping("emprunts/{id}")
    public ResponseEntity getById(@PathVariable("id") Long id) {
        Optional<Emprunt> optional = empruntService.findById(id);
        if (optional.isEmpty())
            return ResponseEntity.notFound().build();
        else {
            return ResponseEntity.ok(optional.get());
        }
    }

    // DELETE /emprunts/4
    @DeleteMapping("emprunts/{id}")
    public void delete(@PathVariable("id") Long id) {
        empruntService.delete(id);
    }

    // PUT /emprunts/4
    @PutMapping("emprunts/{id}")
    public void update(@RequestBody Emprunt emprunt
            , @PathVariable("id") Integer id) {
        empruntService.update(emprunt);
    }


}
