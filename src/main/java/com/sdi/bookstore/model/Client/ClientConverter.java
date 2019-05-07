package com.sdi.bookstore.model.Client;

import com.sdi.bookstore.model.BaseConverter;
import org.springframework.stereotype.Component;

@Component
public class ClientConverter extends BaseConverter<Client, ClientDTO> {
    @Override
    public Client DTOToModel(ClientDTO dto) {
        Client client = Client.builder()
                .name(dto.getName())
                .build();
        client.setId(dto.getId());
        return client;
    }

    @Override
    public ClientDTO ModelToDTo(Client client) {
        ClientDTO dto = ClientDTO.builder()
                .name(client.getName())
                .build();
        dto.setId(client.getId());
        return dto;
    }
}