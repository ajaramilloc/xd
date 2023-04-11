package uniandes.isis2304.parranderos.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLApartamento {

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
	public SQLApartamento (PersistenciaAlohAndes pp)
	{
		this.pp = pp;
	}
	
	public long adicionarApartamento(PersistenceManager pm, int numero, String conjunto, String direccion, String amoblado, String dueno) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaApartamento () + " (numero, conjunto, direccion, amoblado, dueno) values (?, ?, ?, ?, ?)");
        q.setParameters(numero, conjunto, direccion, amoblado, dueno);
        return (long) q.executeUnique();
	}
}
