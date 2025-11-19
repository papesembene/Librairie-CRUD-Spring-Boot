package sn.dakar.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import sn.dakar.entity.Client;
import sn.dakar.projection.ClientRequestDto;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    void updateClientFromDto(ClientRequestDto dto, @MappingTarget Client client);

    Client toClient(ClientRequestDto dto);
}