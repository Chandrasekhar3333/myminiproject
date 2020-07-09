package com.contacts.service;

import java.util.List;

import com.contacts.dto.Contact;

public interface ContcatService {
	
	boolean saveContact(Contact c);

	List<Contact> getAllContacts();

	Contact getContactById(Integer cid);

	boolean deleteContact(Integer cid);

	void deleteContactById(Integer contactId);
}
