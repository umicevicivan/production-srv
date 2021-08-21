package com.fpis.productionsrv.controller;

import com.fpis.productionsrv.entity.PlanItem;
import com.fpis.productionsrv.service.PlanItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planItem")
public class PlanItemController {

    @Autowired
    private PlanItemService service;

    @GetMapping
    public ResponseEntity<List<PlanItem>> findAll() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.findAll());
    }

    @DeleteMapping("/{planItemId}")
    public ResponseEntity<String> delete(@PathVariable Long planItemId) {
        try {
            service.delete(planItemId);
            return ResponseEntity.noContent().build();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
}
