
package uniandes.isis2304.parranderos.negocio;

public class UsuarioPersona implements VOUsuarioPersona
{
	private String usuario;
	
	private String contrasena;
	
	private int carnetUniandes;
	
	private String vinculacion;
	
	private String esOperador;
	

	public UsuarioPersona() 
	{
		this.usuario = "";
		this.contrasena = "";
		this.carnetUniandes = 0;
		this.vinculacion = "";
		this.esOperador = "";
	}

	public UsuarioPersona(String usuarioPa, String contrasenaPa, int carnetUniandesPa, String vinculacionPa, String esOperadorPa){
		this.usuario = usuarioPa;
		this.contrasena = contrasenaPa;
		this.carnetUniandes = carnetUniandesPa;
		this.vinculacion = vinculacionPa;
		this.esOperador = esOperadorPa;
	}


	public String getUsuario() 
	{
		return usuario;
	}

	public void setUsuario(String usuario) 
	{
		this.usuario = usuario;
	}


	public String getContrasena() 
	{
		return contrasena;
	}

	public void setContrasena(String contrasena) 
	{
		this.contrasena = contrasena;
	}
	
	public int getCarnetUniandes() {
		return this.carnetUniandes;
	}
	
	public void setCarnetUniandes(int carnet) {
		this.carnetUniandes = carnet;
	}
	
	public String getVinculacion() {
		return this.vinculacion;
	}
	
	public void setVinculacion(String vinculacionPa) {
		this.vinculacion = vinculacionPa;
	}
	
	public String getEsOperador() {
		return this.esOperador;
	}
	
	public void setEsOperador(String esOperadorPa) {
		this.esOperador = esOperadorPa;
	}
	

	@Override
	public String toString() 
	{
		return "UsuarioPersona [usuario=" + usuario + ", contrasena=" + contrasena + ", carnetUniandes=" + carnetUniandes + ", vinculacion=" + vinculacion + ", esOperador=" + esOperador + "]";
	}
}
