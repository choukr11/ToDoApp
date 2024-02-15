package com.example.LibraryManagementSystem.Service;

import com.example.LibraryManagementSystem.Entity.*;
import com.example.LibraryManagementSystem.Repository.AuthorRepository;
import com.example.LibraryManagementSystem.Repository.BookRepository;
import com.example.LibraryManagementSystem.Repository.PatronRepository;
import com.example.LibraryManagementSystem.Utilities.LibraryMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class LibraryService {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PatronRepository patronRepository;
    public Author addAuthor(String name, String biography) {
        Author author = new Author();
        author.setName(name);
        author.setBiography(biography);
        return authorRepository.save(author);
    }
    public Book addBook(String title, String isbn, String publicationDate, Author author) {
        Book book = new Book();
        book.setTitle(title);
        book.setIsbn(isbn);
        book.setPublicationDate(publicationDate);
        return bookRepository.save(book);
    }
    public Patron addPatron(String name, String email) {
        Patron patron = new Patron();
        patron.setName(name);
        patron.setEmail(email);
        return patronRepository.save(patron);
    }
    public void borrowBook(Patron patron, Book book) {
        Set<Book> booksBorrowed = patron.getBooksBorrowed();
        booksBorrowed.add(book);
        patron.setBooksBorrowed(booksBorrowed);
        patronRepository.save(patron);
    }
    public void returnBook(Patron patron, Book book) {
        Set<Book> booksBorrowed = patron.getBooksBorrowed();
        booksBorrowed.remove(book);
        patron.setBooksBorrowed(booksBorrowed);
        patronRepository.save(patron);
    }
    public List<Book> findAllBooksByAuthor(long id) {
        return bookRepository.findByAuthorId(id);
    }
    public Set<Book> findAllBooksBorrowedByPatron(Patron patron) {
        return patron.getBooksBorrowed();
    }
    public Author getAuthorById(long id) throws Exception {
        Optional<Author> optionalAuthor=authorRepository.findById(id);
        if(optionalAuthor.isEmpty()) throw new Exception("Author not found");
        else return optionalAuthor.get();
    }
    public Set<Author> getAllAuthors(){
        return new HashSet<>(authorRepository.findAll());
    }
    public BookDto addBook(BookDto bookDto) throws Exception {
        Optional<Author> author = authorRepository.findById(bookDto.getAuthorId());
        if (author.isEmpty()) {
            throw new Exception("Author doesn't exist!");
        }else{
            Set<Patron> patrons = new HashSet<>();
            for(long patronId : bookDto.getPatronId()){
                Optional<Patron> patron = patronRepository.findById(patronId);
                if (patron.isEmpty()) {
                    throw new Exception("Patron with id "+patronId+" doesn't exist!");
                }else{
                    patrons.add(patron.get());
                }
            }
            Book book = LibraryMapper.addBookMappingRequest(bookDto,author.get(),patrons);
            bookRepository.save(book);
            return bookDto;
        }
    }
    public AuthorDto addAuthor(AuthorDto authorDto) throws Exception {
            Set<Book> books = new HashSet<>();
            for(long bookId : authorDto.getBookId()){
                Optional<Book> book = bookRepository.findById(bookId);
                if (book.isEmpty()) {
                    throw new Exception("Book with id "+bookId+" doesn't exist!");
                }else{
                    books.add(book.get());
                }
            }
            return authorDto;
    }
    public PatronDto addPatron(PatronDto patronDto) throws Exception {
        Set<Book> books = new HashSet<>();
        for(Book bookId : patronDto.getBookId()){
            Optional<Book> book = bookRepository.findById(bookId.getId());
            if (book.isEmpty()) {
                throw new Exception("Book with id "+bookId+" doesn't exist!");
            }else{
                books.add(book.get());
            }
        }
        return patronDto;
    }



}