package modelos;

import excepciones.DataAccessException;
import excepciones.DatoIncorrrectoException;

public class Employee {

	private long employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String hireDate;
	private long managerId;
	private String jobTitle;

	
	//Constructor empleado
	public Employee(long employeeId, String firstName, String lastName, String email, String phone, String hireDate,
			long managerId, String jobTitle) throws DatoIncorrrectoException {

		if (firstName == null || lastName == null) {
			throw new DatoIncorrrectoException("Los campos no pueden estar vacios");
		}

		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.hireDate = hireDate;
		this.managerId = managerId;
		this.jobTitle = jobTitle;
	}

	// Constructor para el controller
	public Employee(String firstName, String lastName, String email, String phone, String hireDate, long managerId,
			String jobTitle) throws DatoIncorrrectoException {

		if (firstName == null || lastName == null) {
			throw new DatoIncorrrectoException("Los campos no pueden estar vacios");
		}

		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.hireDate = hireDate;
		this.managerId = managerId;
		this.jobTitle = jobTitle;
	}

	// Constructor para eliminar empleado
	public Employee(long employeeId) throws DataAccessException {
		if (employeeId <= 0) {
			throw new DataAccessException("La ID tiene que ser un numero mayor que 0");
		}
	    this.employeeId = employeeId;
	}

	public long getEmployeeID() {
		return employeeId;
	}

	public String getName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public String getHireDate() {
		return hireDate;
	}

	public long getManagerId() {
		return managerId;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	@Override
	public String toString() {
		return "Empleado [EMPLOYEE_ID=" + employeeId + ", FIRST_NAME=" + firstName + ", LAST_NAME=" + lastName
				+ ", EMAIL=" + email + ", PHONE=" + phone + ", HIRE_DATE=" + hireDate + ", MANAGER_ID=" + managerId
				+ ", JOB_TITLE=" + jobTitle + "]";
	}

}