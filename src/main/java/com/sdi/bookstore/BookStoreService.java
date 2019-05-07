package com.sdi.bookstore;

import com.sdi.bookstore.repository.BookRepository;
import com.sdi.bookstore.repository.ClientRepository;
import com.sdi.bookstore.model.Book.Book;
import com.sdi.bookstore.model.Client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookStoreService {
    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    @Autowired
    private BookRepository bookRepository;

    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    @Autowired
    private ClientRepository clientRepository;

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    @Transactional
    public void updateBook(Integer id, Book book) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isEmpty())
            throw new EmptyResultDataAccessException("book with given ID not found", id);
        Book result = optionalBook.get();
        result.setTitle(book.getTitle());
    }

    public void deleteBook(Integer id) {
        bookRepository.deleteById(id);
    }

    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    @Transactional
    public Client updateClient(Integer id, Client client) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        Client result = optionalClient.orElse(client);
        result.setName(client.getName());
        return result;
    }

    public void deleteClient(Integer id) {
        clientRepository.deleteById(id);
    }
}
