package com.sdi.bookstore.repository;

import com.sdi.bookstore.model.Purchases.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {}

