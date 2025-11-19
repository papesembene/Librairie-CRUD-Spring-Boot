package sn.dakar.controller;

import org.springframework.web.bind.annotation.*;
import sn.dakar.entity.Client;
import sn.dakar.mapper.ClientMapper;
import sn.dakar.projection.ClientRequestDto;
import sn.dakar.service.ClientService;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientService service;
    private final ClientMapper mapper;

    public ClientController(ClientService service, ClientMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public Client create(@RequestBody ClientRequestDto dto) {
        Client client = mapper.toClient(dto);
        return service.save(client);
    }

    @PutMapping("/{id}")
    public Client update(@PathVariable Long id, @RequestBody ClientRequestDto dto) {
        Client client = service.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));
        mapper.updateClientFromDto(dto, client);
        return service.save(client);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}