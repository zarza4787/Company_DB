package dao.controller;

import java.util.List;

import dao.WarehousesDAO;
import excepciones.DataAccessException;
import excepciones.DatoIncorrrectoException;
import modelos.Warehouse;

public class AlmacenController {

	private WarehousesDAO almacenDAO;

	public AlmacenController() {
		this.almacenDAO = new WarehousesDAO();
	}

	public void crearAlmacen(long locationId, String wareHouseName) throws DataAccessException, ClassNotFoundException {
		try {
			Warehouse almacen = new Warehouse(locationId, wareHouseName);
			almacenDAO.insertar(almacen);
		} catch (DatoIncorrrectoException e) {
			throw new DataAccessException("Datos incorrectos", e);
		}
	}

	public void eliminarAlmacen(long wareHouseId) throws DataAccessException, DatoIncorrrectoException, ClassNotFoundException {
		try {
			Warehouse almacen = new Warehouse(wareHouseId);
			almacenDAO.eliminar(almacen);
		} catch (DataAccessException e) {
			throw new DataAccessException("Hubo un error al eliminar el almacen", e);
		}
	}

	public void actualizarAlmacen(long wareHouseId, long locationId, String wareHouseName)
			throws DatoIncorrrectoException, DataAccessException, ClassNotFoundException {
		try {
			Warehouse almacen = new Warehouse(wareHouseId, locationId, wareHouseName);
			almacenDAO.actualizar(almacen);
		} catch (DataAccessException e) {
			throw new DataAccessException("Hubo un error al actualizar el almacen" + e);
		}
	}

	public List<Warehouse> obtenerTodosAlmacenes() throws DataAccessException {
		try {
			return almacenDAO.obtenerTodos();
		} catch (Exception e) {
			throw new DataAccessException("Error al obtener los almacenes", e);
		}
	}

}
