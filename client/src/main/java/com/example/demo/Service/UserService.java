/**
 * Doing the crud operations using repository
 */
package com.example.demo.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Set;

import com.example.demo.Exception.CustomException;
import com.example.demo.Model.Role;
import com.example.demo.Model.UserDetails;

/**
 * Doing the crud operations using repository
 */
public interface UserService {

	/**
	 * Get user values 
	 * @return
	 */
	public List<UserDetails> getAll();

	/**
	 * Inserting the user values
	 * @param user
	 * @return
	 */
	public UserDetails insertUser(UserDetails user);

	/**
	 * Updating the values of user
	 * @param user
	 * @return
	 */
	public UserDetails updateUser(UserDetails user);

	/**
	 * Delete the user by id
	 * @param userId
	 * @return
	 */
	public String deleteUser(String userId);

	/**
	 * Get tthe  values using Id
	 * @param userId
	 * @return
	 */
	public UserDetails getById(String userId);

	/**
	 * Get the count values of user
	 * @param userId
	 * @return
	 */
	public Long count(String userId);

	/**
	 * Add roles to users 
	 * @param user
	 * @return
	 */
	public String userRoles(UserDetails user);

}
