package dao.modelos;

import java.util.List;

import excepciones.DataAccessException;

public interface Dao<E> {

	void insertar(E obj) throws DataAccessException, ClassNotFoundException;

	void eliminar(E obj) throws DataAccessException, ClassNotFoundException;

	void actualizar(E obj) throws DataAccessException, ClassNotFoundException;

	List<E> obtenerTodos() throws DataAccessException, ClassNotFoundException;

	

}
