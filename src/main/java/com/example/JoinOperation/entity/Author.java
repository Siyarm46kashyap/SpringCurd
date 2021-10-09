package com.example.JoinOperation.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity()
public class Author {
    @Id
    @Generated
    private int id;
    private String name;
    private String email;
   // @OneToMany(mappedBy="author", cascade = CascadeType.ALL)
  //  @OneToMany(targetEntity = Book.class,cascade = CascadeType.ALL)
   // @JoinColumn(name = "book_ibfk_1", referencedColumnName = "id")
   // private List<Book> book;
}
