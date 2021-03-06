package com.codegym.service.contract;

import com.codegym.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface IContractService {

    Page<Contract> findAllByDepositContaining(String name , Pageable pageable);

    void save(Contract contract);

    Optional<Contract> findById(Integer id);

    void deleteById(Integer id);

}
