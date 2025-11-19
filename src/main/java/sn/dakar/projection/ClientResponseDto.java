package sn.dakar.projection;

import org.springframework.data.rest.core.config.Projection;
import sn.dakar.entity.Client;

@Projection(name = "clientResponse", types = Client.class)
public interface ClientResponseDto {

    Long getId();
    String getNom();
    String getTelephone();
    String getEmail();
    String getAdresse();
}