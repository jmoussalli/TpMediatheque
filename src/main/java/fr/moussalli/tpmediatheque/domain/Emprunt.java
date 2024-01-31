package fr.moussalli.tpmediatheque.domain;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "emprunts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Emprunt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "adherent_id")
    private Adherent adherent;
    @ManyToOne
    @JoinColumn(name = "document_id")
    private Document document;

}
