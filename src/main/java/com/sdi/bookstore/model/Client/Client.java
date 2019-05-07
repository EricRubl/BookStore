package com.sdi.bookstore.model.Client;

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
@Table(name="Clients")
public class Client extends Base {
    private String name;
}
