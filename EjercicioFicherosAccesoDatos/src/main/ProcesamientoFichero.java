package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;

/**
 * @author yo
 */
public abstract class ProcesamientoFichero implements IProcesamientoFichero {
    
    public boolean existeFichero(String ruta) 
    {
        File file = new File(ruta);
        return file.exists();
    }
    
    public boolean borrarFichero(String ruta) {
        if(this.existeFichero(ruta))
            return new File(ruta).delete();
        return false;
    }
    
    /**
     * Clase para lectura de cadenas de texto
     * 
     * @param file Ruta del fichero
     * @return Cadena de texto con el contenido o null en caso de error
     */
    public String read(String file) {
        String info = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String tmp;
            while((tmp=reader.readLine()) != null){
               info += tmp+System.lineSeparator();
            }
            reader.close();
        } catch(Exception e) {
            System.out.println("Error while reading: "+e.getMessage());
        }
        return info;
    }
    
    public boolean write(String file, String data) {
        boolean status = false;
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(data);
            writer.close();
            status = true;
        } catch(Exception e) {
            System.out.println("Error while writing: "+e.getMessage());
        }
        return status;
    }
    
}
