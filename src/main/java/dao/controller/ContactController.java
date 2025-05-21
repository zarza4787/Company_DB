package dao.controller;

import java.util.List;

import dao.ContactsDAO;
import excepciones.DataAccessException;
import modelos.Contact;

public class ContactController {

	private ContactsDAO contactsDAO;

	public ContactController() {
		this.contactsDAO = new ContactsDAO();
	}

	public void crearContacto(String firstName, String lastName, String email, String phone, long customerId)
			throws DataAccessException, ClassNotFoundException {
		try {
			Contact nuevoContact = new Contact(firstName, lastName, email, phone, customerId);
			contactsDAO.insertar(nuevoContact);
		} catch (DataAccessException e) {
			throw new DataAccessException("Hubo un error al crear el contacto", e);
		}

	}

	public void eliminarContacto(long contactId) throws DataAccessException, ClassNotFoundException {
		try {
			Contact contact = new Contact(contactId);
			contactsDAO.eliminar(contact);
		} catch (DataAccessException e) {
			throw new DataAccessException("Hubo un error al eliminar al contacto", e);
		}
	}

	public void actualizarContacto(long contactId, String firstName, String lastName, String email, String phone,
			long customerId) throws DataAccessException {
		try {
			Contact contactActualizar = new Contact(contactId, firstName, lastName, email, phone, customerId);
			contactsDAO.actualizar(contactActualizar);
		} catch (Exception e) {
			throw new DataAccessException("Hubo un error al actualizar el contacto", e);
		}
	}

	public List<Contact> obtenerTodosContactos() throws DataAccessException {
		try {
			return contactsDAO.obtenerTodos();
		} catch (Exception e) {
			throw new DataAccessException("Hubo un error al obtener a los contactos ", e);
		}
	}

	public Contact obtenerPorId(long customerId) throws DataAccessException {
		try {
			return contactsDAO.obtenerContactoPorCustomerId(customerId);
		} catch (Exception e) {
			throw new DataAccessException("Hubo un error al obtener a los clientes ", e);
		}
	}

}
