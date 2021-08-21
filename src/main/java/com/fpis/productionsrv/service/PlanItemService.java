package com.fpis.productionsrv.service;

import com.fpis.productionsrv.entity.AnnualPlan;
import com.fpis.productionsrv.entity.PlanItem;
import com.fpis.productionsrv.repository.PlanItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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

    public PlanItem save(PlanItem planItem, Long annualPlanId) {
        AnnualPlan annualPlan = new AnnualPlan();
        annualPlan.setId(annualPlanId);
        planItem.setAnnualPlan(annualPlan);
        return repository.save(planItem);
    }

    public PlanItem update(Long planItemId, PlanItem planItem) {
        PlanItem planItemToUpdate = repository.getOne(planItemId);

        planItemToUpdate.setDescription(planItem.getDescription());
        planItemToUpdate.setProduct(planItem.getProduct());
        planItemToUpdate.setQuantity(planItem.getQuantity());

        return repository.save(planItemToUpdate);
    }

    public void delete(Long id) throws Exception {
        if (Objects.isNull(id)) {
            throw new Exception("ID must not be null");
        } else {
            PlanItem existingEntity = this.repository.findById(id).orElseThrow(() -> new Exception("Object with '" + id + "' not found"));
            repository.delete(existingEntity);
        }
    }

}
