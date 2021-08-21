package com.fpis.productionsrv.service;

import com.fpis.productionsrv.entity.AnnualPlan;
import com.fpis.productionsrv.entity.PlanItem;
import com.fpis.productionsrv.repository.AnnualPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AnnualPlanService {

    @Autowired
    private AnnualPlanRepository repository;

    @Autowired
    private PlanItemService planItemService;

    public List<AnnualPlan> findAll() {
        return repository.findAll();
    }

    @Transactional
    public AnnualPlan save(AnnualPlan newPlan) {

        newPlan.setId(repository.count() + 1);

        Long planItemId = planItemService.count();
        AnnualPlan help = new AnnualPlan();
        help.setId(newPlan.getId());

        for (PlanItem plan : newPlan.getPlanItems()) {
            plan.setId(planItemId + 1);
            planItemId++;
            plan.setAnnualPlan(help);
        }

        return repository.save(newPlan);
    }

    public Optional<AnnualPlan> findById(Long planId) {
        return repository.findById(planId);
    }

    public AnnualPlan update(Long planId, AnnualPlan plan) {
//        Product productToUpdate = repository.getOne(productId);
//        productToUpdate.setName(product.getName());
//        productToUpdate.setProfessionalName(product.getProfessionalName());
//        productToUpdate.setShape(product.getShape());
//        productToUpdate.setDescription(product.getDescription());
//        productToUpdate.setInstruction(product.getInstruction());
//        productToUpdate.setPrice(product.getPrice());
//        productToUpdate.setUnitOfMeasure(product.getUnitOfMeasure());
//        return repository.save(productToUpdate);
        return null;
    }

    public void delete(Long id) throws Exception {
        if (Objects.isNull(id)) {
            throw new Exception("ID must not be null");
        } else {
            AnnualPlan existingEntity = this.repository.findById(id).orElseThrow(() -> new Exception("Object with '" + id + "' not found"));
            repository.delete(existingEntity);
        }
    }

}
