package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.modelos.Dao;
import excepciones.DataAccessException;
import modelos.Customer;
import utils.DBUtils;

/**
 * Esta clase realiza las operaciones de insertar, eliminar, crear en base de
 * datos Implementa el DAO
 */

public class CustomersDAO implements Dao<Customer> {

	private final String QUERY_INSERTAR_CUSTOMER = "INSERT INTO CUSTOMERS (NAME, ADDRESS, WEBSITE, CREDIT_LIMIT) VALUES (?, ?, ?, ?)";
	private final String QUERY_ACTUALIZAR_CUSTOMER = "UPDATE CUSTOMERS SET NAME = ?, ADDRESS = ?, WEBSITE = ?, CREDIT_LIMIT = ? WHERE customer_id = ?";
	private final String QUERY_ELIMINAR_CUSTOMER = "DELETE FROM CUSTOMERS WHERE CUSTOMER_ID = ?";
	private final String QUERY_OBTENER_TODOS_CUSTOMERS = "SELECT * FROM CUSTOMERS";

	
	/**
	 * 
	 * @param c El customer a insertar
	 * @throws Lanzamos DataAccessException por si ocurre algun error en la capa de acceso
	 */
	@Override
	public void insertar(Customer c) throws DataAccessException, ClassNotFoundException {

		if (c == null || c.getName() == null || c.getAddress() == null || c.getWebsite() == null
				|| c.getCreditLimit() <= 0) {
			throw new DataAccessException("Datos del cliente no validos");
		}

		try (Connection conn = DBUtils.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(QUERY_INSERTAR_CUSTOMER);

			ps.setString(1, c.getName());
			ps.setString(2, c.getAddress());
			ps.setString(3, c.getWebsite());
			ps.setDouble(4, c.getCreditLimit());

			ps.executeUpdate();

		} catch (SQLException sql) {
			throw new DataAccessException("Error al insertar a un cliente", sql);
		}
	}

	
	/**
	 * @param c El customer a eliminar, se usa el customerId
	 * @throws Lanzamos DataAccessException por si ocurre algun error en la capa de acceso o no encuentra la ID
	 */
	@Override
	public void eliminar(Customer c) throws DataAccessException, ClassNotFoundException {
		try (Connection conn = DBUtils.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(QUERY_ELIMINAR_CUSTOMER);

			ps.setLong(1, c.getCustomerId());

			int columnasModificadas = ps.executeUpdate();

			if (columnasModificadas == 0) {
				throw new DataAccessException(
						"No se pudo eliminar el empleado, no he encontrado la ID: " + c.getCustomerId());
			}

		} catch (SQLException sql) {
			throw new DataAccessException("Error al eliminar a un cliente", sql);
		}

	}

	/**
	 * @param c El customer a eliminar
	 * @throws Lanzamos DataAccessException por si ocurre algun error en la capa de acceso
	 */
	@Override
	public void actualizar(Customer c) throws DataAccessException, ClassNotFoundException {
		try (Connection conn = DBUtils.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(QUERY_ACTUALIZAR_CUSTOMER);

			ps.setString(1, c.getName());
			ps.setString(2, c.getAddress());
			ps.setString(3, c.getWebsite());
			ps.setDouble(4, c.getCreditLimit());
			ps.setLong(5, c.getCustomerId());

			ps.executeUpdate();

		} catch (SQLException sql) {
			throw new DataAccessException("Error al actualizar a un cliente", sql);
		}

	}

	/**
	 * @return Lista con todos los clientes
	 * @throws Lanzamos DataAccessException por si ocurre algun error en la capa de acceso
	 */
	@Override
	public List<Customer> obtenerTodos() throws DataAccessException, ClassNotFoundException {
		List<Customer> customersList = new ArrayList<Customer>();

		try (Connection conn = DBUtils.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(QUERY_OBTENER_TODOS_CUSTOMERS);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				long customerId = rs.getLong("CUSTOMER_ID");
				String name = rs.getString("NAME");
				String address = rs.getString("ADDRESS");
				String website = rs.getString("WEBSITE");
				double creditLimit = rs.getDouble("CREDIT_LIMIT");

				Customer customer = new Customer(customerId, name, address, website, creditLimit);
				customersList.add(customer);
			}

		} catch (SQLException ex) {
			throw new DataAccessException("Error al obtener a los clientes" + ex.getMessage());
		}

		return customersList;
	}
	
	/**
	 * Obtiene un cliente por su ID.
	 * 
	 * @param customerId
	 * @return Cliente encontrado o null
	 * @throws DataAccessException Si ocurre un error en la base de datos
	 * @throws ClassNotFoundException
	 */

	public Customer obtenerPorId(long customerId) throws DataAccessException, ClassNotFoundException {
		String QUERY_OBTENER_POR_ID = "SELECT * FROM CUSTOMERS WHERE customer_id = ?";

		try (Connection conn = DBUtils.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(QUERY_OBTENER_POR_ID);
			ps.setLong(1, customerId);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				long customerID = rs.getLong("CUSTOMER_ID");
				String name = rs.getString("NAME");
				String address = rs.getString("ADDRESS");
				String website = rs.getString("WEBSITE");
				double creditLimit = rs.getDouble("CREDIT_LIMIT");

				return new Customer(customerID, name, address, website, creditLimit);

			} else {
				return null;
			}

		} catch (SQLException ex) {
			throw new DataAccessException("Error al obtener a los clientes", ex);
		}

	}

}
