package com.contacts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.contacts.dto.Contact;
import com.contacts.service.ContcatService;

@RestController
public class ViewController {

	@Autowired
	private ContcatService contactService;
	
	@GetMapping("/edit/{contactId}")
	public String getContactById(@PathVariable("contactId")Integer contactId,Model model)
	{
		Contact contact=contactService.getContactById(contactId);
		
		model.addAttribute("contcat", contact);
		return "contactInfo";
		
	}
	
	@GetMapping("/deleteConttcat/{contactId}")
	public void deleteContactById(@PathVariable("contactId")Integer contactId)
	{
		contactService.deleteContactById(contactId);
	}
	
}
