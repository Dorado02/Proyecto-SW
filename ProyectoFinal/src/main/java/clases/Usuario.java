package clases;

import superClases.EntidadConNombre;

public class Usuario extends EntidadConNombre{
	private String contrase�a;
	private byte nivel;
	private String UbicacionEntrenamiento;
	private Entrenamiento entrenamiento;
	
	public Usuario(String nombre, String contrase�a, byte nivel, String ubicacionEntrenamiento,
			Entrenamiento entrenamiento) {
		super(nombre);
		this.contrase�a = contrase�a;
		this.nivel = nivel;
		UbicacionEntrenamiento = ubicacionEntrenamiento;
		this.entrenamiento = entrenamiento;
	}
	
	public String getContrase�a() {
		return contrase�a;
	}
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
	public byte getNivel() {
		return nivel;
	}
	public void setNivel(byte nivel) {
		this.nivel = nivel;
	}
	public String getUbicacionEntrenamiento() {
		return UbicacionEntrenamiento;
	}
	public void setUbicacionEntrenamiento(String ubicacionEntrenamiento) {
		UbicacionEntrenamiento = ubicacionEntrenamiento;
	}
	public Entrenamiento getEntrenamiento() {
		return entrenamiento;
	}
	public void setEntrenamiento(Entrenamiento entrenamiento) {
		this.entrenamiento = entrenamiento;
	}
	
	
	
	
	
	
}
