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
@Table(name = "author")
public class Author {
    @Id
    @Generated
    private int id;
    private String name;
    private String email;
    @OneToMany(targetEntity = Book.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="author_id",referencedColumnName = "id")
    private List<Book> book;
}
