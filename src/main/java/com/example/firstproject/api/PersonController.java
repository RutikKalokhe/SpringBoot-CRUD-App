package com.example.firstproject.api;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.firstproject.model.Person;
import com.example.firstproject.service.PersonService;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {

	@Autowired
	private PersonService personService;

	@PostMapping
	public Person addPerson(@RequestBody Person person) {

		return personService.addPerson(person);
	}

	@GetMapping
	public List<Person> getAllPerson() {
		return personService.getAllPersons();
	}

	@GetMapping(path = "{id}")
	public Optional<Person> getPersonById(@PathVariable("id") int id) {
		return personService.getPersonById(id);
	}

	@DeleteMapping(path = "{id}")
	public int deletePerson(@PathVariable("id") int id) {
		return personService.deletePerson(id);
	}

	@PutMapping("{id}")
	public int updatePerson(@PathVariable("id") int id, @Valid @NonNull @RequestBody Person person) {
		System.out.println(id);
		System.out.println(person.getName());
		return personService.updatePerson(id, person.getName());
	}
}
