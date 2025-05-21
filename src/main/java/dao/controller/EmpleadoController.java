package dao.controller;

import java.util.List;

import dao.EmpleadoDAO;
import excepciones.DataAccessException;
import excepciones.DatoIncorrrectoException;
import modelos.Employee;

/**
 * Controlador para gestionar operaciones de los empleados
 */
public class EmpleadoController {

	private EmpleadoDAO empleadoDAO;

	/**
	 * Constructor que inicializa el DAO de empleados.
	 */
	public EmpleadoController() {
		this.empleadoDAO = new EmpleadoDAO();
	}

	/**
	 * Crea un nuevo empleado con los datos especificados.
	 * 
	 * @param firstName nombre del empleado.
	 * @param lastName apellido del empleado.
	 * @param email correo electrónico del empleado.
	 * @param phone numero de teléfono del empleado.
	 * @param hireDate fecha de contratación (formato YYYY-MM-DD).
	 * @param managerId id del gerente.
	 * @param jobTitle titulo del puesto.
	 * @throws DataAccessException    si ocurre un error al insertar en la base de
	 *                                datos.
	 */
	public void crearEmpleado(String firstName, String lastName, String email, String phone, String hireDate,
			long managerId, String jobTitle) throws DataAccessException, ClassNotFoundException {
		try {
			Employee nuevoEmpleado = new Employee(firstName, lastName, email, phone, hireDate, managerId, jobTitle);
			empleadoDAO.insertar(nuevoEmpleado);
		} catch (DataAccessException | DatoIncorrrectoException e) {
			throw new DataAccessException("Hubo un error al crear el nuevo empleado", e);
		}
	}

	/**
	 * Elimina un empleado de la base de datos a traves de su id
	 * 
	 * @param employeeId ID del empleado a eliminar
	 * @throws DataAccessException si ocurre un error durante la operacion
	 */
	public void eliminarEmpleado(long employeeId) throws DataAccessException {
		try {
			Employee empleado = new Employee(employeeId);
			empleadoDAO.eliminar(empleado);
			System.out.println("Eliminando empleado con ID: " + empleado.getEmployeeID());
		} catch (Exception e) {
			throw new DataAccessException("Hubo un error al eliminar al empleado", e);
		}
	}

	/**
	 * Actualiza los datos de un empleado existente
	 * 
	 * @param employeeId id del empleado.
	 * @param firstName nuevo nombre.
	 * @param lastName nuevo apellido.
	 * @param email nuevo correo electrónico.
	 * @param phone nuevo teléfono.
	 * @param managerId nuevo ID del gerente.
	 * @param hireDate nueva fecha de contratacion.
	 * @param jobTitle nuevo puesto.
	 * @throws DataAccessException si ocurre un error al actualizar en la base de datos.
	 * @throws DatoIncorrrectoException si los datos son inválidos.
	 */
	public void actualizarEmpleado(long employeeId, String firstName, String lastName, String email, String phone,
			long managerId, String hireDate, String jobTitle)
			throws DatoIncorrrectoException, DataAccessException, ClassNotFoundException {
		try {
			Employee empleado = new Employee(employeeId, firstName, lastName, email, phone, hireDate, managerId,
					jobTitle);
			empleadoDAO.actualizar(empleado);
		} catch (DataAccessException e) {
			throw new DataAccessException("Hubo un error al actualizar el empleado", e);
		}
	}

	/**
	 * Obtiene todos los empleados de la base de datos
	 * 
	 * @return Lista de empleados
	 * @throws DataAccessException si ocurre un error al recuperar los empleados.
	 */
	public List<Employee> obtenerTodosEmpleados() throws DataAccessException {
		try {
			return empleadoDAO.obtenerTodos();
		} catch (Exception e) {
			throw new DataAccessException("Hubo un error al obtener a los empleados ", e);
		}
	}
}
