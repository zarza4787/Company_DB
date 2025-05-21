package dao.modelos;

import excepciones.DataAccessException;
import modelos.Customer;

public interface DaoCustomer {

	Customer obtenerClientePorId(int customerId) throws DataAccessException, ClassNotFoundException;

	Customer obtenerClientesPorNombre(String firstName) throws DataAccessException, ClassNotFoundException;
}
