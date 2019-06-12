package com.sdi.bookstore.model.Client;

import com.sdi.bookstore.model.BaseDTO;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ClientConverter {
    public Client DTOToModel(ClientDTO dto) {
        Client client = Client.builder()
                .name(dto.getName())
                .build();
        client.setId(dto.getId());
        return client;
    }

    public ClientDTO ModelToDTo(Client client) {
        ClientDTO dto = ClientDTO.builder()
                .name(client.getName())
                .build();
        dto.setId(client.getId());
        return dto;
    }

    public Set<Integer> convertModelsToIDs (Set<Client> modelSet) {
        return modelSet.stream()
                .map(Client::getId)
                .collect(Collectors.toSet());
    }

    public Set<Integer> convertDTOsToIDs(Set<ClientDTO> dtoSet) {
        return dtoSet.stream()
                .map(BaseDTO::getId)
                .collect(Collectors.toSet());
    }

    public Set<ClientDTO> convertModelsToDtos(Collection<Client> models) {
        return models.stream()
                .map(this::ModelToDTo)
                .collect(Collectors.toSet());
    }
}