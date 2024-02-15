package com.example.LibraryManagementSystem.Entity;

import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;

@Getter
@AllArgsConstructor
public class BookDto {
    private String title;
    private String isbn;
    private String publicationDate;
    private long authorId;
    private Set<Long> patronId;
}
