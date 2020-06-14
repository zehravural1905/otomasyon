package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Department;
import model.Employee;
import model.ParkingSpace;

public class EmployeeDAOImpl implements EmployeeDAO {

	private EntityManager entityManager;
	
	public EmployeeDAOImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	public void insertEmployee(Employee employee) {
		EntityTransaction transaction=entityManager.getTransaction();		//e�er transaction'� ba�lat�p commit'lemezsek veritaban� olu�ur ama kay�t eklenmez. Hata da vermez.
		transaction.begin();
		entityManager.persist(employee);		 //persist kal�c� hale getirir. insert atad�m. ilgili objeyi veritaban�na aktard�m. commit ettim.
		transaction.commit();
	}

	@Override
	public Employee getEmployeeById(int id) {
		
		//read i�lemi yapt�k bu nedenle transaction.begin/commit kullanmaya gerek yok.
		//id'e g�re kay�t d�nd�rece�iz. dinamik olacak gelen id'e g�re d�necek 
		Employee employee=entityManager.find(Employee.class, id);
		return employee;
	}

	@Override
	public List<Employee> getEmployees() {
		
		//Query query=entityManager.createQuery("Selecet e Employee e");
		TypedQuery<Employee> query=entityManager.createQuery("Select e from Employee e",Employee.class);
		return query.getResultList();
	}

	@Override
	public void deleteEmployee(int id) {
		
		Employee employee=getEmployeeById(id);
		EntityTransaction transaction=entityManager.getTransaction();
		transaction.begin();
		entityManager.remove(employee);
		transaction.commit();
	}

	@Override
	public void raiseSalary(int id, int raise) {
		
		Employee employee=getEmployeeById(id);
		EntityTransaction transaction=entityManager.getTransaction();
		
		transaction.begin();
		employee.setSalary(employee.getSalary()+raise);
		transaction.commit();
		
		
	}

	@Override
	public void insertDepartment(Department department) {

		EntityTransaction transaction=entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(department); //persist kal�c� hale getirir. insert atad�m. ilgili objeyi veritaban�na aktard�m. commit ettim.
		transaction.commit();
		
	}

	@Override
	public void insertParkingSpace(ParkingSpace parkSpace) {

		EntityTransaction transaction=entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(parkSpace); //persist kal�c� hale getirir. insert atad�m. ilgili objeyi veritaban�na aktard�m. commit ettim.
		transaction.commit();
		
	}


	

}
