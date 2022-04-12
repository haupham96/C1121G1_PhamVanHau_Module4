package book_app.repository;

import book_app.model.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBorrowRepository extends JpaRepository<Borrow, Integer> {
    Borrow findByCode(Integer code);
}
