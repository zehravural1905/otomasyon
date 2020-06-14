package model;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
	
	//EntityManager yard�m�yla bir insert atayaca��z. Kay�tlar� getirece�iz veya query �al��t�raca��z.
	
	
	@Entity
	@Table(name = "EmployeeTable")
	//Varsay�lan olarak Veritaban�ndaki tablo ismi ile s�n�f ismi ayn� olmak zorunda..
	//Tablo ismini de�i�tirmak i�in @Table annotation'lar�ndan yararlan�r�z.
	public class Employee {
		
		@Id 
		
		//Basic g�sterimi
			//@GeneratedValue(strategy = GenerationType.AUTO)
		 
				//primary key �retmek i�in @GeneretedValue annotation'�n� kullanabiliriz.
				//Auto
				//Table
				//Sequence
				//Identity
				
		//Basic g�sterim
			//@GeneratedValue(strategy = GenerationType.TABLE)

	
		@GeneratedValue(strategy = GenerationType.SEQUENCE)
		
		
		//column/kolon isimlerini de�i�tirmek i�in @Column annotation'�n� kullan�r�z.
		//Hangi kolon ismini de�i�tirmek istiyorsak o �zelli�in hemen �zerinde de�i�iklik yapar�z..
			@Column(name = "emp_id")
			private int id;
			private String name;
	
			@Column(name = "emp_salary")
			private String surname;
			private int salary;
			
			
			@Enumerated(EnumType.STRING)  	//Varsay�lan olarak ordinaldir.String dersek String de�erlerini d�ner.
			private EmployeeType employeeType;
			
			
			@Temporal(TemporalType.DATE)	//TIMESTAMP dersem; �uan ki zaman� oldu�u gibi olacakt�r.
			private Date startDate;
			
			
			@Lob
			private byte[] picture;
			
			
			@ManyToOne
			@JoinColumn(name = "emp_dept_id") 	//�li�kili veritabanlar�nda Kolon ismini de�i�tirmek i�in..
			private Department department;
			
			
			@OneToOne
				//Hibernate JPA implemantasyonu icin unique olmazsa HATA veriyor.
				//EclipseLink implementasyonu icin unique olmazsa hata yok. Bunun i�in a�a��daki fonk. kullanmal�y�z..
			@JoinColumn(name="ps_id", unique = true)
			private ParkingSpace parkingSpace;
			
			
			
			//default constructor gerekli!!! deglerasyonlar� yapm�� olduk. 
			public Employee() {
				super();
			}
		
			public Employee(String name, String surname, int salary) {
				super();
				this.name = name;
				this.surname = surname;
				this.salary = salary;
			}
		
			public int getId() {
				return id; 
			}
			public void setId(int id) {
				this.id = id;
			}
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			public String getSurname() {
				return surname;
			}
			public void setSurname(String surname) {
				this.surname = surname;
			}
			public int getSalary() {
				return salary;
			}
			public void setSalary(int salary) {
				this.salary = salary;
			}
		
			public EmployeeType getEmployeeType() {
				return employeeType;
			}
		
			public void setEmployeeType(EmployeeType employeeType) {
				this.employeeType = employeeType;
			}
		
			
			public Date getStartDate() {
				return startDate;
			}
		
			public void setStartDate(Date startDate) {
				this.startDate = startDate;
			}
		
			public byte[] getPicture() {
				return picture;
			}
		
			public void setPicture(byte[] picture) {
				this.picture = picture;
			}
		
			public Department getDepartment() {
				return department;
			}
	
			public void setDepartment(Department department) {
				this.department = department;
			}
	
			public ParkingSpace getParkingSpace() {
				return parkingSpace;
			}

			public void setParkingSpace(ParkingSpace parkingSpace) {
				this.parkingSpace = parkingSpace;
			}

			@Override
			public String toString() {
				return "Employee [id=" + id + ", name=" + name + ", surname=" + surname + ", salary=" + salary
						+ ", employeeType=" + employeeType + ", startDate=" + startDate + ", picture="
						+ Arrays.toString(picture) + "]";
			}
		
	
	}
