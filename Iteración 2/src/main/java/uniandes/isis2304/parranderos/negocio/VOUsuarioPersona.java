package uniandes.isis2304.parranderos.negocio;

public interface VOUsuarioPersona {


	public String getUsuario();

	public void setUsuario(String usuario);

	public String getContrasena();

	public void setContrasena(String contrasena);
	
	public int getCarnetUniandes();
	
	public void setCarnetUniandes(int carnet);
	
	public String getVinculacion();
	
	public void setVinculacion(String vinculacionPa);
	
	public String getEsOperador();
	
	public void setEsOperador(String esOperadorPa);
	
	@Override
	public String toString();
}
