package com.ecommerce.service;

import java.util.List; 

import com.ecommerce.entity.Citizen; 
import com.ecommerce.entity.VaccineCenter; 
  
public interface CitizenService { 
void addCitizen(Citizen citizen); 
  
void updateCitizen(Citizen citizen); 
  
void deleteCitizen(Long id); 
  
Citizen getCitizenById(Long id); 
  
List<Citizen> getAllCitizens(); 
  
List<Citizen> getCitizensByVaccinationCenter(VaccineCenter vaccineCenter); 
} 