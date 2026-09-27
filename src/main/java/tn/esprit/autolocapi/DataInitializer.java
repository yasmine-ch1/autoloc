package tn.esprit.autolocapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tn.esprit.autolocapi.domaine.CategorieVehicule;
import tn.esprit.autolocapi.domaine.StatutVehicule;
import tn.esprit.autolocapi.domaine.Vehicule;
import tn.esprit.autolocapi.repository.VehiculeRepository;

import java.math.BigDecimal;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initDatabase(VehiculeRepository vehiculeRepository) {
        return args -> {
            if (vehiculeRepository.count() == 0) {
                vehiculeRepository.save(new Vehicule(
                        null, "TU1234TN", "Peugeot", "208",
                        CategorieVehicule.CITADINE, new BigDecimal("60.00"),
                        StatutVehicule.DISPONIBLE
                ));
                vehiculeRepository.save(new Vehicule(
                        null, "TU5678TN", "Renault", "Clio",
                        CategorieVehicule.CITADINE, new BigDecimal("55.00"),
                        StatutVehicule.DISPONIBLE
                ));
                vehiculeRepository.save(new Vehicule(
                        null, "TU9012TN", "Toyota", "Corolla",
                        CategorieVehicule.BERLINE, new BigDecimal("90.00"),
                        StatutVehicule.MAINTENANCE
                ));
            }
        };
    }
}