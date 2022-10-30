package com.group.syllabus.repository;

import com.group.syllabus.model.DeliveryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryTypeRepo extends JpaRepository<DeliveryType,Long> {
}
