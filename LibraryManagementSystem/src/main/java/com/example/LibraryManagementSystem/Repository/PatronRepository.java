package com.example.LibraryManagementSystem.Repository;

import com.example.LibraryManagementSystem.Entity.Patron;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatronRepository extends JpaRepository<Patron, Long> {
    List<Patron> findByName (String name);
}
