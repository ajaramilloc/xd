package uniandes.isis2304.parranderos.negocio;

public interface VOOfertaViviendaComunidad {


	public long getId();

	public void setId(long id);
	
	public int getCosto();
	
	public int getNumHabitaciones();
	
	public String getUbicacion();
	
	public String getMenaje();
	
	public int getSeguroArrendamiento();
	
	public String getOperador();

	public String getFechaInicio();
	
	public String getFechaFin();
	
	public int getCapacidad();
	
	
	@Override
	public String toString();
}
