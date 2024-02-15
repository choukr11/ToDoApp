package com.example.LibraryManagementSystem.Controller;

import com.example.LibraryManagementSystem.Entity.PatronDto;
import com.example.LibraryManagementSystem.Service.LibraryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patrons")
@AllArgsConstructor
public class PatronController {
    private final LibraryService libraryService;
    @PostMapping("/add")
    public ResponseEntity<?> addPatron(@RequestBody PatronDto patronDto){
        try {
            return new ResponseEntity<>(libraryService.addPatron(patronDto), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
