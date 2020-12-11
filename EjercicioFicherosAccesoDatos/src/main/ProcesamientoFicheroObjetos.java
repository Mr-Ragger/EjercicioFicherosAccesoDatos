package main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * @author yo
 */
public class ProcesamientoFicheroObjetos extends ProcesamientoFichero {
    
    public Object readBinaryFile(String file) {
        Object obj = null;
        try {
            ObjectInputStream reader = new ObjectInputStream(new FileInputStream(file));
            obj = reader.readObject();
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading binary: "+ e);
        } catch (ClassNotFoundException e) {
            System.out.println("Error class not found in file: "+ e);
        }
        return obj;
    }
    
    public boolean writeBinaryFile(String file, Object content) {
        try {
            ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(file));
            writer.writeObject(content);
            writer.close();
            return true;
        } catch (IOException e) {
            System.out.println("Error writing binary: "+ e);
            return false;
        }
    }
    
    
    @Override
    public ArrayList<Libro> leerFichero(String fichero) {
        ArrayList<Libro> libros = new ArrayList<>();
        try {
            ObjectInputStream reader = new ObjectInputStream(new FileInputStream(fichero));
            libros = (ArrayList<Libro>)reader.readObject();
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading binary: "+ e);
        } catch (ClassNotFoundException e) {
            System.out.println("Error class not found in file: "+ e);
        }
        return libros;
    }

    @Override
    public boolean escribirFichero(ArrayList<Libro> libros, String fichero) {
        return this.writeBinaryFile(fichero, libros);
    }
    
}
