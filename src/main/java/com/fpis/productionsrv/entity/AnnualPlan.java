package com.fpis.productionsrv.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode()
@Entity
@NoArgsConstructor
@Table(name = "annual_plan", schema = "fpis")
public class AnnualPlan {
    @Id
    private Long id;
    private Timestamp dateOfIssue;
    private Timestamp expirationDate;
    private String description;
    private String note;
    @OneToOne
    @JoinColumn(name = "worker_id")
    private Worker worker;
    @OneToMany(mappedBy = "annualPlan", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<PlanItem> planItems = new HashSet<>();
}
