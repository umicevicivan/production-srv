package com.fpis.productionsrv.controller;

import com.fpis.productionsrv.entity.UnitOfMeasure;
import com.fpis.productionsrv.service.UnitOfMeasureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/unitsOfMeasure")
public class UnitOfMeasureController {

    @Autowired
    private UnitOfMeasureService service;

    @GetMapping
    public ResponseEntity<List<UnitOfMeasure>> findAll() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.findAll());
    }
}
