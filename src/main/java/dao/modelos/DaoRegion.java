package dao.modelos;

import java.util.List;

import excepciones.DataAccessException;
import modelos.Countries;
import modelos.Location;
import modelos.Region;

/*
 * Interfaz que define las operaciones de acceso a datos relacionadas con las regiones,
 * países y ubicaciones
 * 
 */
public interface DaoRegion {

	/**
     * Obtiene la lista completa de regiones disponibles
     *
     * @return Lista de objetos Region.
     * @throws DataAccessException si ocurre un error durante el acceso a los datos
     */
	List<Region> obtenerRegiones() throws DataAccessException, ClassNotFoundException;

	/**
     * Obtiene los países pertenecientes a una region especifica
     *
     * @param regionId ID de la región de la cual se desean obtener los paises
     * @return Lista de objetos Countries pertenecientes a la region
     * @throws DataAccessException si ocurre un error durante el acceso a los datos.
     * @throws ClassNotFoundException
     */
	List<Countries> obtenerPaisesPorRegion(int regionId) throws DataAccessException, ClassNotFoundException;

	 /**
     * Obtiene las ubicaciones disponibles dentro de un pais especifico
     *
     * @param countryId ID del país del cual se desean obtener las ubicaciones
     * @return Lista de objetos Location correspondientes al pais.
     * @throws DataAccessException si ocurre un error durante el acceso a los datos.
     */
	List<Location> obtenerUbicacionesPorPais(String countryId) throws DataAccessException, ClassNotFoundException;

}
