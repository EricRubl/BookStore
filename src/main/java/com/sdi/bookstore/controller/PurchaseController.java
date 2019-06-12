package com.sdi.bookstore.controller;

import com.sdi.bookstore.BookStoreService;
import com.sdi.bookstore.model.Client.ClientConverter;
import com.sdi.bookstore.model.Purchases.Purchase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
public class PurchaseController {
    private Logger logger = LoggerFactory.getLogger(ClientController.class);

    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    @Autowired
    private BookStoreService service;

    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    @Autowired
    private ClientConverter clientConverter;

    @PostMapping(value = "/sell/{bookID}/{clientID}")
    public void sellBookToClient(@PathVariable Integer bookID, @PathVariable Integer clientID) {
        service.sell(bookID, clientID);
    }

    @GetMapping(value = "/purchases")
    public List<Purchase> getPurchases() {
        return service.getPurchases();
    }
//
//    @DeleteMapping(value = "/clients/{id}")
//    public ResponseEntity delete(@PathVariable Integer id) {
//        try {
//            service.deleteClient(id);
//            return new ResponseEntity<>(HttpStatus.OK);
//        } catch (EmptyResultDataAccessException noObj) {
//            logger.error(noObj.getMessage());
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @PutMapping(value = "/clients/{id}")
//    public ResponseEntity update(@PathVariable Integer id, @RequestBody ClientDTO clientDTO) {
//        try {
//            Client client = clientConverter.DTOToModel(clientDTO);
//            service.updateClient(id, client);
//            return new ResponseEntity<>(HttpStatus.OK);
//        } catch (EmptyResultDataAccessException noObj) {
//            logger.error(noObj.getMessage());
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
}