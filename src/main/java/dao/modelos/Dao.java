package dao.modelos;

import java.util.List;

import excepciones.DataAccessException;

/**
 * Interfaz genérica para operaciones básicas de acceso a datos (DAO).
 * 
 * @param <E>
 */
public interface Dao<E> {

	/**
	 * Inserta un nuevo objeto en la base de datos
	 * 
	 * @param obj el objeto a insertar
	 * @throws DataAccessException si ocurre un error de acceso a datos.
	 */
	void insertar(E obj) throws DataAccessException, ClassNotFoundException;

	/**
	 * Elimina un objeto de la base de datos
	 * 
	 * @param obj el objeto a eliminar
	 * @throws DataAccessException si ocurre un error de acceso a datos
	 */
	void eliminar(E obj) throws DataAccessException, ClassNotFoundException;

	/**
	 * Actualiza un objeto existente en la base de datos
	 * 
	 * @param obj el objeto a actualizar
	 * @throws DataAccessException si ocurre un error de acceso a datos
	 */
	void actualizar(E obj) throws DataAccessException, ClassNotFoundException;

	/**
	 * Obtiene todos los objetos del tipo especificado desde la base de datos
	 * 
	 * @return una lista de objetos del tipo E
	 * @throws DataAccessException si ocurre un error de acceso a datos
	 */
	List<E> obtenerTodos() throws DataAccessException, ClassNotFoundException;

}
