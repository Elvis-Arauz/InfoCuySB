package com.ifc.InfoCuySB.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ifc.InfoCuySB.Model.District;

@Repository
public interface DistrictRepository extends JpaRepository<District, Long> {
}