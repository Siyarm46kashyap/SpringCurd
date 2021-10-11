package com.example.JoinOperation.entity;
import lombok.*;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "book")

public class Book {
    @Id
    private int id;
    private String title;
    private int price;
    private int author_id;
}
