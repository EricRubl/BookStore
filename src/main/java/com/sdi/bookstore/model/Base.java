package com.sdi.bookstore.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
@NoArgsConstructor
@Data
public class Base implements Serializable {
    @Id
    @GeneratedValue
    private int id;

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
}
