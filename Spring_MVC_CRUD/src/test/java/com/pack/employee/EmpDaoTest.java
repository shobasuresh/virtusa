package com.pack.employee;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.pack.employee.dao.EmployeeDao;
import com.pack.employee.model.Employee;

 
 @SpringBootTest
class EmpDaoTest {
	
	@Autowired
	EmployeeDao dao;
	
	Employee e;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	  e=new Employee("testabc","testemail","testM","testcountry");
	}

	@AfterEach
	void tearDown() throws Exception {
		e=null;
	}

	  @Test
	     @Transactional
	     @Rollback(true)
	void empInsertTest() {
		
		int j=dao.insert(e);
		assertNotEquals(0,j);
	 
	}
	
	
	
	   @Test
	   @Transactional
	   @Rollback(true)
	  void empModifyTest() {
		  List<Employee> empList= dao.viewAll();
	  int id= empList.get(empList.size()-1).getId();
	  Employee 	  e1=dao.getEmpById(id);
	  e1.setEmail("newEmail");
	  int j= dao.modify(e1);
	  assertNotEquals(0,j); 
	  }
	 
	 
	
	}

 
