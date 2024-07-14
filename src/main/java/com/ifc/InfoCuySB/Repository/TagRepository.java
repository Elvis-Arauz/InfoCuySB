package com.ifc.InfoCuySB.Repository;

import com.ifc.InfoCuySB.Model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
}
