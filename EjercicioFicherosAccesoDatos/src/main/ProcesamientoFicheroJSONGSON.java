package main;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * @author yo
 */
public class ProcesamientoFicheroJSONGSON extends ProcesamientoFichero {
    
    /*
    public Object readJSONFile(String file) {
        Clase obj = null;
        GsonBuilder builder = new GsonBuilder(); 
        Gson gson = builder.create();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            obj = gson.fromJson(bufferedReader, Clase.class);
        } catch (FileNotFoundException ex) {
            System.out.println("Error leer json: "+ex);
        }
        return obj;
    }
    */
    
    public boolean writeJSONFile(String file, Object content) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String jsonString = gson.toJson(content);
        return this.write(file, jsonString);
    }
    
    
    @Override
    public ArrayList<Libro> leerFichero(String fichero) {
        ArrayList<Libro> libros = new ArrayList<>();
        Libro[] obj = null;
        GsonBuilder builder = new GsonBuilder(); 
        Gson gson = builder.create();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fichero));
            obj = gson.fromJson(bufferedReader, Libro[].class);
            Collections.addAll(libros, obj);
        } catch (FileNotFoundException ex) {
            System.out.println("Error leer json: "+ex);
        }
        return libros;
    }

    @Override
    public boolean escribirFichero(ArrayList<Libro> libros, String fichero) {
        return this.writeJSONFile(fichero, libros.toArray());
    }
    
}
