package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.modelos.Dao;
import excepciones.DataAccessException;
import modelos.Contact;
import utils.DBUtils;

public class ContactsDAO implements Dao<Contact> {

	private final String QUERY_INSERTAR_CONTACTO = "INSERT INTO CONTACTS (FIRST_NAME, LAST_NAME, EMAIL, PHONE)";
	private final String QUERY_ELIMINAR_CONTACTO = "DELETE FROM CONTACTS WHERE CONTACT_ID = ?";
	private final String QUERY_ACTUALIZAR_CONTACTO = "UPDATE CONTACTS SET FIRST_NAME = ?, LAST_NAME = ?, EMAIL = ?, PHONE = ? WHERE CONTACT_ID = ?";
	private final String QUERY_OBTENER_TODO = "SELECT * FROM CONTACTS";
	private final String QUERY_OBTENER_CUSTOMER_POR_CONTACTO = "SELECT * FROM CONTACTS WHERE CUSTOMER_ID = ?";

	@Override
	public void insertar(Contact c) throws DataAccessException, ClassNotFoundException {

		try (Connection conn = DBUtils.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(QUERY_INSERTAR_CONTACTO);

			ps.setString(1, c.getFirstName());
			ps.setString(2, c.getLastName());
			ps.setString(3, c.getEmail());
			ps.setString(4, c.getPhone());

			ps.executeUpdate();

		} catch (SQLException sql) {
			throw new DataAccessException("Error al insertar un contacto", sql);
		}
	}

	@Override
	public void eliminar(Contact c) throws DataAccessException, ClassNotFoundException {

		try (Connection conn = DBUtils.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(QUERY_ELIMINAR_CONTACTO);

			ps.setLong(1, c.getContactId());

			int columnasModificadas = ps.executeUpdate();

			if (columnasModificadas == 0) {
				throw new DataAccessException("No se pudo eliminar el contacto, ID no encontrado");
			}

		} catch (SQLException sql) {
			throw new DataAccessException("Hubo un error al eliminar el contacto", sql);
		}
	}

	@Override
	public void actualizar(Contact c) throws DataAccessException, ClassNotFoundException {

		try (Connection conn = DBUtils.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(QUERY_ACTUALIZAR_CONTACTO);

			ps.setString(1, c.getFirstName());
			ps.setString(2, c.getLastName());
			ps.setString(3, c.getEmail());
			ps.setString(4, c.getPhone());
			ps.setLong(5, c.getContactId());

			ps.executeUpdate();

		} catch (SQLException sql) {
			throw new DataAccessException("Hubo un error al actualizar al contacto", sql);
		}

	}

	@Override
	public List<Contact> obtenerTodos() throws DataAccessException, ClassNotFoundException {
		List<Contact> contactosList = new ArrayList<>();

		try (Connection conn = DBUtils.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(QUERY_OBTENER_TODO);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				long contactId = rs.getLong("CONTACT_ID");
				String firstName = rs.getString("FIRST_NAME");
				String lastName = rs.getString("LAST_NAME");
				String email = rs.getString("EMAIL");
				String phone = rs.getString("PHONE");
				long customerId = rs.getLong("CUSTOMER_ID");

				Contact contacto = new Contact(contactId, firstName, lastName, email, phone, customerId);
				contactosList.add(contacto);
			}

		} catch (SQLException ex) {
			throw new DataAccessException("Error al obtener a los contactos", ex);
		}

		return contactosList;
	}

	public Contact obtenerContactoPorCustomerId(long customerId) throws DataAccessException, ClassNotFoundException {

		try (Connection conn = DBUtils.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(QUERY_OBTENER_CUSTOMER_POR_CONTACTO);

			ps.setLong(1, customerId);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				long contactId = rs.getLong("CONTACT_ID");
				String firstName = rs.getString("FIRST_NAME");
				String lastName = rs.getString("LAST_NAME");
				String email = rs.getString("EMAIL");
				String phone = rs.getString("PHONE");
				long customerID = rs.getLong("CUSTOMER_ID");

				return new Contact(contactId, firstName, lastName, email, phone, customerID);

			} else {
				throw new DataAccessException("No se ha encontrado ningun contacto");
			}

		} catch (SQLException sql) {
			throw new DataAccessException("Error de base de datos", sql);
		}

	}

}
