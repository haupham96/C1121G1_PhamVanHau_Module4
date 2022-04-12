package book_app.service;

import book_app.model.Borrow;

public interface IBorrowService {
    void save(Borrow borrow);

    Borrow findByCode(Integer code);

    void deleteById(Integer id);
}
