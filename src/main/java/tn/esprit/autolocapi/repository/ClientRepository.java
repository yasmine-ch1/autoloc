package tn.esprit.autolocapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.autolocapi.domaine.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}