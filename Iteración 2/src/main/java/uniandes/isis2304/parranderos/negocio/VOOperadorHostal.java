package uniandes.isis2304.parranderos.negocio;

public interface VOOperadorHostal {

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
	
	public String getHoraApertura();

	public void setHoraApertura(String horaPa);
	
	public String getHoraCierre();

	public void setHoraCierre(String horaPa);
	
	public String getUsuario();

	public void setUsuario(String usuario);
	
	
	@Override
	public String toString();
}
