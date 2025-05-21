package modelos;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

import excepciones.DataAccessException;
import excepciones.DatoIncorrrectoException;

public class EmployeeTest {

    @Test
    public void testConstructorEmpleado() throws DatoIncorrrectoException {
        Employee emp = new Employee(1L, "Alvaro", "Zarza", "alvaro@mail.com", "111222333", "2023-02-02", 5L,
                "Programador Web");
        assertThat(emp.getEmployeeID(), is(1L));
        assertThat(emp.getName(), is("Alvaro"));
        assertThat(emp.getLastName(), is("Zarza"));
        assertThat(emp.getEmail(), is("alvaro@mail.com"));
        assertThat(emp.getPhone(), is("111222333"));
        assertThat(emp.getHireDate(), is("2023-02-02"));
        assertThat(emp.getManagerId(), is(5L));
        assertThat(emp.getJobTitle(), is("Programador Web"));
    }

    @Test
    public void testConstructorEmpleadoActualizar() throws DatoIncorrrectoException {
        Employee emp = new Employee("Juan", "Martínez", "juan@mail.com", "444555666", "2022-10-10", 2L, "Tester");
        assertThat(emp.getName(), is("Juan"));
        assertThat(emp.getLastName(), is("Martínez"));
        assertThat(emp.getEmail(), is("juan@mail.com"));
        assertThat(emp.getPhone(), is("444555666"));
        assertThat(emp.getHireDate(), is("2022-10-10"));
        assertThat(emp.getManagerId(), is(2L));
        assertThat(emp.getJobTitle(), is("Tester"));
    }

    @Test
    public void testConstructorEmpleadoEliminar() throws DataAccessException {
        Employee emp = new Employee(7L);
        assertThat(emp.getEmployeeID(), is(7L));
    }

    @Test
    public void testGetEmployeeID() throws DatoIncorrrectoException {
        Employee emp = new Employee(8L, "Marcos", "Gomez", "marcos@mail.com", "999888777", "2023-03-03", 4,
                "Departamento Financiero");
        assertThat(emp.getEmployeeID(), is(8L));
    }

    @Test
    public void testGetName() throws DatoIncorrrectoException {
        Employee emp = new Employee("Luis", "Fernandez", "luis@mail.com", "555555555", "2023-01-01", 1, "Ejecutivo");
        assertThat(emp.getName(), is("Luis"));
    }

    @Test
    public void testGetLastName() throws DatoIncorrrectoException {
        Employee emp = new Employee("Saul", "Hernandez", "saul@mail.com", "123123123", "2023-01-01", 1, "Director");
        assertThat(emp.getLastName(), is("Hernandez"));
    }

    @Test
    public void testGetEmail() throws DatoIncorrrectoException {
        Employee emp = new Employee("Mario", "Perez", "mario@mail.com", "111111111", "2023-01-01", 1, "Programador Web");
        assertThat(emp.getEmail(), is("mario@mail.com"));
    }

    @Test
    public void testGetPhone() throws DatoIncorrrectoException {
        Employee emp = new Employee("Jorge", "Navarro", "jorge@mail.com", "777777777", "2023-01-01", 1, "Ejecutivo");
        assertThat(emp.getPhone(), is("777777777"));
    }

    @Test
    public void testGetHireDate() throws DatoIncorrrectoException {
        Employee emp = new Employee("Manuel", "Gutierrez", "manuel@mail.com", "888888888", "2023-01-01", 1, "Fronted");
        assertThat(emp.getHireDate(), is("2023-01-01"));
    }

    @Test
    public void testGetManagerId() throws DatoIncorrrectoException {
        Employee emp = new Employee("Diego", "Llorente", "diego@mail.com", "666666666", "2023-01-01", 99L, "Director");
        assertThat(emp.getManagerId(), is(99L));
    }

    @Test
    public void testGetJobTitle() throws DatoIncorrrectoException {
        Employee emp = new Employee("Eustaquio", "Navarro", "eustaquio@mail.com", "000000000", "2023-01-01", 1L, "Backend");
        assertThat(emp.getJobTitle(), is("Backend"));
    }

    @Test
    public void testToString() throws DatoIncorrrectoException {
        Employee emp = new Employee(3, "Alex", "Torres", "alex@mail.com", "333333333", "2023-01-01", 1,
                "Fullstack");
        String texto = emp.toString();
        assertThat(texto, allOf(
            containsString("Alex"),
            containsString("Torres"),
            containsString("Fullstack"),
            containsString("3")
        ));
    }
}
