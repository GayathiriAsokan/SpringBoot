/**
 * Doing the crud operations using repository
 */
package com.example.demo.Service;

import java.util.List;

import com.example.demo.Model.User;

/**
 * Doing the crud operations using repository
 */
public interface UserService {

	/**
	 * Get the values 
	 * @return
	 */
	public List<User> getAll();

	/**
	 * Inserting the user values
	 * @param user
	 * @return
	 */
	public String insertUser(User user);

	/**
	 * Updating the values of user
	 * @param user
	 * @return
	 */
	public String updateUser(User user);

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
	public User getById(String userId);
	
	/**
	 * Get the count values of user
	 */
	public int count();
}
