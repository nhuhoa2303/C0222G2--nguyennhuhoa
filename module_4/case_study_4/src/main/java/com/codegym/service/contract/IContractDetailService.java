package com.codegym.service.contract;

import com.codegym.model.contract.ContractDetail;

import java.util.List;

public interface IContractDetailService {

    List<ContractDetail> displayAll();

    void save(ContractDetail contractDetail);

    List<ContractDetail> findAll();
}
