package com.ifc.InfoCuySB.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ifc.InfoCuySB.Model.Services;

@Repository
public interface ServicesRepository extends JpaRepository<Services, Long> {
}
