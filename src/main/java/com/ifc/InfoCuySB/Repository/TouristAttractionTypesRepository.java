package com.ifc.InfoCuySB.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ifc.InfoCuySB.Model.TouristAttractionTypes;

@Repository
public interface TouristAttractionTypesRepository extends JpaRepository<TouristAttractionTypes, Long> {
}
