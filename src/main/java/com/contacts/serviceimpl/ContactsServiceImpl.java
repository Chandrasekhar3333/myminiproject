package com.contacts.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contacts.dto.Contact;
import com.contacts.entity.ContactEntity;
import com.contacts.repository.ContactRepository;
import com.contacts.service.ContcatService;
@Service
public class ContactsServiceImpl implements ContcatService {
	@Autowired
	private ContactRepository contactRepository;

	@Override
	public boolean saveContact(Contact c) {
		// TODO Auto-generated method stub
		ContactEntity entity=new ContactEntity();
		BeanUtils.copyProperties(c, entity);
		ContactEntity savedEntity=contactRepository.save(entity);
		
		return savedEntity.getContactId()!=null;
	}

	@Override
	public List<Contact> getAllContacts() {
		// TODO Auto-generated method stub
		List<ContactEntity> entityes=contactRepository.findAll();
		return entityes.stream()
				.map(entity->{
			Contact contact=new Contact();
			BeanUtils.copyProperties(entity, contact);
			return contact;
		}
		).collect(Collectors.toList());
	}

	@Override
	public Contact getContactById(Integer cid) {
		// TODO Auto-generated method stub
		Optional<ContactEntity> findById = contactRepository.findById(cid);
		if(findById.isPresent())
		{
			ContactEntity contactEntity = findById.get();
			Contact contact=new Contact();
			BeanUtils.copyProperties(contactEntity, contact);
			return contact;
		}
		
		
		return null;
	}

	@Override
	public boolean deleteContact(Integer cid) {
		// TODO Auto-generated method stub
		contactRepository.deleteById(cid);
		return true;
	}

	@Override
	public void deleteContactById(Integer contactId) {
		// TODO Auto-generated method stub
		contactRepository.deleteById(contactId);
	}

	

}
