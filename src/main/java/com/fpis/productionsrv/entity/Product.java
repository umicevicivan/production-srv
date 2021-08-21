package com.fpis.productionsrv.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Product", schema = "fpis")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String professionalName;
    private String shape;
    private String description;
    private String instruction;
    private Long price;
    @OneToOne
    @JoinColumn(name = "unitOfMeasure_id")
    private UnitOfMeasure unitOfMeasure;
}
