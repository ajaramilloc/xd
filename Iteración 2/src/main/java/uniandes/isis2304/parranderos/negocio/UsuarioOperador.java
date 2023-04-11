
package uniandes.isis2304.parranderos.negocio;

public class UsuarioOperador implements VOUsuarioOperador
{
	private String usuario;
	
	private String contrasena;
	

	public UsuarioOperador() 
	{
		this.usuario = "";
		this.contrasena = "";
	}

	public UsuarioOperador(String usuarioPa, String contrasenaPa){
		this.usuario = usuarioPa;
		this.contrasena = contrasenaPa;
	}


	public String getUsuario() 
	{
		return usuario;
	}

	public void setUsuario(String usuario) 
	{
		this.usuario = usuario;
	}


	public String getContrasena() 
	{
		return contrasena;
	}

	public void setContrasena(String contrasena) 
	{
		this.contrasena = contrasena;
	}
	
	

	@Override
	public String toString() 
	{
		return "UsuarioOperador [usuario=" + usuario + ", contrasena=" + contrasena + "]";
	}
}
