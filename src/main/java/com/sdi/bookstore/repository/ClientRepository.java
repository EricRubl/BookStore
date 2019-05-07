package com.sdi.bookstore.repository;

import com.sdi.bookstore.model.Client.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {}

