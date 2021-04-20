/**
 * Provide the class necessary to create a dao class
 * To communicate with service and model classes
 *
 * @version 1.0
 * @since 1.0
 */
package com.ideas2it.Employee.Application.dao.Impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.query.Query;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.ideas2it.Employee.Application.Logger.LoggerClass;
import com.ideas2it.Employee.Application.dao.EmployeeDao;
import com.ideas2it.Employee.Application.model.Address;
import com.ideas2it.Employee.Application.model.Employee;
import com.ideas2it.Employee.Application.model.PersonalDetails;
//import main.java.com.ideas2it.project.model.Project;
import com.ideas2it.sessionManagement.SessionManagement;

/**
 * @description EmployeeDao made jdbc connectivity using hibernate for the employeeApplication
 * @author GAYATHIRI
 * @version 1.0
 */
public class EmployeeDaoImpl implements EmployeeDao {
	/* Logger logger = Logger.getLogger(EmployeeDaoImpl.class.getName()); */
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void insertEmployee(double salary, String companyName, String designation, int experience, String status, String name, String  phoneNumber, String emailId, String dateOfBirth, Address currentAddress, Address permanentAddress) {
		//logger.loggerInfo("Inserting values for employee");
		SessionFactory sessionFactory = SessionManagement.getInstance();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Employee employee = new Employee(companyName, salary, experience, designation, status); 
		PersonalDetails personalDetails = new PersonalDetails(name, emailId, dateOfBirth, phoneNumber);
		employee.setPersonalDetails(personalDetails);
		currentAddress.setPersonalDetails(personalDetails); 
		permanentAddress.setPersonalDetails(personalDetails);
		session.save(employee);
		session.save(personalDetails);
		session.save(currentAddress);
		session.save(permanentAddress);
		transaction.commit();
		session.close();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List <Employee> viewEmployee() {
		//logger.loggerInfo("Display All values for employee");
		SessionFactory sessionFactory = SessionManagement.getInstance();
		Session session = sessionFactory.openSession();
		List <Employee> employeeList = session.createQuery("from Employee", Employee.class).getResultList();
		return employeeList;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override 
	public Employee employeeViewById(int employeeId) {
		//logger.loggerInfo("Display values for employee");
		SessionFactory sessionFactory = SessionManagement.getInstance();
		Session session = sessionFactory.openSession();
		Employee employee = session.get(Employee.class, employeeId);
		return employee;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Integer> isDuplicate(long phoneNumber, String emailId) {
		//logger.loggerInfo("Checking duplicate values for employee");
		SessionFactory sessionFactory = SessionManagement.getInstance();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		String mobileNumber = Long.toString(phoneNumber);
		Criteria criteria = session.createCriteria(PersonalDetails.class);
		criteria.add(Restrictions.eq("phoneNumber", mobileNumber));
		List phoneList = criteria.list(); 
		List <Integer> employeeList = new ArrayList(); 
		employeeList.add(phoneList.size()); 
		Criteria criteriaEmailId = session.createCriteria(PersonalDetails.class);
		criteriaEmailId.add(Restrictions.eq("emailId", emailId)); 
		List emailIdList = criteriaEmailId.list(); 
		employeeList.add(emailIdList.size());
		transaction.commit();
		session.close();
		return employeeList;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int deleteEmployee(int employeeId) {
		//logger.loggerInfo("Deleting values for employee");
		int countEmployee = 0;
		SessionFactory sessionFactory = SessionManagement.getInstance();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query deleteQuery = session.createQuery("update Employee employee set status = 'INACTIVE' where employee.employeeId = :employeeId");
		deleteQuery.setParameter("employeeId", employeeId);
		countEmployee =  deleteQuery.executeUpdate();
		transaction.commit();
		session.close();
		return countEmployee;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int updatePersonalDetails(int employeeId, long phoneNumber, String emailId) {
		//logger.loggerInfo("Updating values for employee");
		int updateCount = 0, personalId = 0;
		Employee employee = employeeViewById(employeeId);
		PersonalDetails personalDetails = employee.getPersonalDetails();
		personalId = personalDetails.getPersonalId();
		SessionFactory sessionFactory = SessionManagement.getInstance();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		String mobileNumber = Long.toString(phoneNumber);
		Query UpdateQuery = session.createQuery("update PersonalDetails personalDetails set personalDetails.phoneNumber = :mobileNumber, personalDetails.emailId = :emailId where personalDetails.personalId = :personalId");
		UpdateQuery.setParameter("mobileNumber", mobileNumber);
		UpdateQuery.setParameter("emailId", emailId);
		UpdateQuery.setParameter("personalId", personalId);
		updateCount =  UpdateQuery.executeUpdate();
		transaction.commit();
		session.close();
		return updateCount;
	}

	/**
	 * {@inheritDoc}
	 *
	@Override
	public void addProjectEmployee(List <Integer> listId, int employeeId) {
		logger.loggerInfo("Add project values for employee");
		SessionFactory sessionFactory = SessionManagement.getInstance();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Employee employee = session.get(Employee.class, employeeId);
		List <Project> project = session.createQuery("select project from Project project where project.projectId IN :listId").setParameter("listId", listId).getResultList();
		System.out.println("employee list" + project);
		Set<Project> projectSet = new HashSet <Project>(project);
		employee.setProjectSet(projectSet);
		session.save(employee);
		transaction.commit();
		session.close();
	}*/
}
