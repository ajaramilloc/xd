package uniandes.isis2304.parranderos.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLUsuarioOperador {

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
	public SQLUsuarioOperador (PersistenciaAlohAndes pp)
	{
		this.pp = pp;
	}
	
	public long adicionarUsuarioOperador(PersistenceManager pm, String usuario, String contrasena) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaUsuarioOperador () + " (usuario, contrasena) values (?, ?)");
        q.setParameters(usuario, contrasena);
        return (long) q.executeUnique();
	}
	
	public boolean verificarIdentidad(PersistenceManager pm, String usuarioVerificacion, String contrasena) {
		
		Query q = pm.newQuery(SQL, "SELECT usuario FROM " + pp.darTablaUsuarioOperador () + " WHERE usuario = ?");
		q.setParameters(usuarioVerificacion);
        
        String usuarioRecuperado = (String) q.executeUnique();
        
        if (usuarioRecuperado == null) {
        	return false;
        }
        
        Query p = pm.newQuery(SQL, "SELECT contrasena FROM " + pp.darTablaUsuarioOperador () + " WHERE usuario = ? AND contrasena = ?");
        p.setParameters(usuarioVerificacion, contrasena);
        
        String contrasenaRecuperada = (String) p.executeUnique();
        
        if(contrasenaRecuperada != null) {
        	return true;
        }
        return false;
	}
}
