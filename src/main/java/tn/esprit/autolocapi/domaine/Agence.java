package tn.esprit.autolocapi.domaine;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "agence")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Agence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgence;

    @NotBlank
    @Column(nullable = false, length = 100)
    private String nom;

    @NotBlank
    @Column(nullable = false, length = 50)
    private String ville;

    @NotBlank
    @Column(nullable = false, length = 150)
    private String adresse;

    @NotBlank
    @Pattern(regexp = "^[2459]\\d{7}$", message = "Téléphone invalide (8 chiffres)")
    @Column(nullable = false, length = 20)
    private String telephone;

    @OneToMany(mappedBy = "agence", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Employe> employes = new ArrayList<>();

    @OneToMany(mappedBy = "agence")
    @JsonIgnore
    private List<Vehicule> vehicules = new ArrayList<>();
}