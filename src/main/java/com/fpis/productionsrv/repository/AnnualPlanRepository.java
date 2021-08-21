package com.fpis.productionsrv.repository;

import com.fpis.productionsrv.entity.AnnualPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnualPlanRepository extends JpaRepository<AnnualPlan, Long> {
}
