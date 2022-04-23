package furama.service.impl;

import furama.model.contract.Contract;
import furama.repository.IContractRepository;
import furama.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractService implements IContractService {

    @Autowired
    IContractRepository iContractRepository;

    @Override
    public void save(Contract contract) {
        this.iContractRepository.save(contract);
    }

    @Override
    public Contract findById(Integer id) {
        return this.iContractRepository.findById(id).orElse(null);
    }
}
