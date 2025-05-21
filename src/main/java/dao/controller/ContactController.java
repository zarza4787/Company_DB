package dao.controller;

import java.util.List;

import dao.ContactsDAO;
import excepciones.DataAccessException;
import modelos.Contact;

public class ContactController {

	private ContactsDAO contactsDAO;

	/**
	 * Constructor que inicializa el DAO de contactos.
	 */
	public ContactController() {
		this.contactsDAO = new ContactsDAO();
	}

	/**
	 * Crea un nuevo contacto con los datos proporcionados
	 * 
	 * @param firstName nombre del contacto.
	 * @param lastName apellido del contacto.
	 * @param email correo electrónico.
	 * @param phone numero de telefono.
	 * @param customerId id del cliente asociado.
	 * @throws DataAccessException si ocurre un error al insertar el contacto.
	 */
	public void crearContacto(String firstName, String lastName, String email, String phone, long customerId)
			throws DataAccessException, ClassNotFoundException {
		try {
			Contact nuevoContact = new Contact(firstName, lastName, email, phone, customerId);
			contactsDAO.insertar(nuevoContact);
		} catch (DataAccessException e) {
			throw new DataAccessException("Hubo un error al crear el contacto", e);
		}

	}

	
	/**
	 * Elimina un contacto propocionando su ID
	 * 
	 * @param contactId id del contacto a eliminar
	 * @throws DataAccessException si ocurre un error al eliminar el contacto.
	 */
	public void eliminarContacto(long contactId) throws DataAccessException, ClassNotFoundException {
		try {
			Contact contact = new Contact(contactId);
			contactsDAO.eliminar(contact);
		} catch (DataAccessException e) {
			throw new DataAccessException("Hubo un error al eliminar al contacto", e);
		}
	}
	
	/**
	 * Actualiza los datos de un contacto existente
	 * 
	 * @param contactId id del contacto
	 * @param firstName nuevo nombre
	 * @param lastName nuevo apellido
	 * @param email nuevo correo electrónico
	 * @param phone nuevo numero telefono
	 * @param customerId nueva Id del cliente
	 * @throws DataAccessException si ocurre un error al actualizar el contacto.
	 */
	public void actualizarContacto(long contactId, String firstName, String lastName, String email, String phone,
			long customerId) throws DataAccessException {
		try {
			Contact contactActualizar = new Contact(contactId, firstName, lastName, email, phone, customerId);
			contactsDAO.actualizar(contactActualizar);
		} catch (Exception e) {
			throw new DataAccessException("Hubo un error al actualizar el contacto", e);
		}
	}

	/**
	 * Muestra una lista de todos los contactos registrados.
	 * 
	 * @return Lista de objetos Contacto.
	 * @throws DataAccessException si ocurre un error al acceder a la base de datos.
	 */
	public List<Contact> obtenerTodosContactos() throws DataAccessException {
		try {
			return contactsDAO.obtenerTodos();
		} catch (Exception e) {
			throw new DataAccessException("Hubo un error al obtener a los contactos ", e);
		}
	}

	/**
	 * Muestra un contacto dado el ID del cliente asociado.
	 * 
	 * @param customerId id del cliente.
	 * @return Objeto contacto en caso de encontrarlo, null en caso contrario.
	 * @throws DataAccessException si ocurre un error al acceder a la base de datos.
	 */
	public Contact obtenerPorId(long customerId) throws DataAccessException {
		try {
			return contactsDAO.obtenerContactoPorCustomerId(customerId);
		} catch (Exception e) {
			throw new DataAccessException("Hubo un error al obtener a los clientes ", e);
		}
	}

}
