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
import java.util.Set;

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

        Set<PlanItem> planItems = newPlan.getPlanItems();

        newPlan.setPlanItems(null);
        AnnualPlan savedPlan = repository.save(newPlan);

        for (PlanItem plan : planItems) {
            planItemService.save(plan, savedPlan.getId());
        }

        return savedPlan;
    }

    public Optional<AnnualPlan> findById(Long planId) {
        return repository.findById(planId);
    }

    @Transactional
    public AnnualPlan update(Long planId, AnnualPlan plan) {

        AnnualPlan annualPlanToUpdate = repository.getOne(planId);

        annualPlanToUpdate.setId(planId);
        annualPlanToUpdate.setDateOfIssue(plan.getDateOfIssue());
        annualPlanToUpdate.setExpirationDate(plan.getExpirationDate());
        annualPlanToUpdate.setDescription(plan.getDescription());
        annualPlanToUpdate.setNote(plan.getNote());
        annualPlanToUpdate.setWorker(plan.getWorker());
        annualPlanToUpdate.setPlanItems(null);

        for (PlanItem planItem : plan.getPlanItems()) {
            if (planItem.getId() == null) {
                planItemService.save(planItem, plan.getId());
            } else {
                planItemService.update(planItem.getId(), planItem);
            }
        }
        return repository.save(annualPlanToUpdate);
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
