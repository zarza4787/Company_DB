package dao.controller;

import java.util.List;

import dao.WarehousesDAO;
import excepciones.DataAccessException;
import excepciones.DatoIncorrrectoException;
import modelos.Warehouse;

/**
 * Controlador para gestionar la logica de negocio, se comunica con WarehouseDAO
 * 
 * Crear un nuevo almacen Eliminar un almacen existente Actualizar un almacen
 * Obtenter todos los almacenes
 */
public class AlmacenController {

	private WarehousesDAO almacenDAO;

	/**
	 * Constructor que inicializa el DAO de almacenes.
	 */
	public AlmacenController() {
		this.almacenDAO = new WarehousesDAO();
	}

	/**
	 * Crear un almacen con los datos proporcionados
	 * 
	 * @param locationId    ID ubicacion del almacen
	 * @param wareHouseName Nombre del almacen
	 * @throws DataAccessException    si ocurre un error al acceder a la base de
	 *                                datos o los datos son inválidos.
	 */
	public void crearAlmacen(long locationId, String wareHouseName) throws DataAccessException, ClassNotFoundException {
		try {
			Warehouse almacen = new Warehouse(locationId, wareHouseName);
			almacenDAO.insertar(almacen);
		} catch (DatoIncorrrectoException e) {
			throw new DataAccessException("Datos incorrectos", e);
		}
	}

	/**
	 * Elimina un almacén dado su ID.
	 * 
	 * @param wareHouseId id del almacen a eliminar
	 * @throws DataAccessException si ocurre un error al eliminar el almacén.
	 * @throws DatoIncorrrectoException si los datos del almacén son inválidos.
	 */
	public void eliminarAlmacen(long wareHouseId)
			throws DataAccessException, DatoIncorrrectoException, ClassNotFoundException {
		try {
			Warehouse almacen = new Warehouse(wareHouseId);
			almacenDAO.eliminar(almacen);
		} catch (DataAccessException e) {
			throw new DataAccessException("Hubo un error al eliminar el almacen", e);
		}
	}

	/**
	 * Actualiza los datos de un almacén existente.
	 * 
	 * @param wareHouseId id del actualizar a actualizar
	 * @param locationId nueva ubicación asociada.
	 * @param wareHouseName nuevo nombre del almacén.
	 * @throws DatoIncorrrectoException si los datos son inválidos.
	 * @throws DataAccessException si ocurre un error de acceso a los datos.
	 */
	public void actualizarAlmacen(long wareHouseId, long locationId, String wareHouseName)
			throws DatoIncorrrectoException, DataAccessException, ClassNotFoundException {
		try {
			Warehouse almacen = new Warehouse(wareHouseId, locationId, wareHouseName);
			almacenDAO.actualizar(almacen);
		} catch (DataAccessException e) {
			throw new DataAccessException("Hubo un error al actualizar el almacen" + e);
		}
	}

	/**
	 * Obtiene la lista de todos los almacenes registrados
	 * 
	 * @return Lista de objetos WareHouse
	 * @throws DataAccessException si ocurre un error al recuperar los datos
	 */
	public List<Warehouse> obtenerTodosAlmacenes() throws DataAccessException {
		try {
			return almacenDAO.obtenerTodos();
		} catch (Exception e) {
			throw new DataAccessException("Error al obtener los almacenes", e);
		}
	}

}
