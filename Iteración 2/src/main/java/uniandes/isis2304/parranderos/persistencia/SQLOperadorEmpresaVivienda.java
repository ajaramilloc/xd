package uniandes.isis2304.parranderos.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLOperadorEmpresaVivienda {

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
	public SQLOperadorEmpresaVivienda (PersistenciaAlohAndes pp)
	{
		this.pp = pp;
	}
	
	public long adicionarOperadorEmpresaVivienda(PersistenceManager pm, long identificacion, int registroCamara, int registroSuperintendencia, String nombre, int nit, String usuario) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaOperadorEmpresaVivienda () + " (identificacion, registroCamara, registroSuperintendencia, nombre, nit, usuario) values (?, ?, ?, ?, ?, ?)");
        q.setParameters(identificacion, registroCamara, registroSuperintendencia, nombre, nit, usuario);
        return (long) q.executeUnique();
	}
	
	public String verificarUsuario(PersistenceManager pm, String usuarioPa) 
	{
        Query q = pm.newQuery(SQL, "SELECT usuario FROM " + pp.darTablaOperadorEmpresaVivienda () + " WHERE usuario = ?");
        q.setParameters(usuarioPa);
        return (String) q.executeUnique();
	}
}
