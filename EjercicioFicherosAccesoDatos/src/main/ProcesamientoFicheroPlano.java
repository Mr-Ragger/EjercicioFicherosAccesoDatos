package main;


import java.util.ArrayList;

/**
 * @author yo
 */
public class ProcesamientoFicheroPlano extends ProcesamientoFichero {

    @Override
    public ArrayList<Libro> leerFichero(String fichero) {
        ArrayList<Libro> libros = new ArrayList<>();
        String separador1 = ";", separador2 = "-";
        
        String texto = this.read(fichero);
        if (texto != null && texto.length() > 0) {
            // Unal linea:
            /*
            Los pilares de la Tierra;Macmillan Publishers;Kent Follet;1/05/1989;Novela Histórica;Jack
            Jackson,PRINCIPAL-Philip,PRINCIPAL-Aliena,PRINCIPAL-Jack Shareburg,SECUNDARIO
            */
            String[] lineas = texto.split(System.lineSeparator());
            for(int i=0; i<lineas.length && lineas[i].compareTo("") != 0; i++) {
                String[] atributos = lineas[i].split(separador1);
                // Atributos
                /* Contenido                                                                          Indice
                Los pilares de la Tierra                                                              - 0
                Macmillan Publishers                                                                  - 1
                Kent Follet                                                                           - 2 
                1/05/1989                                                                             - 3
                Novela Histórica                                                                     - 4
                Jack Jackson,PRINCIPAL-Philip,PRINCIPAL-Aliena,PRINCIPAL-Jack Shareburg,SECUNDARIO    - 5
                */
                Libro lib = new Libro(
                    atributos[0], // Titulo
                    atributos[1], // Editorial
                    atributos[2], // Autor
                    atributos[3], // FechaPubli
                    atributos[4] // Genero
                );
                // Personajes
                /*
                    Jack Jackson,PRINCIPAL
                    Philip,PRINCIPAL
                    Aliena,PRINCIPAL
                    Jack Shareburg,SECUNDARIO
                */
                String[] personajes = atributos[5].split(separador2);
                for (int j = 0; j<personajes.length; j++) {
                    String pers[] = personajes[j].split(",");
                    Personaje p = new Personaje(pers[0], "", pers[1]);
                    lib.addPersonaje(p);
                }
                libros.add(lib);
            }
        }
        return libros;
    }

    @Override
    public boolean escribirFichero(ArrayList<Libro> libros, String fichero) {
        boolean result = false;
        
        // Pasamos los libros a texto 
        String texto = "";
        for(Libro l:libros)
            texto += l.toString() + System.lineSeparator();
        
        // Escribimos en el archivo
        result = this.write(fichero, texto);

        return result;
    }
    
}
