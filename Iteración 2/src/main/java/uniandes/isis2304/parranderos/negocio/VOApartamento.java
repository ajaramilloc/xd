package uniandes.isis2304.parranderos.negocio;

public interface VOApartamento {

	public int getNumero();

	public void setNumero(int numero);
	
	public String getConjunto();

	public void setConjunto(String conjunto);
	
	public String getDireccion();

	public void setDireccion(String direccion);
	
	public String getAmoblado();

	public void setAmoblado(String amoblado);
	
	public String getDueno();

	public void setDueno(String dueno);
	
	@Override
	public String toString();
}
