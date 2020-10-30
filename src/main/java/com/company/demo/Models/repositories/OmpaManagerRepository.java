package com.company.demo.Models.repositories;

import com.company.demo.Models.OmpaManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OmpaManagerRepository extends JpaRepository<OmpaManager, Integer> {
}

