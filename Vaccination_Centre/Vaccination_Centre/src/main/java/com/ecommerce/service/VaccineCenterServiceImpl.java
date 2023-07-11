package com.ecommerce.service;

import java.util.List; 

import org.springframework.stereotype.Service; 
  
import com.ecommerce.entity.VaccineCenter; 
import com.ecommerce.repository.VaccineCenterRepository; 
  
@Service 
public class VaccineCenterServiceImpl implements VaccineCenterService { 
private final VaccineCenterRepository vaccineCenterRepository; 
  
public VaccineCenterServiceImpl(VaccineCenterRepository vaccineCenterRepository) { 
this.vaccineCenterRepository = vaccineCenterRepository; 
} 
  
@Override 
public VaccineCenter addVaccineCenter(VaccineCenter vaccineCenter) { 
return vaccineCenterRepository.save(vaccineCenter); 
} 
  
@Override 
public void updateVaccineCenter(VaccineCenter updatedVaccineCenter) { 
VaccineCenter existingCenter = 
vaccineCenterRepository.findById(updatedVaccineCenter.getId()) 
.orElseThrow(() -> new NotFoundException("Vaccine center not found")); 
  
existingCenter.setCenter(updatedVaccineCenter.getCenter()); 
existingCenter.setCity(updatedVaccineCenter.getCity()); 
 
vaccineCenterRepository.save(existingCenter); 
} 
  
@Override 
public void deleteVaccineCenter(Long id) { 
VaccineCenter existingCenter = vaccineCenterRepository.findById(id) 
.orElseThrow(() -> new NotFoundException("Vaccine center not found")); 
  
vaccineCenterRepository.delete(existingCenter); 
} 
  
@Override 
public VaccineCenter getVaccineCenterById(Long id) { 
return vaccineCenterRepository.findById(id) 
.orElseThrow(() -> new NotFoundException("Vaccine center not found")); 
} 
  
@Override 
public List<VaccineCenter> getAllVaccineCenters() { 
return vaccineCenterRepository.findAll(); 
} 
  
public class NotFoundException extends RuntimeException { 
public NotFoundException(String message) { 
super(message); 
} 
} 
} 
 