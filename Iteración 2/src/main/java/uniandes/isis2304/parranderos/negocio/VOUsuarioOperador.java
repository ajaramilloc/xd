package uniandes.isis2304.parranderos.negocio;

public interface VOUsuarioOperador {


	public String getUsuario();

	public void setUsuario(String usuario);

	public String getContrasena();

	public void setContrasena(String contrasena);
	
	@Override
	public String toString();
}
