package com.example.demo.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.User;

public interface UserRepository extends JpaRepository<User , String>{

	@Query(value="select count(user_id) from user where user.user_id = ?1",  nativeQuery=true) 
	Long countUser(String userId);

}
