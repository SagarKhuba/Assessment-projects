package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.entity.VaccineCenter; 
  
public interface VaccineCenterRepository extends JpaRepository<VaccineCenter, Long> { 
// Add custom query methods if needed 
}