package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.OfertaViviendaPropia;

public class SQLOfertaViviendaPropia {

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
	public SQLOfertaViviendaPropia (PersistenciaAlohAndes pp)
	{
		this.pp = pp;
	}
	
	public long adicionarOfertaViviendaPropia(PersistenceManager pm, long id, int costo, String comidas, String accesoCocina, String banoPrivado, String habIndividual, int costoServicios,
			String esquema, String fechaInicio, String fechaFin, int capacidad, String operador) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaOfertaViviendaPropia () + " (id, costo, comidas, accesoCocina, banoPrivado, habIndividual, costoServicios, esquema, operador, capacidad, fechaInicio, fechaFin) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        q.setParameters(id, costo, comidas, accesoCocina, banoPrivado, habIndividual, costoServicios, esquema, operador, capacidad, fechaInicio, fechaFin);
        return (long) q.executeUnique();
	}
	
	public void eliminarOferta(PersistenceManager pm, long id) {
		
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaOfertaViviendaPropia () + " WHERE id = ?");
        q.setParameters(id);
        q.executeUnique();
	}
	
	public List<OfertaViviendaPropia> darOfertasViviendaPropiaFiltrada(PersistenceManager pm, String comidas, String accesoCocina, String banoPrivado, String habIndividual){
		
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaOfertaViviendaPropia() + " WHERE comidas = ? AND accesoCocina = ? AND banoPrivado = ? AND habIndividual = ?");
		q.setResultClass(OfertaViviendaPropia.class);
		q.setParameters(comidas, accesoCocina, banoPrivado, habIndividual);
		return (List<OfertaViviendaPropia>) q.executeList();
	}

	public List<OfertaViviendaPropia> darOfertaViviendaPropia(PersistenceManager pm){
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaOfertaViviendaPropia());
		q.setResultClass(OfertaViviendaPropia.class);
		return (List<OfertaViviendaPropia>) q.executeList();
	}
}
