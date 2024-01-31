package fr.moussalli.tpmediatheque.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Entity
@Table(name = "adherents")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Adherent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String prenom;
    private String nom;
    private LocalDate dateFinAdhesion;

}
