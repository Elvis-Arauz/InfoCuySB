package com.ifc.InfoCuySB.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ifc.InfoCuySB.Model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}