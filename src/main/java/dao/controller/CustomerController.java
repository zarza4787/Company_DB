package dao.controller;

import java.util.List;

import dao.CustomersDAO;
import excepciones.DataAccessException;
import modelos.Customer;

public class CustomerController {

	private CustomersDAO customerDAO;

	public CustomerController() {
		this.customerDAO = new CustomersDAO();
	}

	public void crearCustomer(long customerId, String name, String address, String website, double creditLimit)
			throws DataAccessException, ClassNotFoundException {
		try {
			Customer nuevoCustomer = new Customer(customerId, name, address, website, creditLimit);
			customerDAO.insertar(nuevoCustomer);
		} catch (DataAccessException e) {
			throw new DataAccessException("Hubo un error al crear el cliente", e);
		}

	}

	public void eliminarCustomer(long customerId) throws DataAccessException, ClassNotFoundException {
		try {
			Customer customer = new Customer(customerId);
			customerDAO.eliminar(customer);
		} catch (DataAccessException e) {
			throw new DataAccessException("Hubo un error al eliminar al cliente", e);
		}
	}

	public void actualizarCustomer(long customerId, String name, String address, String website, double creditLimit)
			throws DataAccessException {
		try {
			Customer customerActualizar = new Customer(customerId, name, address, website, creditLimit);
			customerDAO.actualizar(customerActualizar);
		} catch (Exception e) {
			throw new DataAccessException("Hubo un error al actualizar el empleado", e);
		}
	}

	public List<Customer> obtenerTodosCustomers() throws DataAccessException {
		try {
			return customerDAO.obtenerTodos();
		} catch (Exception e) {
			//throw new DataAccessException("Hubo un error al obtener a los clientes ", e);
			throw new DataAccessException(e.getMessage());
		}
	}

	public Customer obtenerPorId(long customerId) throws DataAccessException {
		try {
			return customerDAO.obtenerPorId(customerId);
		} catch (Exception e) {
			throw new DataAccessException("Hubo un error al obtener a los clientes ", e);
		}
	}

}
