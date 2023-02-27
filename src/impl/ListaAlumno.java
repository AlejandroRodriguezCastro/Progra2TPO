package impl;

import api.AlumnoTDA;
import api.ListaAlumnoTDA;

public class ListaAlumno implements ListaAlumnoTDA {
	class NodoAlumno {
		AlumnoTDA info;
		NodoAlumno sig;
	}
	private NodoAlumno primero;
	private NodoAlumno ultimo;
	private int cantidad;
	
	@Override
	public void inicializarLista() {
		primero = null;
		ultimo = null;
		cantidad = 0;
	}

	@Override
	public void agregarElemento(AlumnoTDA elemento) {
		NodoAlumno nuevo = new NodoAlumno();
		if (Legajo2Nodo(elemento.getLegajo()) == null) {
			nuevo.info = elemento;
			nuevo.sig = null;
			if(ultimo != null) {
				ultimo.sig = nuevo;
			}
			ultimo = nuevo;
			
			if (primero == null) {
				primero = ultimo;
			}			
			cantidad++;
		}
	}

	@Override
	public void ordenarLista() {
		boolean cambiado;
        for (int i = 0; i < cantidad - 1; i++) {
        	cambiado = false;
        	NodoAlumno anterior = null;
        	NodoAlumno actual = primero;
        	for (int j = 0; j < cantidad-i - 1; j++) {
                if (actual.info.getNombre().compareToIgnoreCase(actual.sig.info.getNombre()) > 0) {
                	NodoAlumno temporal = actual.sig;
                    actual.sig = actual.sig.sig;
                    temporal.sig = actual;
                    if (anterior == null) {
                        primero = temporal;
                    } else {
                        anterior.sig = temporal;
                    }
                    anterior = temporal;
                    cambiado = true;
                } else {
                	anterior = actual;
                	actual = actual.sig;
                }
            }
            if (cambiado == false) {
                break;
            }
        }
	}

	@Override
	public boolean haySiguiente() {
		return (primero == null);
	}

	@Override
	public AlumnoTDA siguiente() {
		return primero.info;
	}

	@Override
	public void eliminarElemento(AlumnoTDA elemento) {
		if (Legajo2Nodo(elemento.getLegajo()) != null) {
			if (primero.info.getLegajo() == elemento.getLegajo()) {
				primero = primero.sig;
			} else {
				NodoAlumno viajero = primero;
				while(viajero.sig != null && viajero.sig.info.getLegajo() != elemento.getLegajo())
					viajero = viajero.sig;
				if(viajero.sig != null)
					viajero.sig = viajero.sig.sig;
			}			
			cantidad--;
		}

	}
	
	private NodoAlumno Legajo2Nodo(int legajo) {
		NodoAlumno viajero = primero;
		while(viajero != null && viajero.info.getLegajo() != legajo)
			viajero = viajero.sig;
		return viajero;
	}
}

