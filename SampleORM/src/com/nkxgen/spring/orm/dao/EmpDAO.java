package com.nkxgen.spring.orm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.nkxgen.spring.orm.model.Employee;

@Component
public class EmpDAO {

	@PersistenceContext
	private EntityManager em;

	public List<Employee> getAllEmployee() {
		return em.createQuery("SELECT e FROM Employee e").getResultList();
	}

	public void persist(Employee emp) {
		em.persist(emp);
	}

	public void delete(int empno) {
		Employee emp = em.find(Employee.class, empno);
		if (emp != null) {
			em.remove(emp);
		}
	}

	public void update(Employee emp) {
		em.merge(emp);
	}

	public Employee getEmployeeById(int id) {
		return em.find(Employee.class, id);
	}

}
