package dao.modelos;

import excepciones.DataAccessException;
import modelos.Customer;

/**
 * Interfaz que define operaciones específicas de acceso a datos para el modelo
 * Customer
 */
public interface DaoCustomer {

	/**
	 * Obtiene un cliente por su ID
	 * 
	 * @param customerId el ID del cliente a buscar
	 * @return el cliente correspondiente al ID
	 * @throws DataAccessException    si ocurre un error en el acceso a datos
	 */
	Customer obtenerClientePorId(int customerId) throws DataAccessException, ClassNotFoundException;

	/**
	 * Obtiene un cliente por su nombre
	 * 
	 * @param firstName el nombre del cliente a buscar
	 * @return el cliente correspondiente al nombre
	 * @throws DataAccessException    si ocurre un error en el acceso a datos
	 * @throws ClassNotFoundException si no se encuentra una clase requerida para la
	 *                                conexion
	 */
	Customer obtenerClientesPorNombre(String firstName) throws DataAccessException, ClassNotFoundException;
}
