package book_app.service;

import book_app.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();

    Book findById(Integer id);

    void borrowBook(Book book);

    void returnBook(Book book);
}
