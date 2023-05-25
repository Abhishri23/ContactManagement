package com.sts;


	
	
	import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

	@RestController
	@RequestMapping("/api/contacts")
	public class ContactController {
	    private final ContactRepository contactRepository;

	    @Autowired
	    public ContactController(ContactRepository contactRepository) {
	        this.contactRepository = contactRepository;
	    }

	    @GetMapping
	    public ResponseEntity<List<Contact>> getAllContacts() {
	        List<Contact> contacts = contactRepository.findAll();
	        return ResponseEntity.ok(contacts);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Contact> getContactById(@PathVariable Long id) {
	        Contact contact = contactRepository.findById(id);
	               
	        return ResponseEntity.ok(contact);
	    }

	    @PostMapping
	    public ResponseEntity<Contact> createContact(@RequestBody Contact contact) {
	        Contact createdContact = contactRepository.save(contact);
	        return new ResponseEntity<>(createdContact, HttpStatus.CREATED);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Contact> updateContact(@PathVariable Long id, @RequestBody Contact contactDetails) {
	        Contact existingContact = contactRepository.findById(id);
	            
	        existingContact.setFirstName(contactDetails.getFirstName());
	        existingContact.setLastName(contactDetails.getLastName());
	        existingContact.setEmail(contactDetails.getEmail());
	        existingContact.setPhoneNumber(contactDetails.getPhoneNumber());
	        Contact updatedContact = contactRepository.save(existingContact);
	        return ResponseEntity.ok(updatedContact);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteContact(@PathVariable Long id) {
	        Contact contact = contactRepository.findById(id);
	        contactRepository.delete(contact);
	        return ResponseEntity.noContent().build();
	    }

	    @GetMapping("/search")
	    public ResponseEntity<List<Contact>> searchContacts(
	            @RequestParam(required = false) String firstName,
	            @RequestParam(required = false) String lastName,
	            @RequestParam(required = false) String email) {
	        List<Contact> contacts;
	        if (firstName != null) {
	            contacts = contactRepository.findByFirstNameContainingIgnoreCase(firstName);
	        } else if (lastName != null) {
	            contacts = contactRepository.findByLastNameContainingIgnoreCase(lastName);
	        } else if (email != null) {
	            contacts = contactRepository.findByEmailContainingIgnoreCase(email);
	        } else {
	            contacts = contactRepository.findAll();
	        }
	        return ResponseEntity.ok(contacts);
	    }
	

}
