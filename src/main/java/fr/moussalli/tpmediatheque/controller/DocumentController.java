package fr.moussalli.tpmediatheque.controller;

import fr.moussalli.tpmediatheque.domain.Document;
import fr.moussalli.tpmediatheque.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @GetMapping("documents")
    public List<Document> getDocuments() {
        return documentService.getAll();
    }

    // POST /documents
    @PostMapping("documents")
    public ResponseEntity<?> addDocument(@RequestBody Document document) {
        if (document.getNom() != null && document.getNom().isBlank())
            return ResponseEntity
                    .badRequest()
                    .body("le nom du document est obligatoire");
        else {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(documentService.add(document));
        }
    }

    // GET /documents/4
    @GetMapping("documents/{id}")
    public ResponseEntity getById(@PathVariable("id") Long id) {
        Optional<Document> optional = documentService.findById(id);
        if (optional.isEmpty())
            return ResponseEntity.notFound().build();
        else {
            return ResponseEntity.ok(optional.get());
        }
    }

    // DELETE /documents/4
    @DeleteMapping("documents/{id}")
    public void delete(@PathVariable("id") Long id) {
        documentService.delete(id);
    }

    // PUT /documents/4
    @PutMapping("documents/{id}")
    public void update(@RequestBody Document document
            , @PathVariable("id") Integer id) {
        documentService.update(document);
    }


}
