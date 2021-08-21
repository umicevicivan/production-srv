package com.fpis.productionsrv.repository;

import com.fpis.productionsrv.entity.PlanItem;
import com.fpis.productionsrv.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanItemRepository extends JpaRepository<PlanItem, Long> {
}
