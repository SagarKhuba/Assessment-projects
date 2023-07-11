package com.ecommerce.service;

import java.util.List; 

import com.ecommerce.entity.VaccineCenter; 
  
public interface VaccineCenterService { 
  
VaccineCenter addVaccineCenter(VaccineCenter vaccineCenter); 
  
void updateVaccineCenter(VaccineCenter updatedVaccineCenter); 
  
void deleteVaccineCenter(Long id); 
  
VaccineCenter getVaccineCenterById(Long id); 
  
List<VaccineCenter> getAllVaccineCenters(); 
}