package modelos;

import static org.junit.Assert.*;

import org.junit.Test;

import excepciones.DataAccessException;
import excepciones.DatoIncorrrectoException;

public class EmployeeTest {

	@Test
	public void testConstructorEmpleado() throws DatoIncorrrectoException {
		Employee emp = new Employee(1, "Alvaro", "Zarza", "alvaro@mail.com", "111222333", "2023-02-02", 5,
				"Programador Web");
		assertEquals(1, emp.getEmployeeID());
		assertEquals("Alvaro", emp.getName());
		assertEquals("Zarza", emp.getLastName());
		assertEquals("alvaro@mail.com", emp.getEmail());
		assertEquals("111222333", emp.getPhone());
		assertEquals("2023-02-02", emp.getHireDate());
		assertEquals(5, emp.getManagerId());
		assertEquals("Programador Web", emp.getJobTitle());
	}

	@Test
	public void testConstructorEmpleadoActualizar() throws DatoIncorrrectoException {
		Employee emp = new Employee("Juan", "Martínez", "juan@mail.com", "444555666", "2022-10-10", 2L, "Tester");
		assertEquals("Juan", emp.getName());
		assertEquals("Martínez", emp.getLastName());
		assertEquals("juan@mail.com", emp.getEmail());
		assertEquals("444555666", emp.getPhone());
		assertEquals("2022-10-10", emp.getHireDate());
		assertEquals(2, emp.getManagerId());
		assertEquals("Tester", emp.getJobTitle());
	}

	@Test
	public void testConstructorEmpleadoEliminar() throws DataAccessException {
		Employee emp = new Employee(7);
		assertEquals(7, emp.getEmployeeID());
	}

	@Test
	public void testGetEmployeeID() throws DatoIncorrrectoException {
		Employee emp = new Employee(8, "Marcos", "Gomez", "marcos@mail.com", "999888777", "2023-03-03", 4,
				"Departamento Financiero");
		assertEquals(8, emp.getEmployeeID());
	}

	@Test
	public void testGetName() throws DatoIncorrrectoException {
		Employee emp = new Employee("Luis", "Fernandez", "luis@mail.com", "555555555", "2023-01-01", 1, "Ejecutivo");
		assertEquals("Luis", emp.getName());
	}

	@Test
	public void testGetLastName() throws DatoIncorrrectoException {
		Employee emp = new Employee("Saul", "Hernandez", "saul@mail.com", "123123123", "2023-01-01", 1, "Director");
		assertEquals("Hernandez", emp.getLastName());
	}

	@Test
	public void testGetEmail() throws DatoIncorrrectoException {
		Employee emp = new Employee("Mario", "Perez", "mario@mail.com", "111111111", "2023-01-01", 1, "Programador Web");
		assertEquals("mario@mail.com", emp.getEmail());
	}

	@Test
	public void testGetPhone() throws DatoIncorrrectoException {
		Employee emp = new Employee("Jorge", "Navarro", "jorge@mail.com", "777777777", "2023-01-01", 1, "Ejecutivo");
		assertEquals("777777777", emp.getPhone());
	}

	@Test
	public void testGetHireDate() throws DatoIncorrrectoException {
		Employee emp = new Employee("Manuel", "Gutierrez", "manuel@mail.com", "888888888", "2023-01-01", 1, "Fronted");
		assertEquals("2023-01-01", emp.getHireDate());
	}

	@Test
	public void testGetManagerId() throws DatoIncorrrectoException {
		Employee emp = new Employee("Diego", "Llorente", "diego@mail.com", "666666666", "2023-01-01", 99, "Director");
		assertEquals(99, emp.getManagerId());
	}

	@Test
	public void testGetJobTitle() throws DatoIncorrrectoException {
		Employee emp = new Employee("Eustaquio", "Navarro", "eustaquio@mail.com", "000000000", "2023-01-01", 1L, "Backend");
		assertEquals("Backend", emp.getJobTitle());
	}

	@Test
	public void testToString() throws DatoIncorrrectoException {
		Employee emp = new Employee(3, "Alex", "Torres", "alex@mail.com", "333333333", "2023-01-01", 1,
				"Fullstack");
		String texto = emp.toString();
		assertTrue(texto.contains("Alex"));
		assertTrue(texto.contains("Torres"));
		assertTrue(texto.contains("Fullstack"));
		assertTrue(texto.contains("3"));
	}
}
