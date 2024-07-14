package com.ifc.InfoCuySB.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ifc.InfoCuySB.Model.ServiceTypes;

@Repository
public interface ServiceTypesRepository extends JpaRepository<ServiceTypes, Long> {
}
