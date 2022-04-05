package com.example.repository.impl;

import com.example.model.Customer;
import com.example.repository.ICustomerRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Repository
@Transactional
public class CustomerRepository implements ICustomerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean insertWithStoredProcedure(Customer customer) {
        String sql = "CALL Insert_Customer(?1, ?2)";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter(1, customer.getFirstName());
        query.setParameter(2, customer.getLastName());
        return query.executeUpdate() == 0;
    }
}
