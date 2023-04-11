package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.OfertaApartamento;

public class SQLOfertaApartamento {

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
	public SQLOfertaApartamento (PersistenciaAlohAndes pp)
	{
		this.pp = pp;
	}
	
	public long adicionarOfertaApartamento(PersistenceManager pm, long id, int costo, String serviciosIncluidos, String tv, String internet, String administracion, int capacidad,
			int numeroApartamento, String conjuntoApartamento, String direccionApartamento, String fechaInicio, String fechaFin, String operador) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaOfertaApartamento () + " (id, costo, serviciosIncluidos, tv, internet, administracion, capacidad, numeroApartamento, conjuntoApartamento, direccionApartamento, operador, fechaInicio, fechaFin) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        q.setParameters(id, costo, serviciosIncluidos, tv, internet, administracion, capacidad, numeroApartamento, conjuntoApartamento, direccionApartamento, operador, fechaInicio, fechaFin);
        return (long) q.executeUnique();
	}
	
	public void eliminarOferta(PersistenceManager pm, long id) {
		
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaOfertaApartamento() + " WHERE id = ?");
        q.setParameters(id);
        q.executeUnique();
	}
	
	public List<OfertaApartamento> darOfertasApartamentoFiltrada(PersistenceManager pm, String servicios, String tv, String internet, String administracion){
		
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaOfertaApartamento() + " WHERE serviciosIncluidos = ? AND tv = ? AND internet = ? AND administracion = ?");
		q.setResultClass(OfertaApartamento.class);
		q.setParameters(servicios, tv, internet, administracion);
		return (List<OfertaApartamento>) q.executeList();
	}

	public List<OfertaApartamento> darOfertaApartamento(PersistenceManager pm){
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaOfertaApartamento());
		q.setResultClass(OfertaApartamento.class);
		return (List<OfertaApartamento>) q.executeList();
	}
}
