package fr.moussalli.tpmediatheque.domain;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name="documents")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String nom;
    private String description;

}
