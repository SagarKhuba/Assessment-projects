package com.ecommerce.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecommerce.entity.Citizen;
import com.ecommerce.entity.VaccineCenter;
import com.ecommerce.service.CitizenService;
import com.ecommerce.service.VaccineCenterService; 
  
@Controller 
@RequestMapping("/vaccine-centers") 
public class VaccineCenterController { 
  
private final VaccineCenterService vaccineCenterService; 
private final CitizenService citizenService; 
  
public VaccineCenterController(VaccineCenterService vaccineCenterService, CitizenService 
citizenService) { 
this.vaccineCenterService = vaccineCenterService; 
this.citizenService = citizenService; 
} 
  
@GetMapping 
public String getAllVaccineCenters(Model model) { 
List<VaccineCenter> vaccineCenters = vaccineCenterService.getAllVaccineCenters(); 
model.addAttribute("vaccineCenters", vaccineCenters); 
return "vaccine-center-details"; 
} 
  
@GetMapping("/add") 
public String showAddVaccineCenterForm(Model model) { 
model.addAttribute("vaccineCenter", new VaccineCenter()); 
return "add-vaccine-center"; 
} 
  
@PostMapping("/add") 
public String addVaccineCenter(@ModelAttribute("vaccineCenter") VaccineCenter 
vaccineCenter) { 
vaccineCenterService.addVaccineCenter(vaccineCenter); 
return "redirect:/vaccine-centers"; 
} 
  
@GetMapping("/{id}") 
public String viewVaccineCenter(@PathVariable("id") Long id, Model model) { 
VaccineCenter vaccineCenter = vaccineCenterService.getVaccineCenterById(id); 
List<Citizen> citizens = citizenService.getCitizensByVaccinationCenter(vaccineCenter); 
model.addAttribute("vaccineCenter", vaccineCenter); 
model.addAttribute("citizens", citizens); 
return "vaccine-center-view"; 
} 
  
@GetMapping("/{id}/edit") 
public String showEditVaccineCenterForm(@PathVariable("id") Long id, Model model) { 
VaccineCenter vaccineCenter = vaccineCenterService.getVaccineCenterById(id); 
if (vaccineCenter != null) { 
model.addAttribute("vaccineCenter", vaccineCenter); 
return "edit-vaccine-center"; 
} else { 
 
return "redirect:/vaccine-centers"; 
} 
} 
  
@PostMapping("/{id}/edit") 
public String updateVaccineCenter(@PathVariable("id") Long id, 
@ModelAttribute("vaccineCenter") VaccineCenter updatedVaccineCenter) { 
VaccineCenter vaccineCenter = vaccineCenterService.getVaccineCenterById(id); 
if (vaccineCenter != null) { 
vaccineCenter.setCenter(updatedVaccineCenter.getCenter()); 
vaccineCenter.setCity(updatedVaccineCenter.getCity()); 
vaccineCenterService.updateVaccineCenter(vaccineCenter); 
} 
return "redirect:/vaccine-centers"; 
} 
  
@GetMapping("/{id}/delete") 
public String deleteVaccineCenter(@PathVariable("id") Long id) { 
vaccineCenterService.deleteVaccineCenter(id); 
return "redirect:/vaccine-centers"; 
} 
} 