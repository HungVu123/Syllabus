package com.group.syllabus.repository;

import com.group.syllabus.model.DeliveryPrinciple;
import com.group.syllabus.model.DeliveryType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DeliveryPrincipleRepository extends JpaRepository<DeliveryPrinciple, UUID> {
}
