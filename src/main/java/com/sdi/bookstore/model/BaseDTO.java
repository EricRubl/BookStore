package com.sdi.bookstore.model;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BaseDTO implements Serializable {
    private int id;
}
