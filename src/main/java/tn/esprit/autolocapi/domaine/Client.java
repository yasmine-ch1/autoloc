package tn.esprit.autolocapi.domaine;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "client")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;

    @NotBlank @Size(min = 2, max = 50)
    @Column(nullable = false, length = 50)
    private String nom;

    @NotBlank @Size(min = 2, max = 50)
    @Column(nullable = false, length = 50)
    private String prenom;

    @NotBlank @Email
    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @NotBlank
    @Pattern(regexp = "^[2459]\\d{7}$", message = "Téléphone invalide (8 chiffres)")
    @Column(nullable = false, length = 20)
    private String telephone;

    @NotBlank @Size(min = 6, max = 30)
    @Column(nullable = false, unique = true, length = 30)
    private String numPermis;

    @PastOrPresent
    @Column(nullable = false)
    private LocalDate dateInscription;

    @OneToMany(mappedBy = "client")
    @JsonIgnore
    private List<Reservation> reservations = new ArrayList<>();
}