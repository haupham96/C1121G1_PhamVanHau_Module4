package customer_management.service;

import customer_management.model.Customer;
import customer_management.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProvinceSerice {

    List<Province> findAll();

    Province findById(Long id);

    void save(Province province);

    void remove(Long id);
}
