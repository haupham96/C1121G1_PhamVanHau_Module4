package furama.service;

import furama.model.contract.Contract;

import java.util.List;

public interface IContractService {
    void save(Contract contract);

    Contract findById(Integer id);

    List<Contract> findAll();
}
