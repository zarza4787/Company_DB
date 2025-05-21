package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.modelos.Dao;
import excepciones.DataAccessException;
import excepciones.DatoIncorrrectoException;
import modelos.Employee;
import utils.DBUtils;

/**
 * Implementa las operaciones basicas para insertar, eliminar, actualizar
 * Clase DAO para la gestión de empleados en la base de datos. 
 */

public class EmpleadoDAO implements Dao<Employee> {

	private final String QUERY_INSERTAR_EMPLEADO = "INSERT INTO EMPLOYEES (FIRST_NAME, LAST_NAME, EMAIL, PHONE, HIRE_DATE, MANAGER_ID, JOB_TITLE) VALUES (?, ?, ?, ?, ?, ?, ?)";
	private final String QUERY_ELIMINAR_EMPLEADO = "DELETE FROM EMPLOYEES WHERE employee_id = ?";
	private final String QUERY_ACTUALIZAR_EMPLEADO = "UPDATE EMPLOYEES SET FIRST_NAME = ?, LAST_NAME = ?, EMAIL = ?, PHONE = ?, JOB_TITLE = ? WHERE EMPLOYEE_ID = ?";
	private final String QUERY_OBTENER_TODOS = "SELECT * FROM EMPLOYEES";

	
	/**
	 * Insertar un nuevo empleado en la base de datos
	 * 
	 * @param e El empleado a insertar
	 * @throws DataAccessException Si hay datos inválidos o error en la base de datos
	 */
	@Override
	public void insertar(Employee e) throws DataAccessException, ClassNotFoundException {

		if (e == null || e.getName() == null || e.getEmail() == null || e.getHireDate() == null) {
			throw new DataAccessException("Datos del empleado inválidos");
		}

		try (Connection conn = DBUtils.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(QUERY_INSERTAR_EMPLEADO);

			ps.setString(1, e.getName());
			ps.setString(2, e.getLastName());
			ps.setString(3, e.getEmail());
			ps.setString(4, e.getPhone());
			Date fechaAlta = Date.valueOf(e.getHireDate());
			ps.setDate(5, fechaAlta);
			ps.setLong(6, e.getManagerId());
			ps.setString(7, e.getJobTitle());

			ps.executeUpdate();

		} catch (SQLException sql) {
			throw new DataAccessException("Error al insertar el empleado", sql);
		}
	}

	/**
	 * Eliminar empleados de la base de datos
	 * Actualiza a null el empleado en las tablas Orders y Employees
	 * Se usa el autocommit para evitar errores en la base de datos
	 * 
	 * @param e El empleado a eliminar 
	 */
	@Override
	public void eliminar(Employee e) throws DataAccessException, ClassNotFoundException {
		Connection conn = null;

		try {
			conn = DBUtils.getConnection();
			conn.setAutoCommit(false);

			String QUERY_UPDATE_ORDERS_PARA_NULL = "UPDATE ORDERS SET SALESMAN_ID = NULL WHERE SALESMAN_ID = ?";
			try (PreparedStatement ps1 = conn.prepareStatement(QUERY_UPDATE_ORDERS_PARA_NULL)) {
				ps1.setLong(1, e.getEmployeeID());
				ps1.executeUpdate();
			}

			String QUERY_UPDATE_MANAGER_PARA_NULL = "UPDATE EMPLOYEES SET MANAGER_ID = NULL WHERE MANAGER_ID = ?";
			try (PreparedStatement ps2 = conn.prepareStatement(QUERY_UPDATE_MANAGER_PARA_NULL)) {
				ps2.setLong(1, e.getEmployeeID());
				ps2.executeUpdate();
			}

			try (PreparedStatement ps3 = conn.prepareStatement(QUERY_ELIMINAR_EMPLEADO)) {
				ps3.setLong(1, e.getEmployeeID());
				int filasAfectadas = ps3.executeUpdate();

				if (filasAfectadas == 0) {
					throw new DataAccessException("No se pudo eliminar el empleado, ID no encontrado");
				}
			}

			conn.commit();

		} catch (SQLException ex) {
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException rollbackEx) {
					throw new DataAccessException("Error al hacer rollback de la transacción", rollbackEx);
				}
			}
			throw new DataAccessException("Error durante la eliminación del empleado", ex);

		}
	}

	/**
	 * @param e El empleado a actualizar, se usa employeeId
	 */
	
	@Override
	public void actualizar(Employee e) throws DataAccessException, ClassNotFoundException {
		try (Connection conn = DBUtils.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(QUERY_ACTUALIZAR_EMPLEADO);

			ps.setString(1, e.getName());
			ps.setString(2, e.getLastName());
			ps.setString(3, e.getEmail());
			ps.setString(4, e.getPhone());
			ps.setString(5, e.getJobTitle());
			ps.setLong(6, e.getEmployeeID());

			ps.executeUpdate();

		} catch (SQLException sql) {
			throw new DataAccessException("Hubo un error al actualizar el empleado", sql);
		}
	}
	
	/**
	 * Obtener lista de empleados encontrados
	 * 
	 * @return Devulve lista de empleados
	 * @throws Lanzamos DataAccessException por si ocurre algun error en la capa de acceso
	 */

	@Override
	public List<Employee> obtenerTodos() throws DataAccessException, ClassNotFoundException {
		List<Employee> empleadosList = new ArrayList<>();

		try (Connection conn = DBUtils.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(QUERY_OBTENER_TODOS);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				long employeeId = rs.getLong("EMPLOYEE_ID");
				String firstName = rs.getString("FIRST_NAME");
				String lastName = rs.getString("LAST_NAME");
				String email = rs.getString("EMAIL");
				String phone = rs.getString("PHONE");
				String hireDate = rs.getString("HIRE_DATE");
				long managerId = rs.getLong("MANAGER_ID");
				String jobTitle = rs.getString("JOB_TITLE");

				Employee empleado = new Employee(employeeId, firstName, lastName, email, phone, hireDate, managerId,
						jobTitle);
				empleadosList.add(empleado);
			}

		} catch (SQLException | DatoIncorrrectoException ex) {
			throw new DataAccessException("Error al obtener empleados", ex);
		}

		return empleadosList;
	}

}
