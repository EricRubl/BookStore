package com.sdi.bookstore.model.Purchases;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sdi.bookstore.model.Book.Book;
import com.sdi.bookstore.model.Client.Client;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
@ToString
@Builder
@Getter
@Setter
@IdClass(PurchaseKey.class)
public class Purchase implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn
    @JsonManagedReference
    private Book book;

    @Id
    @ManyToOne
    @JoinColumn
    @JsonManagedReference
    private Client client;

    private Date purchaseDate = new Date();
}

class PurchaseKey implements Serializable {
    private Book book;
    private Client client;
};