package com.ifc.InfoCuySB.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ifc.InfoCuySB.Model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
}