package com.fpis.productionsrv.controller;

import com.fpis.productionsrv.entity.PlanItem;
import com.fpis.productionsrv.entity.Worker;
import com.fpis.productionsrv.service.PlanItemService;
import com.fpis.productionsrv.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
