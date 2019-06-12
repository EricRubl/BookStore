package com.sdi.bookstore.controller;

import com.sdi.bookstore.BookStoreService;
import com.sdi.bookstore.model.Client.Client;
import com.sdi.bookstore.model.Client.ClientConverter;
import com.sdi.bookstore.model.Client.ClientDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ClientController {
    private Logger logger = LoggerFactory.getLogger(ClientController.class);

    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    @Autowired
    private BookStoreService service;

    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    @Autowired
    private ClientConverter clientConverter;

    @GetMapping(value = "/clients")
    public List<Client> get() {
        return service.getClients();
    }

    @PostMapping(value = "/clients")
    public ResponseEntity add(@RequestBody ClientDTO clientDTO) {
        Client client = clientConverter.DTOToModel(clientDTO);
        service.saveClient(client);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/clients/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        try {
            service.deleteClient(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EmptyResultDataAccessException noObj) {
            logger.error(noObj.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/clients/{id}")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody ClientDTO clientDTO) {
        try {
            Client client = clientConverter.DTOToModel(clientDTO);
            service.updateClient(id, client);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EmptyResultDataAccessException noObj) {
            logger.error(noObj.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}