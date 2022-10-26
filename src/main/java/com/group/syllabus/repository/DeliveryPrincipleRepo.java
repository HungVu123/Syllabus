package com.group.syllabus.repository;

import com.group.syllabus.model.DeliveryPrinciple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryPrincipleRepo extends JpaRepository<DeliveryPrinciple,Long> {
}
