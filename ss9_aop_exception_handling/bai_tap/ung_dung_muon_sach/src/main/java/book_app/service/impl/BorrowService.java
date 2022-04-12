package book_app.service.impl;

import book_app.model.Borrow;
import book_app.repository.IBorrowRepository;
import book_app.service.IBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowService implements IBorrowService {

    @Autowired
    IBorrowRepository iBorrowRepository;

    @Override
    public void save(Borrow borrow) {
        iBorrowRepository.save(borrow);
    }

    @Override
    public Borrow findByCode(Integer code) {
        return iBorrowRepository.findByCode(code);
    }

    @Override
    public void deleteById(Integer id) {
        iBorrowRepository.deleteById(id);
    }
}
