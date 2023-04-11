package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.OfertaHabitacion;


public class SQLOfertaHabitacion {

	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Cadena que representa el tipo de consulta que se va a realizar en las sentencias de acceso a la base de datos
	 * Se renombra acá para facilitar la escritura de las sentencias
	 */
	private final static String SQL = PersistenciaAlohAndes.SQL;

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El manejador de persistencia general de la aplicación
	 */
	private PersistenciaAlohAndes pp;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor
	 * @param pp - El Manejador de persistencia de la aplicación
	 */
	public SQLOfertaHabitacion (PersistenciaAlohAndes pp)
	{
		this.pp = pp;
	}
	
	public long adicionarOfertaHabitacion(PersistenceManager pm, long id, int costo, String tipo, String tamano, int piso, String categoria, String fechaInicio, String fechaFin, String menaje, int capacidad, String usuario) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaOfertaHabitacion () + " (id, costo, tipo, tamano, piso, categoria, fechaInicio, fechaFin, menaje, capacidad, operador) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        q.setParameters(id, costo, tipo, tamano, piso, categoria, fechaInicio, fechaFin, menaje, capacidad, usuario);
        return (long) q.executeUnique();
	}
	
	public void eliminarOferta(PersistenceManager pm, long id) {
		
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaOfertaHabitacion () + " WHERE id = ?");
        q.setParameters(id);
        q.executeUnique();
	}
	
	public List<OfertaHabitacion> darOfertasHabitacionFiltrada(PersistenceManager pm, int costo, String tipoHabitacion, String categoria){
		
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaOfertaHabitacion() + " WHERE costo < ? AND tipo = ? AND categoria = ?");
		q.setResultClass(OfertaHabitacion.class);
		q.setParameters(costo, tipoHabitacion, categoria);
		
		return (List<OfertaHabitacion>) q.executeList();
	}

	public List<OfertaHabitacion> darOfertaHabitacion(PersistenceManager pm){
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaOfertaHabitacion());
		q.setResultClass(OfertaHabitacion.class);
		return (List<OfertaHabitacion>) q.executeList();
	}
}
