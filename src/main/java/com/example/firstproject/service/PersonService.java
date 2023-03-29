package com.example.firstproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.firstproject.dao.PersonDao;
import com.example.firstproject.model.Person;

@Service
public class PersonService {

	@Autowired
	private PersonDao personDao;

//    @Autowired
//    public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
//        this.personDao = personDao;
//    }

	public Person addPerson(Person person) {
		System.out.println(person);
		personDao.save(person);
		return person;

	}

	public List<Person> getAllPersons() {
		return personDao.findAll();
	}

	public Optional<Person> getPersonById(int id) {
		return personDao.findById(id);
	}

	@SuppressWarnings("deprecation")
	public int deletePerson(int id) {
		Person p = personDao.getById(id);

		personDao.delete(p);
		
		return id;

	}

	public int updatePerson(int id, String personName) {
		@SuppressWarnings("deprecation")
		Person p = personDao.getById(id);
		 p.setName(personName);
		 personDao.save(p);
		 return id ;
	}
}
