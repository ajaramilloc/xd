package uniandes.isis2304.parranderos.negocio;

public interface VOOfertasAlojamiento {

	public long getId();

	public void setId(long id);

	public String getTipoOferta();

	public void setTipoOferta(String tipoOferta);
	
	public String getOperador();

	public void setOperador(String operador);

	@Override
	public String toString();
}
