package com.sdi.bookstore.controller;

import com.sdi.bookstore.BookStoreService;
import com.sdi.bookstore.model.Book.Book;
import com.sdi.bookstore.model.Book.BookConverter;
import com.sdi.bookstore.model.Book.BookDTO;
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
public class BookController{
    private Logger logger = LoggerFactory.getLogger(BookController.class);

    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    @Autowired
    private BookStoreService service;

    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    @Autowired
    private BookConverter bookConverter;

    /**
     * curl -X GET \
     *   http://localhost:8080/books \
     *   -H 'Postman-Token: 804c4282-3cc2-44de-8bd6-381fe2fdd789' \
     *   -H 'cache-control: no-cache'
     */
    @CrossOrigin
    @GetMapping(value = "/books")
    public List<Book> get() {
        return service.getBooks();
    }

    /**
     * curl -X POST \
     *   http://localhost:8080/books \
     *   -H 'Content-Type: application/json' \
     *   -H 'Postman-Token: 014b46de-2cdc-43c7-a57a-c03aec3340c1' \
     *   -H 'cache-control: no-cache' \
     *   -d '{
     * 	"title": "grrm"
     * }'
     */
    @CrossOrigin
    @PostMapping(value = "/books")
    public ResponseEntity add(@RequestBody BookDTO bookDTO) {
        Book book = bookConverter.DTOToModel(bookDTO);
        service.saveBook(book);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * curl -X DELETE \
     *   http://localhost:8080/books/29 \
     *   -H 'Postman-Token: 22b77f74-82dd-4823-ab04-77e86d9db7cd' \
     *   -H 'cache-control: no-cache'
     */
    @CrossOrigin
    @DeleteMapping(value = "/books/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        try {
            service.deleteBook(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EmptyResultDataAccessException noObj) {
            logger.error(noObj.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    /**
     * curl -X PUT \
     *   http://localhost:8080/books/122 \
     *   -H 'Content-Type: application/json' \
     *   -H 'Postman-Token: e484ac27-6626-43d9-b2d9-3e431b46dc20' \
     *   -H 'cache-control: no-cache' \
     *   -d '{
     * 	"title": "vtbyunmj"
     * }'
     */
    @CrossOrigin
    @PutMapping(value = "/books/{id}")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody BookDTO bookDTO) {
        try {
            Book book = bookConverter.DTOToModel(bookDTO);
            service.updateBook(id, book);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EmptyResultDataAccessException noObj) {
            logger.error(noObj.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}