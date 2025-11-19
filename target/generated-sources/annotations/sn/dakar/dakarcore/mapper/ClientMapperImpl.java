package sn.dakar.dakarcore.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import sn.dakar.dakarcore.entity.Client;
import sn.dakar.dakarcore.projection.ClientRequestDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-19T15:09:37+0000",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.16 (Ubuntu)"
)
@Component
public class ClientMapperImpl implements ClientMapper {

    @Override
    public void updateClientFromDto(ClientRequestDto dto, Client client) {
        if ( dto == null ) {
            return;
        }

        client.setNom( dto.nom() );
        client.setTelephone( dto.telephone() );
        client.setEmail( dto.email() );
        client.setAdresse( dto.adresse() );
    }

    @Override
    public Client toClient(ClientRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Client client = new Client();

        client.setNom( dto.nom() );
        client.setTelephone( dto.telephone() );
        client.setEmail( dto.email() );
        client.setAdresse( dto.adresse() );

        return client;
    }
}
