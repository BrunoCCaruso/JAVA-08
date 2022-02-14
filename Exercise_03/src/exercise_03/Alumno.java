
package exercise_03;

import java.util.ArrayList;
import java.util.Iterator;


public class Alumno {

    private String nombre;
    private ArrayList<Integer> notas;

    public Alumno() {
    }

    public Alumno(String nombre, ArrayList<Integer> notas) {
        this.nombre = nombre;
        this.notas = notas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Integer> getNotas() {
        return notas;
    }

    public void setNotas(ArrayList<Integer> notas) {
        this.notas = notas;
    }
    
    public int notaFinal(ArrayList<Integer> notas){
        
        int acu=0;
        Iterator<Integer> iterator=notas.iterator();
        while (iterator.hasNext()) {
            Integer nota2=iterator.next();
            acu+=nota2;
        }
        return acu/3;
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
