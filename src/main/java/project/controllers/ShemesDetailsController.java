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

import project.entities.ShemeDetail;
import project.repositories.ShemesDetailsRepository;

@RestController
@RequestMapping("/shemes_details")
//@PreAuthorize("hasAuthority('ADMIN')")
public class ShemesDetailsController {
	 @Autowired
	 ShemesDetailsRepository shemes;
	 
	 @RequestMapping(method = RequestMethod.GET)
	 public List<ShemeDetail> getShemesDetail()
	 {
		 List<ShemeDetail> result = new ArrayList<>();
	     shemes.findAll().forEach(result::add);
	     return result;
	 }
	 
	 @RequestMapping(method = RequestMethod.POST)
	 public ShemeDetail addShemeDetail(String shemename, String info){
		 //no empty fields allowed
		 if (shemename.isEmpty() || info.isEmpty())
			 return null;
	     return shemes.save(new ShemeDetail(shemename, info));
	 }
	 
	 @RequestMapping(value = "/add",method = RequestMethod.GET)
	 public ModelAndView getShemeDetailForm(){
		 return new ModelAndView("add_sheme");
	 }
	 
	 @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	 public void delete(@PathVariable("id") Long id){
		 shemes.delete(id);
	 }

	 @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	 public ShemeDetail getShemeDetail(@PathVariable("id") Long id){
	        return shemes.findOne(id);
	 }
}