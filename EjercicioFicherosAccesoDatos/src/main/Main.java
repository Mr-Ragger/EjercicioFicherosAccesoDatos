package main;

import java.util.ArrayList;

/**
 * @author yo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String fichero1 = "biblio.txt";
        String fichero2 = "biblio_ejemplo.txt";

        // Probar Escritura de archivo

        // Generamos libros de ejemplo
        System.out.println("Creando libro de ejemplo.");
        ArrayList<Libro> libros = new ArrayList<>();

        Libro l1 = new Libro(" La huida", "Edebe", "Rosa Melpito", "01/01/2005", "Novela Cubana");
        Libro l2 = new Libro("Mil y una noches", "Edebe", "Mercedes Fuentes", "02/01/2005", "Ficcion");

        l1.addPersonaje(new Personaje("Benito Camela", "algo", 0));
        l1.addPersonaje(new Personaje("Tomas Turbado", "algo", 1));

        l2.addPersonaje(new Personaje("Johny Melavo", "algo", 2));
        l2.addPersonaje(new Personaje("Armando Paredes", "algo", 0));

        libros.add(l1);
        libros.add(l2);

        ProcesamientoFichero procesado1 = new  ProcesamientoFicheroPlano();

        // Escribimos libros
        System.out.println("Escribiendo libro en el fichero: "+fichero1);
        boolean resultadoEscribir = procesado1.escribirFichero(libros, fichero1);
        System.out.println("Resultado de escritura: " + resultadoEscribir);

        System.out.println("Leyendo libros del fichero: " + fichero2);
        ArrayList<Libro> librosLeidos = procesado1.leerFichero(fichero2);        
        
        System.out.println("Libros leidos: ");
        for (Libro libro : librosLeidos) {
            System.out.println(libro);
        }

        System.out.println(" -- -- Libros Objetos -- -- ");
        ProcesamientoFichero procesado2 = new ProcesamientoFicheroObjetos();
        System.out.println("Escribir fichero objetos: "+procesado2.escribirFichero(libros, "libros.obj"));
        
        ArrayList<Libro> librosLeidos2 = procesado2.leerFichero("libros.obj");        
        
        System.out.println("Libros leidos: ");
        for (Libro libro : librosLeidos2) {
            System.out.println(libro);
        }
        
        System.out.println(" -- -- Libros XML -- -- ");
        ProcesamientoFichero procesado3 = new ProcesamientoFicheroXMLJAXB();
        System.out.println("Escribir fichero objetos: "+procesado3.escribirFichero(libros, "libros.xml"));
        
        ArrayList<Libro> librosLeidos3 = procesado3.leerFichero("libros.xml");        
        
        System.out.println("Libros leidos: ");
        for (Libro libro : librosLeidos3) {
            System.out.println(libro);
        }
        
        System.out.println(" -- -- Libros JSON -- -- ");
        ProcesamientoFichero procesado4 = new ProcesamientoFicheroJSONGSON();
        System.out.println("Escribir fichero objetos: "+procesado4.escribirFichero(libros, "libros.json"));
        
        ArrayList<Libro> librosLeidos4 = procesado4.leerFichero("libros.json");        
        
        System.out.println("Libros leidos: ");
        for (Libro libro : librosLeidos4) {
            System.out.println(libro);
        }

    }
    
}
