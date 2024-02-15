package com.example.LibraryManagementSystem.Repository;

import com.example.LibraryManagementSystem.Entity.Author;
import com.example.LibraryManagementSystem.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findByName (String name);

}
