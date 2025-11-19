package sn.dakar.service;

import org.springframework.stereotype.Service;
import sn.dakar.entity.Client;
import sn.dakar.repository.ClientRepository;

@Service
public class ClientService extends AbstractCrudService<Client> {

    public ClientService(ClientRepository repository) {
        super(repository);
    }
}