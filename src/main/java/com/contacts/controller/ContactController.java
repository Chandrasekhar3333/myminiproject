package com.contacts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.contacts.dto.Contact;
import com.contacts.service.ContcatService;

public class ContactController {
	@Autowired
	private ContcatService contactService;

	@GetMapping({ "/", "/login" })
	public String loadForm(Model model) {
		Contact c = new Contact();
		model.addAttribute("contact", c);
		return "contactinfo";// jsp page should match with logical name
	}

	@PostMapping("/saveContact")
	public String handleSubmitButton(@ModelAttribute("contact") Contact contact, Model model) {
		Boolean isSaved = contactService.saveContact(contact);
		
		if (isSaved != null) {
			model.addAttribute("successMsg", "contactsavedsuccefully");
		} 
			model.addAttribute("failedmsg", "contactfailed");
		

		return "contactinfo";

	}
	
	@GetMapping("/getAllContacts")
	public String getAll(Model model)
	{ 
		List<Contact> contacts=contactService.getAllContacts();
		model.addAttribute("contactslist", contacts);
		
		return "viewAll";
	}
}


