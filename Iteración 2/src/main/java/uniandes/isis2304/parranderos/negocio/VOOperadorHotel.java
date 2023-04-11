package uniandes.isis2304.parranderos.negocio;

public interface VOOperadorHotel {

	public int getIdentificacion();

	public void setIdentificacion(int identificacionPa);
	
	public int getRegistroCamara();

	public void setRegistroCamara(int registroPa);
	
	public int getRegistroSuperintendencia();

	public void setRegistroSuperintendencia(int registroPa);
	
	public String getNombre();

	public void setNombre(String nombrePa);
	
	public String getUbicacion();

	public void setUbicacion(String ubicacionPa);
	
	public String getUsuario();

	public void setUsuario(String usuario);
	
	
	@Override
	public String toString();
}
