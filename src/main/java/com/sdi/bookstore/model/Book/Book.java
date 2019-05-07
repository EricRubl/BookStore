package com.sdi.bookstore.model.Book;

import com.sdi.bookstore.model.Base;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@Setter
@Getter
@Table(name="Books")
public class Book extends Base {
    private String title;
}
