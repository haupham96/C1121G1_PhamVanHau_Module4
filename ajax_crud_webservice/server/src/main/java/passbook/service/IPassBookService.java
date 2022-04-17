package passbook.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import passbook.model.PassBook;

public interface IPassBookService {

    Page<PassBook> findAll(Pageable pageable);

    void save(PassBook passBook);

    PassBook findById(Integer id);

    void deleteById(Integer id);
}
