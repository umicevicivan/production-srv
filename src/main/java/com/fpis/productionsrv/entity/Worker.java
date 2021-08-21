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
@Table(name = "Worker", schema = "fpis")
public class Worker {
    @Id
    private Long id;
    private String name;
    private String surname;
    private String jmbg;
}
