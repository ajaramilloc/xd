package uniandes.isis2304.parranderos.negocio;

public interface VOReserva {

	public long getId();

	public void setId(long id);

	public String getCliente();
	
	public long getOfertaAsociada();
	
	public int getDuracion();
	
	public String getFechaRegistro();
	
	public int getOcupacion();
	
	public String getFechaInicio();
	
	
	@Override
	public String toString();
}
