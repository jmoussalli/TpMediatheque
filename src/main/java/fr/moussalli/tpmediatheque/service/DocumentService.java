package fr.moussalli.tpmediatheque.service;

import fr.moussalli.tpmediatheque.domain.Document;
import fr.moussalli.tpmediatheque.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public Document add(Document a) {
        return documentRepository.save(a);
    }

    public List<Document> getAll() {
        return documentRepository.findAll();
    }

    public Optional<Document> findById(Long id) {
        return documentRepository.findById(id);
    }

    public void delete(Long id) {
        documentRepository.deleteById(id);
    }

    public void update(Document document) {
        documentRepository.save(document);
    }

}
