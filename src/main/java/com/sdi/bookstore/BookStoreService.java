package com.sdi.bookstore;

import com.sdi.bookstore.model.Book.Book;
import com.sdi.bookstore.model.Client.Client;
import com.sdi.bookstore.model.Purchases.Purchase;
import com.sdi.bookstore.repository.BookRepository;
import com.sdi.bookstore.repository.ClientRepository;
import com.sdi.bookstore.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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

    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    @Autowired
    private PurchaseRepository purchaseRepository;

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

    public void sell(Integer bookID, Integer clientID) {
        Optional<Book> book = bookRepository.findById(bookID);
        Optional<Client> client = clientRepository.findById(clientID);
        if (book.isEmpty()) {
            throw new EmptyResultDataAccessException("book with given ID not found", bookID);
        }
        if (client.isEmpty()) {
            throw new EmptyResultDataAccessException("client with given ID not found", clientID);
        }

        Purchase purchase = new Purchase();
        purchase.setBook(book.get());
        purchase.setClient(client.get());
        purchase.setPurchaseDate(new Date());

        List<Purchase> newList = book.get().getPurchases();
        newList.add(purchase);
        book.get().setPurchases(newList);

        newList = client.get().getPurchases();
        newList.add(purchase);
        client.get().setPurchases(newList);

        purchaseRepository.save(purchase);

//        Book book1 = new Book();
//        book1.setTitle("ASOIAF");
//
//        Client client1 = new Client();
//        client1.setName("Alberto");
//
//        Purchase purchase1 = new Purchase();
//        purchase1.setBook(book1);
//        purchase1.setClient(client1);
//
//        client1.getPurchases().add(purchase1);
//        book1.getPurchases().add(purchase1);
//
//        bookRepository.save(book1);
//        clientRepository.save(client1);

    }

    public List<Purchase> getPurchases() {
        return purchaseRepository.findAll();
    }
}
