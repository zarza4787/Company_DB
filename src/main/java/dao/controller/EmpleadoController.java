package dao.controller;

import java.util.List;

import dao.EmpleadoDAO;
import excepciones.DataAccessException;
import excepciones.DatoIncorrrectoException;
import modelos.Employee;

public class EmpleadoController {

	private EmpleadoDAO empleadoDAO;

	public EmpleadoController() {
		this.empleadoDAO = new EmpleadoDAO();
	}

	public void crearEmpleado(String firstName, String lastName, String email, String phone, String hireDate,
			long managerId, String jobTitle) throws DataAccessException, ClassNotFoundException {
		try {
			Employee nuevoEmpleado = new Employee(firstName, lastName, email, phone, hireDate, managerId, jobTitle);
			empleadoDAO.insertar(nuevoEmpleado);
		} catch (DataAccessException | DatoIncorrrectoException e) {
			throw new DataAccessException("Hubo un error al crear el nuevo empleado", e);
		}
	}

	public void eliminarEmpleado(long employeeId) throws DataAccessException {
		try {
			Employee empleado = new Employee(employeeId);
			empleadoDAO.eliminar(empleado);
			System.out.println("Eliminando empleado con ID: " + empleado.getEmployeeID());
		} catch (Exception e) {
			throw new DataAccessException("Hubo un error al eliminar al empleado", e);
		}
	}

	public void actualizarEmpleado(long employeeId, String firstName, String lastName, String email, String phone,
			long managerId, String hireDate, String jobTitle) throws DatoIncorrrectoException, DataAccessException, ClassNotFoundException {
		try {
			Employee empleado = new Employee(employeeId, firstName, lastName, email, phone, hireDate, managerId,
					jobTitle);
			empleadoDAO.actualizar(empleado);
		} catch (DataAccessException e) {
			throw new DataAccessException("Hubo un error al actualizar el empleado", e);
		}
	}

	public List<Employee> obtenerTodosEmpleados() throws DataAccessException {
		try {
			return empleadoDAO.obtenerTodos();
		} catch (Exception e) {
			throw new DataAccessException("Hubo un error al obtener a los empleados ", e);
		}
	}
}
