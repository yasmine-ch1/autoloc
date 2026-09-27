package tn.esprit.autolocapi.domaine;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Paiement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPaiement;

    private BigDecimal montant;

    private LocalDate datePaiement;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private ModePaiement modePaiement;
}