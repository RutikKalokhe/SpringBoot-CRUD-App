package com.example.firstproject.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.firstproject.model.Person;

public interface PersonDao extends JpaRepository<Person, Integer> {
	// private static List<Person> DB = new ArrayList<>();

	// get all persons
	List<Person> findAll();

	// get person data by its id
	Optional<Person> findById(int id);

	// update a person by id
//	@Modifying
//	@Query("update Person p set p.name=:name where p.id = :id")
//	void updatePersonById(@Param("id") int id, @Param("name") String name);

}
