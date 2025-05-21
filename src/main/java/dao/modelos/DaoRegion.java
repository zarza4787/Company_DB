package dao.modelos;

import java.util.List;

import excepciones.DataAccessException;
import modelos.Countries;
import modelos.Location;
import modelos.Region;

public interface DaoRegion {

	List<Region> obtenerRegiones() throws DataAccessException, ClassNotFoundException;

	List<Countries> obtenerPaisesPorRegion(int regionId) throws DataAccessException, ClassNotFoundException;

	List<Location> obtenerUbicacionesPorPais(String countryId) throws DataAccessException, ClassNotFoundException;

}
