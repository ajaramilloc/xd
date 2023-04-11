package uniandes.isis2304.parranderos.negocio;

public interface VOOfertaHabitacion {

	public long getId();

	public void setId(long id);
	
	
	public int getCosto();
	
	
	public String getTipo();
	
	
	public String getTamano();
	
	
	public void setTamano(String tamano);
	
	
	public int getPiso();
	
	
	public String getCategoria();
	
	
	public String getFechaInicio();
	
	
	public String getFechaFin();
	
	
	public String getMenaje();
	
	
	public int getCapacidad();
	
	
	public String getOperador();
	
	
	@Override
	public String toString();
}
