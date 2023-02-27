package impl;

import api.AlumnoTDA;

public class Alumno implements AlumnoTDA {
	private int edad;
	private String nombre;
	private int legajo;
	
	@Override
	public void inicializarAlumno() {
		edad = 0;
		nombre = "";
		legajo = 0;
		
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public int getLegajo() {
		return legajo;
	}

	@Override
	public int getEdad() {
		return edad;
	}

	@Override
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}

	@Override
	public void setEdad(int edad) {
		this.edad = edad;
	}

}

