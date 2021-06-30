package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Model.User;

/**
 * This interface is used to interact with database using jpa repository
 * 
 * @author GAYATHIRI
 *
 */
public interface UserRepository extends JpaRepository<User , String>{

	@Query(value="select count(user_id) from user where user.user_id = ?1", nativeQuery = true) 
	Long countUser(String userId);

	@Query(value="select * from user where user.user_name = ?1", nativeQuery = true)
	User findUserName(String username);
}
