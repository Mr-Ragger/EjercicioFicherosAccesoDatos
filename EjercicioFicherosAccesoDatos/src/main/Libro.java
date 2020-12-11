package main;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author yo
 */
@XmlRootElement(name = "libro")
class Libro implements Serializable{
    
    public static DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    private String titulo;
    private String editorial;
    private String autor;
    private LocalDate fechaPubli;
    private String genero;
    private ArrayList<Personaje> personajes;
    
    public Libro() {
        personajes = new ArrayList<>();
    }
    
    public Libro(String titulo, String editorial, String autor, 
            String fechaPubli, String genero) {
        personajes = new ArrayList<>();
        this.titulo = titulo;
        this.editorial = editorial;
        this.autor = autor;
        this.setFechaPubli(fechaPubli);
        this.genero = genero;
    }
    
    public Personaje getPersonaje(int index) {
        return personajes.get(index);
    }
    
    @XmlElement(name = "personajes")
    public void setPersonajes(Personaje[] lista) {
        personajes.clear();
        for (int i = 0; i < lista.length; i++) {
            personajes.add(lista[i]);
        }
    }
    
    public void addPersonaje(Personaje p) {
        personajes.add(p);
    }
    
    @XmlElement(name = "fechaPubli")
    public void setFechaPubli(String fecha) {
        fechaPubli = LocalDate.parse(fecha, DATE_FORMAT);
    }
    
    public String getFechaPubli() {
        if (fechaPubli != null)
            return fechaPubli.format(DATE_FORMAT);
        return null;
    }
    
    // -- Get y Sets -- 
    public String getTitulo() {
        return titulo;
    }

    @XmlElement(name = "titulo")
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }
    
    @XmlElement(name = "editorial")
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getAutor() {
        return autor;
    }

    @XmlElement(name = "autor")
    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    @XmlElement(name = "genero")
    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    public ArrayList<Personaje> getPersonajes() {
        return personajes;
    }
    
    public String toString() {
        String cad = "";
        cad += titulo + ";";
        cad += editorial + ";";
        cad += autor + ";";
        cad += this.getFechaPubli() + ";";
        cad += genero + ";";
        
        for(Personaje p: personajes) {
            cad += p + ",";
        }
        
        // Remove last comma
        if(personajes.size() > 0)
            cad = cad.substring(0, cad.length()-1);
        cad += ";";
        
        return cad;
    }
    
}
 