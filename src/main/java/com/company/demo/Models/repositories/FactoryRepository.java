package com.company.demo.Models.repositories;


import com.company.demo.Models.Factory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactoryRepository extends JpaRepository<Factory, Integer>{
}
