package clases;

import java.time.LocalDate;
import java.util.ArrayList;

public class Rutina {
	private ArrayList<Ejercicio> ejercicios;
	private byte descansoSg;
	private LocalDate fecha;
	
	
	public Rutina(ArrayList<Ejercicio> ejercicios, byte descansoSg, LocalDate fecha) {
		super();
		this.ejercicios = ejercicios;
		this.descansoSg = descansoSg;
		this.fecha = fecha;
	}
	
	public ArrayList<Ejercicio> getEjercicios() {
		return ejercicios;
	}
	public void setEjercicios(ArrayList<Ejercicio> ejercicios) {
		this.ejercicios = ejercicios;
	}
	public byte getDescansoSg() {
		return descansoSg;
	}
	public void setDescansoSg(byte descansoSg) {
		this.descansoSg = descansoSg;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
}
