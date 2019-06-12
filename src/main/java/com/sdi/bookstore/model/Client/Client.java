package com.sdi.bookstore.model.Client;

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
@Table(name="Clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @JsonBackReference
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Purchase> purchases = new ArrayList<>();
}
