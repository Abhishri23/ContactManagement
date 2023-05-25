package com.sts;


	
	import java.util.List;


	public interface ContactRepository {
	    List<Contact> findByFirstNameContainingIgnoreCase(String firstName);
	    List<Contact> findByLastNameContainingIgnoreCase(String lastName);
	    List<Contact> findByEmailContainingIgnoreCase(String email);
		List<Contact> findAll();
		Contact findById(Long id);
		Contact save(Contact contact);
		void delete(Contact contact);
	}

