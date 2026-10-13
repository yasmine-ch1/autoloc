package tn.esprit.autolocapi.web.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autolocapi.domaine.Client;
import tn.esprit.autolocapi.service.IClientService;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final IClientService clientService;

    public ClientController(IClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<Client> getAll() {
        return clientService.getAllClients();
    }

    @PostMapping
    public Client create(@Valid @RequestBody Client client) {
        return clientService.saveClient(client);
    }
}
