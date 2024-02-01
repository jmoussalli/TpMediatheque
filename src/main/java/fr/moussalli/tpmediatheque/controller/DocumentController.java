package fr.moussalli.tpmediatheque.controller;

import fr.moussalli.tpmediatheque.domain.Document;
import fr.moussalli.tpmediatheque.service.DocumentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("api")
public class DocumentController {

    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @RequestMapping("/documents")
    public String getDocuments(Model model) {
        List<Document> sortedDocuments = documentService.getAll().stream()
                .sorted(Comparator.comparing(Document::getNom))
                .collect(Collectors.toList());
        model.addAttribute("documents", sortedDocuments);

        return "documents";
    }

    @GetMapping("/documents/add")
    public String showAddForm(Model model) {
        model.addAttribute("document", new Document());
        return "document-form";
    }

    @PostMapping("/documents/save")
    public String saveDocument(@ModelAttribute("document") Document document) {
        documentService.add(document);
        return "redirect:/api/documents/add";
    }

    @GetMapping("/documents/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Optional<Document> opt = documentService.findById(id);
        if (opt.isPresent()) {
            Document document = opt.get();
            model.addAttribute("document", document);
        }
        return "document-form";
    }

    @GetMapping("/documents/delete/{id}")
    public String deleteDocument(@PathVariable("id") Long id) {
        documentService.delete(id);
        return "redirect:/api/documents";
    }
}
