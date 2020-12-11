package main;


import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * @author yo
 */
public class ProcesamientoFicheroXMLJAXB extends ProcesamientoFichero {
    
    /*
    public Object readXMLFile(String file) {
        Object obj = null;
        try {
            // create an instance of `JAXBContext`
            JAXBContext context = JAXBContext.newInstance(Object.class);

            // create an instance of `Unmarshaller`
            Unmarshaller unmarshaller = context.createUnmarshaller();

            // From unmarshaller to file
            obj = unmarshaller.unmarshal(new File(file));
        } catch (JAXBException e) {
            System.out.println("Error reading xml: "+ e);
        }
        return obj;
    }
    */
    
    public boolean writeXMLFile(String file, Object content) {
        try {
            JAXBContext context = JAXBContext.newInstance(Libro[].class);
            // create an instance of `Marshaller`
            Marshaller marshaller = context.createMarshaller();

            // enable pretty-print XML output
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            
            // write XML to File
            marshaller.marshal(content, new File(file));
            
            return true;
        } catch (JAXBException e) {
            System.out.println("Error writing xml: "+ e);
            return false;
        }
    }
    
    
    @Override
    public ArrayList<Libro> leerFichero(String fichero) {
        ArrayList<Libro> libros = new ArrayList<>();        
        try {
            JAXBContext context = JAXBContext.newInstance(Libros.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Libros libs = (Libros)unmarshaller.unmarshal(new File(fichero));
            libros = libs.getLista();
        } catch (JAXBException e) {
            System.out.println("Error reading xml: "+ e);
        }
        return libros;
    }

    @Override
    public boolean escribirFichero(ArrayList<Libro> libros, String fichero) {
        try {
            Libros libs = new Libros();
            libs.setLista(libros);
            JAXBContext context = JAXBContext.newInstance(Libros.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(libs, new File(fichero));
            return true;
        } catch (JAXBException e) {
            System.out.println("Error writing xml: "+ e);
            return false;
        }
    }
    
}
