package com.codegym.service.contract.impl;

import com.codegym.model.contract.Contract;
import com.codegym.repository.contract.IContractRepository;
import com.codegym.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContractService implements IContractService {

    @Autowired
    private IContractRepository iContractRepository;

    @Override
    public Page<Contract> findAllByDepositContaining(String name, Pageable pageable) {
        return this.iContractRepository.findAllByDepositContaining(name, pageable);

    }


    @Override
    public void save(Contract contract) {
        this.iContractRepository.save(contract);
    }

    @Override
    public Optional<Contract> findById(Integer id) {
        return this.iContractRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        this.iContractRepository.deleteById(id);
    }
}
