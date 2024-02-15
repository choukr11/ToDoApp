package com.example.LibraryManagementSystem.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;

@Getter
@AllArgsConstructor
public class PatronDto {
    private String name;
    private String email;
    private Set<Book> bookId;

}
