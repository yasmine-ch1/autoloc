package tn.esprit.autolocapi.domaine;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "reservation")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;

    @NotNull @FutureOrPresent
    @Column(nullable = false)
    private LocalDate dateDebut;

    @NotNull @Future
    @Column(nullable = false)
    private LocalDate dateFin;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private StatutReservation statut;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "vehicule_id")
    private Vehicule vehicule;

    @OneToOne(mappedBy = "reservation")
    @JsonIgnore
    private Contrat contrat;

    @JsonIgnore
    @AssertTrue(message = "dateFin doit être après dateDebut")
    public boolean isPeriodeValide() {
        return dateDebut == null || dateFin == null || dateFin.isAfter(dateDebut);
    }
}