package com.fpis.productionsrv.service;

import com.fpis.productionsrv.entity.Worker;
import com.fpis.productionsrv.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WorkerService {

    @Autowired
    private WorkerRepository repository;

    @Transactional(readOnly = true)
    public List<Worker> findAll() {
        return repository.findAll();
    }

}
