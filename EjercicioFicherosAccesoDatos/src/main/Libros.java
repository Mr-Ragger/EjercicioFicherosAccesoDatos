package main;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="lista")
public class Libros {	
	private ArrayList<Libro> lista;

	public void setLista(ArrayList<Libro> lista) {
		this.lista = lista;
	}
	
	@XmlElement(name="libro")
	public ArrayList<Libro> getLista() {
		return this.lista;
	}
}

