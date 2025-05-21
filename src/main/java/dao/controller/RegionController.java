package dao.controller;

import java.util.List;

import dao.RegionDAO;
import excepciones.DataAccessException;
import modelos.Countries;
import modelos.Location;
import modelos.Region;

/*
 * Controlador encargado de gestionar las operaciones relacionadas con las regiones
 */
public class RegionController {

	private RegionDAO regionDAO;

	/**
	 * Constructor que inicializa el DAO de regiones.
	 */
	public RegionController() {
		this.regionDAO = new RegionDAO();
	}

	/**
	 * Obtiene todas las regiones disponibles
	 * 
	 * @return Lista de objetos de Region
	 * @throws DataAccessException si ocurre un error al acceder a los datos
	 */
	public List<Region> obtenerTodasRegiones() throws DataAccessException {
		try {
			return regionDAO.obtenerRegiones();
		} catch (Exception e) {
			throw new DataAccessException("Error al obtener las regiones", e);
		}
	}

	/**
	 * Obtiene la lista de paises que pertenecen a una region especifica
	 * 
	 * @param regionId id de la region
	 * @return Lista de objetos Countries.
	 * @throws DataAccessException si ocurre un error al acceder a los datos
	 */
	public List<Countries> obtenerPaisesPorRegion(int regionId) throws DataAccessException {
		try {
			return regionDAO.obtenerPaisesPorRegion(regionId);
		} catch (Exception e) {
			throw new DataAccessException("Error al obtener los paises por region", e);
		}
	}

	/**
	 * Obtiene la lista de ubicaciones dentro de un pais especifico
	 * 
	 * @param countryId id del pais
	 * @return Lista de objetos Location
	 * @throws DataAccessException si ocurre un error al acceder a los datos
	 */
	public List<Location> obtenerUbicacionesPorPais(String countryId) throws DataAccessException {
		try {
			return regionDAO.obtenerUbicacionesPorPais(countryId);
		} catch (Exception e) {
			throw new DataAccessException("Error al obtener las ubicaciones por paises", e);
		}
	}

}
