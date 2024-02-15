package com.example.LibraryManagementSystem.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    private long id;
    private String name;
    private String biography;
    @OneToMany(mappedBy = "author")
    private List<Book> books;
}
