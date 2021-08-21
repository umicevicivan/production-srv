package com.fpis.productionsrv.service;

import com.fpis.productionsrv.entity.PlanItem;
import com.fpis.productionsrv.repository.PlanItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanItemService {

    @Autowired
    private PlanItemRepository repository;

    public List<PlanItem> findAll() {
        return repository.findAll();
    }

    public Long count() {
        return repository.count();
    }

    public PlanItem save(PlanItem planItem){
        return repository.save(planItem);
    }

}
