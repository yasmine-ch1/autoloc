package tn.esprit.autolocapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.autolocapi.domaine.Vehicule;

public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {
}