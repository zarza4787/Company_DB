package dao.controller;

import java.util.List;

import dao.CustomersDAO;
import excepciones.DataAccessException;
import modelos.Customer;

/**
 * Controlador para gestionar operaciones relacionadas con los clientes
 * (Customers).
 */
public class CustomerController {

	private CustomersDAO customerDAO;

	/**
	 * Constructor que inicializa el DAO de clientes.
	 */
	public CustomerController() {
		this.customerDAO = new CustomersDAO();
	}

	/**
	 * Crea un nuevo cliente con los datos especificados
	 * 
	 * @param customerId  id unico del cliente
	 * @param name        nombre del cliente
	 * @param address     dirección del cliente
	 * @param website     sitio web del cliente
	 * @param creditLimit limite de crédito del cliente
	 * @throws DataAccessException si ocurre un error al insertar el cliente
	 */
	public void crearCustomer(long customerId, String name, String address, String website, double creditLimit)
			throws DataAccessException, ClassNotFoundException {
		try {
			Customer nuevoCustomer = new Customer(customerId, name, address, website, creditLimit);
			customerDAO.insertar(nuevoCustomer);
		} catch (DataAccessException e) {
			throw new DataAccessException("Hubo un error al crear el cliente", e);
		}

	}

	/**
	 * Elimina un cliente a partir de su id
	 * 
	 * @param customerId id del cliente a eliminar
	 * @throws DataAccessException si ocurre un error al eliminar el cliente.
	 */
	public void eliminarCustomer(long customerId) throws DataAccessException, ClassNotFoundException {
		try {
			Customer customer = new Customer(customerId);
			customerDAO.eliminar(customer);
		} catch (DataAccessException e) {
			throw new DataAccessException("Hubo un error al eliminar al cliente", e);
		}
	}

	/**
	 * Actualiza los datos de un cliente existente
	 * 
	 * @param customerId  id del cliente
	 * @param name        nuevo nombre del cliente
	 * @param address     nueva direccion
	 * @param website     nuevo sitio web
	 * @param creditLimit nuevo limite de credito
	 * @throws DataAccessException si ocurre un error al actualizar el cliente.
	 */
	public void actualizarCustomer(long customerId, String name, String address, String website, double creditLimit)
			throws DataAccessException {
		try {
			Customer customerActualizar = new Customer(customerId, name, address, website, creditLimit);
			customerDAO.actualizar(customerActualizar);
		} catch (Exception e) {
			throw new DataAccessException("Hubo un error al actualizar el empleado", e);
		}
	}

	/**
	 * Muestra una lista con todos los clientes almacenados en la base de datos
	 * 
	 * @return Lista de objetos customer.
	 * @throws DataAccessException si ocurre un error al obtener los clientes
	 */
	public List<Customer> obtenerTodosCustomers() throws DataAccessException {
		try {
			return customerDAO.obtenerTodos();
		} catch (Exception e) {
			// throw new DataAccessException("Hubo un error al obtener a los clientes ", e);
			throw new DataAccessException(e.getMessage());
		}
	}

	/**
	 * Recupera un cliente a partir de su id
	 * 
	 * @param customerId id del cliente a buscar
	 * @return Objeto Customer si se encuentra, null en caso contrario.
	 * @throws DataAccessException si ocurre un error durante la operación de
	 *                             búsqueda.
	 */
	public Customer obtenerPorId(long customerId) throws DataAccessException {
		try {
			return customerDAO.obtenerPorId(customerId);
		} catch (Exception e) {
			throw new DataAccessException("Hubo un error al obtener a los clientes ", e);
		}
	}

}
