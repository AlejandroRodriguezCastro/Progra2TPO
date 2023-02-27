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
		System.out.println("Lista sin alumno: ");
		mostrarLista(alumnosLista);
	}
	
	public static ListaAlumnoTDA copiaLista(ListaAlumnoTDA alumnosLista) {
		ListaAlumnoTDA alumnosListaAux = new ListaAlumno();
		ListaAlumnoTDA alumnosListaAux2 = new ListaAlumno();
		ListaAlumnoTDA alumnosListaAux3 = new ListaAlumno();
		AlumnoTDA alumno = new Alumno();
		alumno.inicializarAlumno();
		alumnosListaAux.inicializarLista();
		alumnosListaAux2.inicializarLista();
		alumnosListaAux3.inicializarLista();
		
		while(!alumnosLista.haySiguiente()) {
			alumno = alumnosLista.siguiente();
			alumnosListaAux.agregarElemento(alumno);
			alumnosLista.eliminarElemento(alumno);
		}
		while(!alumnosListaAux.haySiguiente()) {
			alumno = alumnosListaAux.siguiente();
			alumnosListaAux2.agregarElemento(alumno);
			alumnosListaAux.eliminarElemento(alumno);
		}
		while(!alumnosListaAux2.haySiguiente()) {
			alumno = alumnosListaAux2.siguiente();
			alumnosListaAux3.agregarElemento(alumno);
			alumnosLista.agregarElemento(alumno);
			alumnosListaAux2.eliminarElemento(alumno);
		}
		return alumnosListaAux3;
	}
	
	public static void mostrarLista(ListaAlumnoTDA alumnosLista) {
		ListaAlumnoTDA alumnosListaCopia = new ListaAlumno();
		alumnosListaCopia.inicializarLista();
		alumnosListaCopia = copiaLista(alumnosLista);
		while(!alumnosListaCopia.haySiguiente()) {
			System.out.print("Se saco a ");
			System.out.print(alumnosListaCopia.siguiente().getNombre());
			System.out.print(" de ");
			System.out.print(alumnosListaCopia.siguiente().getEdad());
			System.out.print(" años, con el legajo ");
			System.out.println(alumnosListaCopia.siguiente().getLegajo());
			alumnosListaCopia.eliminarElemento(alumnosListaCopia.siguiente());
	
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
