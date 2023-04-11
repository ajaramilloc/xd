package uniandes.isis2304.parranderos.negocio;

public interface VOOfertaApartamento {


	public long getId();

	public void setId(long id);
	
	public int getCosto();
	
	public void setCosto(int costo);
	
	
	public String getServiciosIncluidos();
	
	public void setServiciosIncluidos(String servicios);
	
	
	public String getTv();
	
	public void setTv(String tv);
	
	
	public String getInternet();
	
	public void setInternet(String internet);
	
	
	public String getAdministracion();
	
	public void setAdministracion(String administracion);
	
	
	public int getCapacidad();
	
	
	public void setCapacidad(int capacidad);
	
	
	public int getNumeroApartamento();
	
	
	public void setNumeroApartamento(int numero);
	
	
	public String getConjuntoApartamento();
	
	public void setConjuntoApartamento(String conjunto);
	
	
	public String getDireccionApartamento();
	
	public void setDireccionApartamento(String direccion);
	
	
	public String getOperador();
	
	
	public void setOperador(String operador);
	
	
	public String getFechaInicio();
	
	
	public void setFechaInicio(String fechaInicio);
	
	
	public String getFechaFin();
	
	
	public void setFechaFin(String fechaFin);
	
	
	@Override
	public String toString();
}
