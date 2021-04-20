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

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.ideas2it.Employee.Application.dao.EmployeeDao;
import com.ideas2it.Employee.Application.model.Address;
import com.ideas2it.Employee.Application.model.Employee;
import com.ideas2it.Employee.Application.model.PersonalDetails;

/**
 * @description EmployeeDao made jdbc connectivity using hibernate for the employeeApplication
 * @author GAYATHIRI
 * @version 1.0
 */
@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	@PersistenceContext
	private EntityManager entityManager;
	//LoggerClass logger = new LoggerClass();
	/* Logger logger = Logger.getLogger(EmployeeDaoImpl.class.getName()); */
	
	public EmployeeDaoImpl() {
	}
	
	@Autowired
	public EmployeeDaoImpl(EntityManager entityManager) {
		entityManager = entityManager;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public void insertEmployee(double salary, String companyName, String designation, int experience, String status, String name, String  phoneNumber, String emailId, String dateOfBirth, Address currentAddress, Address permanentAddress) {
		//logger.loggerInfo("Inserting values for employee");
		Session session = entityManager.unwrap(Session.class);
		Employee employee = new Employee(companyName, salary, experience, designation, status); 
		PersonalDetails personalDetails = new PersonalDetails(name, emailId, dateOfBirth, phoneNumber);
		  employee.setPersonalDetails(personalDetails);
		  Set <Address> address = new HashSet <Address> ();
			address.add(currentAddress);
			address.add(permanentAddress);
		  personalDetails.setAddressSet(address);
			/*
			 * currentAddress.setPersonalDetails(personalDetails);
			 * permanentAddress.setPersonalDetails(personalDetails);
			 */
		  session.save(employee);
		  session.save(personalDetails); 
			/*
			 * session.save(currentAddress); session.save(permanentAddress);
			 */
		session.close();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public List <Employee> viewEmployee() {
		//logger.loggerInfo("Display All values for employee");
		Session session = entityManager.unwrap(Session.class);
		List <Employee> employeeList = ((Query) session.createQuery("from Employee")).getResultList();
		return employeeList;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override 
	@Transactional
	public Employee employeeViewById(int employeeId) {
		//logger.loggerInfo("Display values for employee");
		Session session = entityManager.unwrap(Session.class);
		Employee employee = (Employee) session.get(Employee.class, employeeId);
		return employee;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Integer> isDuplicate(long phoneNumber, String emailId) {
		//logger.loggerInfo("Checking duplicate values for employee");
		Session session = entityManager.unwrap(Session.class);
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
	@Transactional
	@Override
	public int deleteEmployee(int employeeId) {
		//logger.loggerInfo("Deleting values for employee");
		int countEmployee = 0;
		Session session = entityManager.unwrap(Session.class);
		Query deleteQuery = (Query) session.createQuery("update Employee employee set status = 'INACTIVE' where employee.employeeId = :employeeId");
		deleteQuery.setParameter("employeeId", employeeId);
		countEmployee =  deleteQuery.executeUpdate();
		session.close();
		return countEmployee;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public int updatePersonalDetails(int employeeId, long phoneNumber, String emailId) {
		//logger.loggerInfo("Updating values for employee");
		int updateCount = 0, personalId = 0;
		Session session = entityManager.unwrap(Session.class);
		Employee employee = employeeViewById(employeeId);
		PersonalDetails personalDetails = employee.getPersonalDetails();
		personalId = personalDetails.getPersonalId();
		String mobileNumber = Long.toString(phoneNumber);
		Query UpdateQuery = (Query) session.createQuery("update PersonalDetails personalDetails set personalDetails.phoneNumber = :mobileNumber, personalDetails.emailId = :emailId where personalDetails.personalId = :personalId");
		UpdateQuery.setParameter("mobileNumber", mobileNumber);
		UpdateQuery.setParameter("emailId", emailId);
		UpdateQuery.setParameter("personalId", personalId);
		updateCount =  UpdateQuery.executeUpdate();
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
