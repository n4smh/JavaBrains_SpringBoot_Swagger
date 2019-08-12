package io.n4smh.sample;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api")
public class AddressBookResource {

	ConcurrentHashMap<String, Contact> contacts = new ConcurrentHashMap<>();

	@GetMapping("/{id}")
	@ApiOperation(value = "Find contact by id", notes = "Provide an id to look-up specific contact from the address book", response = Contact.class)
	public Contact getContact(
			@ApiParam(value = "Id of the contact that needs to be retrived", required = true) @PathVariable String id) {
		return contacts.get(id);
	}

	@GetMapping("/")
	@ApiOperation(value = "Get all contact", notes = "Retrive all contact from the address book", response = Contact.class)
	public List<Contact> getAllContacts() {
		return new ArrayList<Contact>(contacts.values());
	}

	@PostMapping("/")
	@ApiOperation(value = "Add contact", notes = "Add new contact to the address book", response = Contact.class)
	public Contact addContact(@RequestBody Contact contact) {
		contacts.put(contact.getId(), contact);
		return contact;

	}

}
