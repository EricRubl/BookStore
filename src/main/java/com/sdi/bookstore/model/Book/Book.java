package com.sdi.bookstore.model.Book;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sdi.bookstore.model.Purchases.Purchase;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
@ToString
@Builder
@Setter
@Getter
@Table(name="Books")
public class Book{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    @JsonBackReference
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Purchase> purchases = new ArrayList<>();
}
