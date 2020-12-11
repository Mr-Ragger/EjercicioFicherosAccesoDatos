package main;

import java.util.ArrayList;

public interface IProcesamientoFichero {
    
    public ArrayList<Libro> leerFichero(String fichero);
    
    public boolean escribirFichero(ArrayList<Libro> libros, String fichero);
    
}
