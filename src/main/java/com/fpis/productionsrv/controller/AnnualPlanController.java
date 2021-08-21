package com.fpis.productionsrv.controller;

import com.fpis.productionsrv.entity.AnnualPlan;
import com.fpis.productionsrv.service.AnnualPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/annualPlan")
public class AnnualPlanController {

    @Autowired
    private AnnualPlanService service;

    @GetMapping
    public ResponseEntity<List<AnnualPlan>> findAll() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.findAll());
    }

    @GetMapping("/{planId}")
    public ResponseEntity<Optional<AnnualPlan>> findById(@PathVariable Long planId) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.findById(planId));
    }

    @PutMapping("/{planId}")
    public ResponseEntity<AnnualPlan> update(@PathVariable Long planId, @RequestBody AnnualPlan plan) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.update(planId, plan));
    }

    @DeleteMapping("/{planId}")
    public ResponseEntity<String> delete(@PathVariable Long planId) {
        try {
            service.delete(planId);
            return ResponseEntity.noContent().build();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<AnnualPlan> save(@RequestBody AnnualPlan newPlan) {
        AnnualPlan plan = service.save(newPlan);
        return ResponseEntity.status(HttpStatus.OK).body(plan);
    }
}
