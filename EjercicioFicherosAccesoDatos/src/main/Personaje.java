package main;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author yo
 */
@XmlRootElement(name = "personaje")
class Personaje implements Serializable {
    
    public static final String[] TIPOS = {"Principal", "Secundario", "Recurrente"};
    
    private String nombre;
    private String genero;
    private int importancia;
    
    public Personaje(String nombre, String genero, int importancia) {
        this.nombre = nombre;
        this.genero = genero;
        this.importancia = importancia;
    }

    public Personaje() {
        nombre = "";
        genero = "";
        importancia=0;
    }
    
    public Personaje(String nombre, String genero, String importancia) {
        this.nombre = nombre;
        this.genero = genero;
        this.importancia = this.getImportanciaNum(importancia);
    }
    
    public int getImportanciaNum(String importancia) {
        int index = 0;
        for (int i = 0; i < TIPOS.length; i++) {
            if(importancia.compareToIgnoreCase(TIPOS[i]) == 0)
                index = i;
        }
        return index;
    }
    
    // -- Gets y Sets -- 
    public String getNombre() {
        return nombre;
    }
    
    @XmlElement(name = "nombre")
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getGenero() {
        return genero;
    }
    
    @XmlElement(name = "genero")
    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getImportancia() {
        return importancia;
    }

    @XmlElement(name = "importancia")
    public void setImportancia(int importancia) {
        this.importancia = importancia;
    }
    
    
    public String toString() {
        return nombre + "," + TIPOS[importancia >= 0? importancia : 0];
    }
    
}
