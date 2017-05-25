package project.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.thymeleaf.spring4.view.ThymeleafView;

import java.util.ArrayList;
import java.util.List;

import project.entities.Detail;
import project.repositories.DetailsRepository;

@RestController
@RequestMapping("/details")
//@PreAuthorize("hasAuthority('ADMIN')")
public class DetailsController {
	 @Autowired
	 DetailsRepository details;
	 
	 @RequestMapping(method = RequestMethod.GET)
	 public List<Detail> getDetails()
	 {
		 List<Detail> result = new ArrayList<>();
	     details.findAll().forEach(result::add);
	     return result;
	 }
	 
	 @RequestMapping(method = RequestMethod.POST)
	 public Detail addDetail(String detailname, long powerV, String unitsV, long priceB){
		 //no empty fields allowed
		 if (detailname.isEmpty() || powerV==0 || unitsV.isEmpty() || priceB==0)
			 return null;
	     return details.save(new Detail(detailname, powerV, unitsV, priceB));
	 }
	 
	 @RequestMapping(value = "/add",method = RequestMethod.GET)
	 public ModelAndView getShemeForm(){
		 return new ModelAndView("add_detail");
	 }
	 
	 @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	 public void delete(@PathVariable("id") Long id){
		 details.delete(id);
	 }

	 @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	 public Detail getDetail(@PathVariable("id") Long id){
	        return details.findOne(id);
	 }
}