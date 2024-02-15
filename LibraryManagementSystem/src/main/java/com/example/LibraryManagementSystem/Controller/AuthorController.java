package com.example.LibraryManagementSystem.Controller;

import com.example.LibraryManagementSystem.Entity.AuthorDto;
import com.example.LibraryManagementSystem.Service.LibraryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authors")
@AllArgsConstructor
public class AuthorController {
    private final LibraryService libraryService;
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getAuthorById(@PathVariable Long id) {
        try {
            return new  ResponseEntity<>(libraryService.getAuthorById(id),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get/name")
    public ResponseEntity<?> getAllAuthors() {
        return new ResponseEntity<>(libraryService.getAllAuthors(), HttpStatus.OK);
    }
    @GetMapping("/get/{id}/books")
    public ResponseEntity<?> getAllBooksByAuthor(@RequestParam Long id){
        return new  ResponseEntity<>(libraryService.findAllBooksByAuthor(id),HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<?> addAuthor(@RequestBody AuthorDto authorDto){
        try {
            return new ResponseEntity<>(libraryService.addAuthor(authorDto),HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}