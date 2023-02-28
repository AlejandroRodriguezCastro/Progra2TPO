package api;

public interface ListaAlumnoTDA {
	public void inicializarLista();
	public void agregarElemento(AlumnoTDA elemento);
	public void ordenarLista();
	public boolean haySiguiente();
	public AlumnoTDA siguiente();
	public void eliminarElemento(AlumnoTDA elemento);
	public void reiniciarSiguiente();
}
