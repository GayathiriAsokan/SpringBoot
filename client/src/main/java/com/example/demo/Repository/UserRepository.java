package com.example.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.User;

import com.example.demo.Model.UserDetails;
/**
 * This interface is used to interact with database using jpa repository
 * 
 * @author GAYATHIRI
 *
 */
public interface UserRepository extends CrudRepository<UserDetails , String>{

	@Query(value="select count(user_id) from user where user.user_id = ?1",  nativeQuery=true) 
	Long countUser(String userId);

	User findByUserName(String username);

}
