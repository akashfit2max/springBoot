package com.springboot.web.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.web.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public List<User> findByName(String name);

	public List<User> findByNameAndCity(String name, String city);

//	findByNameStartingWith(String prefix)
//	findByEndingWith(String suffix)
//	 findByNameContaining(String words)
//	findByNameLike(String pattern)
//	findByAgeLessThan(int age)
//	findByAgeGreaterThanEqual(int age)

//	custome queries

	@Query("select u from User u")
	List<User> getAllUsers();

	@Query("select u from User u where u.name= :n and u.city=:c")
	List<User> getUserByName(@Param("n") String name, @Param("c") String city);

//	native query
	@Query(value = "select * from User where name = :n", nativeQuery = true)
	List<User> getUsers(@Param("n") String name);

}
