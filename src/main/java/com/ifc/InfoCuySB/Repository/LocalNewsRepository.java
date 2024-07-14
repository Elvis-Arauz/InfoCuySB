package com.ifc.InfoCuySB.Repository;

import com.ifc.InfoCuySB.Model.LocalNews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalNewsRepository extends JpaRepository<LocalNews, Long> {
}
