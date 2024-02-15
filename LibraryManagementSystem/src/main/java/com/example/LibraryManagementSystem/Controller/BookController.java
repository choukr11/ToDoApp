package com.example.LibraryManagementSystem.Controller;

import com.example.LibraryManagementSystem.Entity.BookDto;
import com.example.LibraryManagementSystem.Service.LibraryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
@AllArgsConstructor

public class BookController {
    private final LibraryService libraryService;
    @PostMapping("/add")
    public ResponseEntity<?> addBook(@RequestBody BookDto bookDto){
        try {
            return new ResponseEntity<>(libraryService.addBook(bookDto),HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
