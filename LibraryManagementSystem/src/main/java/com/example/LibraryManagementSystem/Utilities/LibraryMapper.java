package com.example.LibraryManagementSystem.Utilities;

import com.example.LibraryManagementSystem.Entity.Author;
import com.example.LibraryManagementSystem.Entity.Book;
import com.example.LibraryManagementSystem.Entity.BookDto;
import com.example.LibraryManagementSystem.Entity.Patron;

import java.util.Set;

public class LibraryMapper {
    public static Book addBookMappingRequest(BookDto bookDto, Author author, Set<Patron> patron){
        return new Book(0,bookDto.getTitle(),bookDto.getIsbn(), bookDto.getPublicationDate(), author,patron);
    }
}
