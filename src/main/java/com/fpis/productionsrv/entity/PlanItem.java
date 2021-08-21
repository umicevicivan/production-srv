package com.fpis.productionsrv.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(exclude = "annualPlan")
@Entity
@NoArgsConstructor
@Table(name = "plan_item", schema = "fpis")
public class PlanItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "annual_plan_id")
    @JsonIgnoreProperties("planItems")
    private AnnualPlan annualPlan;
    private int quantity;
    private String description;
    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
