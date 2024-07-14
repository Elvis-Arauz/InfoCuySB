package com.ifc.InfoCuySB.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ifc.InfoCuySB.Model.TouristAttraction;

@Repository
public interface TouristAttractionRepository extends JpaRepository<TouristAttraction, Long> {
}
