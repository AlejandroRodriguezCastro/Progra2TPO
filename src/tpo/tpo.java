package tpo;

import api.AlumnoTDA;
import api.ListaAlumnoTDA;
import impl.Alumno;
import impl.ListaAlumno;

public class tpo {

	public static void main(String[] args) {
		ListaAlumnoTDA alumnosLista = new ListaAlumno();
		
		AlumnoTDA alumno = new Alumno();
		alumnosLista.inicializarLista();
		alumno.inicializarAlumno();
		cargarAlumnos(alumnosLista);
		System.out.println("Lista original: ");
		mostrarLista(alumnosLista);
		alumnosLista.ordenarLista();
		System.out.println("Lista ordenada: ");
		mostrarLista(alumnosLista);
		alumno.setEdad(32);
		alumno.setLegajo(222000);
		alumno.setNombre("Agustín González");
		alumnosLista.eliminarElemento(alumno);
		System.out.println("Lista sin alumno (Agustín González): ");
		mostrarLista(alumnosLista);
	}
	
	public static void mostrarLista(ListaAlumnoTDA alumnosLista) {
		AlumnoTDA alumno = new Alumno();
		alumno.inicializarAlumno();
		alumnosLista.reiniciarSiguiente();
		while(alumnosLista.haySiguiente()) {
			alumno = alumnosLista.siguiente();
			System.out.print("Se muestra a ");
			System.out.print(alumno.getNombre());
			System.out.print(" de ");
			System.out.print(alumno.getEdad());
			System.out.print(" años, con el legajo ");
			System.out.println(alumno.getLegajo());	
		}
	}
	
	public static void cargarAlumnos(ListaAlumnoTDA alumnosLista) {
		alumnosLista.agregarElemento(crearAlumno(22,111000,"Valeria Fernández"));
		alumnosLista.agregarElemento(crearAlumno(32,222000,"Agustín González"));
		alumnosLista.agregarElemento(crearAlumno(24,333000,"Marina Torres"));
		alumnosLista.agregarElemento(crearAlumno(20,444000,"Tomás Sánchez"));
		alumnosLista.agregarElemento(crearAlumno(27,555000,"Luciana Díaz"));
		alumnosLista.agregarElemento(crearAlumno(29,666000,"Ignacio Pérez"));
		alumnosLista.agregarElemento(crearAlumno(19,777000,"Carolina Castro"));
		alumnosLista.agregarElemento(crearAlumno(25,888000,"Julián Romero"));
		alumnosLista.agregarElemento(crearAlumno(28,999000,"Paula Ríos"));
		alumnosLista.agregarElemento(crearAlumno(21,101010,"Matías Gómez"));
		
	}
	
	public static AlumnoTDA crearAlumno(int edad, int legajo, String nombre) {
		AlumnoTDA alumno = new Alumno();
		alumno.inicializarAlumno();
		alumno.setEdad(edad);
		alumno.setLegajo(legajo);
		alumno.setNombre(nombre);
		return alumno;
		
	}
}
