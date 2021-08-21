package com.example.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.entity.Contact;
import com.example.repository.ContactRepository;


@Service
public class ContactServiceClass {
    @Autowired
    private ContactRepository repo;  
    public boolean saveContact(Contact contact) {
		 Contact cc=repo.save(contact);
		 if(cc.equals(null))
			 return false;
		 else
			 return true;
	}
    
	public List<Contact> getAllContacts() {
		return (List<Contact>) repo.findAll();
	}
	
	public Contact getContactById(Integer contactId) {
		Optional<Contact> ContactResponse =  repo.findById(contactId);
		Contact contact = ContactResponse.get();
		return contact;
	}
	
	public boolean deleteContactById(Integer contactId) {
		repo.deleteById(contactId);
		if(repo.existsById(contactId))
			return false;
		else
			return true;
	}

}
