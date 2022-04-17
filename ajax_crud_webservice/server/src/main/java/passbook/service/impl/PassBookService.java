package passbook.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import passbook.model.PassBook;
import passbook.repository.IPassBookRepository;
import passbook.service.IPassBookService;

@Service
public class PassBookService implements IPassBookService {

    @Autowired
    IPassBookRepository iPassBookRepository;

    @Override
    public Page<PassBook> findAll(Pageable pageable) {
        return this.iPassBookRepository.findAll(pageable);
    }

    @Override
    public void save(PassBook passBook) {
        this.iPassBookRepository.save(passBook);
    }

    @Override
    public PassBook findById(Integer id) {
        return this.iPassBookRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        this.iPassBookRepository.deleteById(id);
    }
}
