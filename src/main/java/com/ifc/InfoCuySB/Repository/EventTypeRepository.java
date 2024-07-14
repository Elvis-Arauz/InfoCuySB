package com.ifc.InfoCuySB.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ifc.InfoCuySB.Model.EventType;

@Repository
public interface EventTypeRepository extends JpaRepository<EventType, Long> {
}