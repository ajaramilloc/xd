package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.OfertaViviendaComunidad;

public class SQLOfertaViviendaComunidad {

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
	public SQLOfertaViviendaComunidad (PersistenciaAlohAndes pp)
	{
		this.pp = pp;
	}
	
	public long adicionarOfertaViviendaComunidad(PersistenceManager pm, long id, int costo, int numHabitaciones, String ubicacion, String menaje, int seguroArrendamiento, String operador, int capacidad, String fechaInicio, String fechaFin) 
	{   
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaOfertaViviendaComunidad () + " (id, costo, numHabitaciones, ubicacion, menaje, seguroArrendamiento, operador, capacidad, fechaInicio, fechaFin) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        q.setParameters(id, costo, numHabitaciones, ubicacion, menaje, seguroArrendamiento, operador, capacidad, fechaInicio, fechaFin);
        return (long) q.executeUnique();
	}
	
	public void eliminarOferta(PersistenceManager pm, long id) {
		
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaOfertaViviendaComunidad () + " WHERE id = ?");
        q.setParameters(id);
        q.executeUnique();
	}
	
	public List<OfertaViviendaComunidad> darOfertasViviendaComunidadFiltrada(PersistenceManager pm, int costo, int numHabitaciones){
		
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaOfertaViviendaComunidad() + " WHERE costo < ? AND numHabitaciones = ?");
		q.setResultClass(OfertaViviendaComunidad.class);
		q.setParameters(costo, numHabitaciones);
		return (List<OfertaViviendaComunidad>) q.executeList();
	}

	public List<OfertaViviendaComunidad> darOfertaViviendaComunidad(PersistenceManager pm){
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaOfertaViviendaComunidad());
		q.setResultClass(OfertaViviendaComunidad.class);
		return (List<OfertaViviendaComunidad>) q.executeList();
	}
}
