package com.fpis.productionsrv.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "unit_of_measure")
public class UnitOfMeasure {
    @Id
    private Long id;
    private String fullName;
    private String shortName;
}
