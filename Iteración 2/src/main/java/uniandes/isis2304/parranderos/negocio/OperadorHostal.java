
package uniandes.isis2304.parranderos.negocio;

public class OperadorHostal implements VOOperadorHostal
{
	
	private int identificacion;
	
	private int registroCamara;
	
	private int registroSuperintendencia;
	
	private String nombre;
	
	private String ubicacion;
	
	private String horaApertura;
	
	private String horaCierre;

	private String usuario;
	

	public OperadorHostal() 
	{
		this.identificacion = 0;
		this.registroCamara = 0;
		this.registroSuperintendencia = 0;
		this.nombre = "";
		this.ubicacion = "";
		this.horaApertura = "";
		this.horaCierre = "";
		this.usuario = "";
	}

	public OperadorHostal(int identificacionPa, int registroCamaraPa, int registroSuperintendenciaPa, String nombrePa, String ubicacionPa, String horaAperturaPa, String horaCierrePa, String usuarioPa)
	{
		this.identificacion = identificacionPa;
		this.registroCamara = registroCamaraPa;
		this.registroSuperintendencia = registroSuperintendenciaPa;
		this.nombre = nombrePa;
		this.ubicacion = ubicacionPa;
		this.horaApertura = horaAperturaPa;
		this.horaCierre = horaCierrePa;
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
	
	public String getHoraApertura() 
	{
		return horaApertura;
	}

	public void setHoraApertura(String horaPa) 
	{
		this.horaApertura = horaPa;
	}
	
	public String getHoraCierre() 
	{
		return horaCierre;
	}

	public void setHoraCierre(String horaPa) 
	{
		this.horaCierre = horaPa;
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
		return "OperadorHostal [identificacion=" + identificacion + ", registroCamara=" + registroCamara + ", registroSuperintendencia=" + registroSuperintendencia + ", nombre=" + nombre + ", ubicacion=" + ubicacion + ", horaApertura=" + horaApertura + ", horaCierre=" + horaCierre + ", usuario=" + usuario + "]";
	}
}
