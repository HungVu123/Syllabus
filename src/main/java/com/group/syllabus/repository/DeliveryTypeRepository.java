package com.group.syllabus.repository;

import com.group.syllabus.model.DeliveryType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DeliveryTypeRepository extends JpaRepository<DeliveryType, UUID> {
}
