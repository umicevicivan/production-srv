package com.fpis.productionsrv.service;

import com.fpis.productionsrv.entity.UnitOfMeasure;
import com.fpis.productionsrv.repository.UnitOfMeasureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitOfMeasureService {

    @Autowired
    private UnitOfMeasureRepository repository;

    public List<UnitOfMeasure> findAll() {
        return repository.findAll();
    }

}
