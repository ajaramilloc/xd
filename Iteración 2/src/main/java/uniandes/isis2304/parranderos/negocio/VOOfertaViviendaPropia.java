package uniandes.isis2304.parranderos.negocio;

public interface VOOfertaViviendaPropia {


	public long getId();

	public void setId(long id);
	
	public int getCosto();
	
	public String getComidas();
	
	public String getAccesoCocina();
	
	public String getBanoPrivado();
	
	public String getHabIndividual();
	
	public int getCostoServicios();

	public String getEsquema();
	
	public String getOperador();

	public String getFechaInicio();
	
	public String getFechaFin();
	
	public int getCapacidad();
	
	
	@Override
	public String toString();
}
