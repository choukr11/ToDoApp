package com.example.LibraryManagementSystem.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;
@Getter
@AllArgsConstructor
public class AuthorDto {
    private String name;
    private String biography;
    private Set<Long> bookId;
}
