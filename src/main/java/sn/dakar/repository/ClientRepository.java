package sn.dakar.repository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sn.dakar.entity.Client;
import sn.dakar.projection.ClientResponseDto;

@RepositoryRestResource(path = "clients", excerptProjection = ClientResponseDto.class)
public interface ClientRepository extends BaseRepository<Client> {
}