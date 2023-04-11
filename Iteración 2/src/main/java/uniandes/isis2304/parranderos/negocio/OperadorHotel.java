
package uniandes.isis2304.parranderos.negocio;

public class OperadorHotel implements VOOperadorHotel
{
	
	private int identificacion;
	
	private int registroCamara;
	
	private int registroSuperintendencia;
	
	private String nombre;
	
	private String ubicacion;

	private String usuario;
	

	public OperadorHotel() 
	{
		this.identificacion = 0;
		this.registroCamara = 0;
		this.registroSuperintendencia = 0;
		this.nombre = "";
		this.ubicacion = "";
		this.usuario = "";
	}

	public OperadorHotel(int identificacionPa, int registroCamaraPa, int registroSuperintendenciaPa, String nombrePa, String ubicacionPa, String usuarioPa)
	{
		this.identificacion = identificacionPa;
		this.registroCamara = registroCamaraPa;
		this.registroSuperintendencia = registroSuperintendenciaPa;
		this.nombre = nombrePa;
		this.ubicacion = ubicacionPa;
		this.usuario = usuarioPa;
	}


	public int getIdentificacion() 
	{
		return identificacion;
	}

	public void setIdentificacion(int identificacionPa) 
	{
		this.identificacion = identificacionPa;
	}
	
	public int getRegistroCamara() 
	{
		return registroCamara;
	}

	public void setRegistroCamara(int registroPa) 
	{
		this.registroCamara = registroPa;
	}
	
	public int getRegistroSuperintendencia() 
	{
		return registroSuperintendencia;
	}

	public void setRegistroSuperintendencia(int registroPa) 
	{
		this.registroSuperintendencia = registroPa;
	}
	
	public String getNombre() 
	{
		return nombre;
	}

	public void setNombre(String nombrePa) 
	{
		this.nombre = nombrePa;
	}
	
	public String getUbicacion() 
	{
		return ubicacion;
	}

	public void setUbicacion(String ubicacionPa) 
	{
		this.ubicacion = ubicacionPa;
	}
	
	public String getUsuario() 
	{
		return usuario;
	}

	public void setUsuario(String usuario) 
	{
		this.usuario = usuario;
	}
	

	@Override
	public String toString() 
	{
		return "OperadorHotel [identificacion=" + identificacion + ", registroCamara=" + registroCamara + ", registroSuperintendencia=" + registroSuperintendencia + ", nombre=" + nombre + ", ubicacion=" + ubicacion + ", usuario=" + usuario + "]";
	}
}
