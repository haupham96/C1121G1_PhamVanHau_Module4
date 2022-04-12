package book_app.service.impl;

import book_app.model.Book;
import book_app.repository.IBookRepository;
import book_app.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {

    @Autowired
    IBookRepository iBookRepository;

    @Override
    public List<Book> findAll() {
        return iBookRepository.findAll();
    }

    @Override
    public Book findById(Integer id) {
        return iBookRepository.findById(id).orElse(null);
    }

    public void save(Book book) {
        iBookRepository.save(book);
    }

    @Override
    public void borrowBook(Book book) {
        book.setQuantity(book.getQuantity() - 1);
        this.save(book);
    }

    @Override
    public void returnBook(Book book) {
        book.setQuantity(book.getQuantity() + 1);
        this.save(book);
    }
}
