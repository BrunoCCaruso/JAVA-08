package exercise_02_v2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;

public class PerroService {

    ArrayList<Perro> listaPerro = new ArrayList();

    private static Scanner entrada = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);

    public String preguntar() {
        System.out.println("Quiere ingresar una raza?");
        String resp = entrada.next();
        return resp;
    }

    public void rellenarLista() {
        String resp = "";
        do {
            switch (preguntar().toLowerCase()) {
                case "si":
                    System.out.println("Que raza quiere ingresar");
                    String raza = entrada.next();
                    Perro perro = new Perro(raza);
                    listaPerro.add(perro);
                    break;
                case "no":
                    visualizarLista();
                    resp = "no";
                    break;
                default:
                    System.out.println("No ingresó una opción válida");

            }

        } while (!(resp.equalsIgnoreCase("No")));
        
    }

    public void visualizarLista() {
        System.out.println("LISTA DE PERROS");
        for (Perro perro : listaPerro) {
            System.out.println(perro.getRaza());
        }

    }

    public void eliminarRaza() {
        
        String resp2 = "";
        do {
            System.out.println("Desea eliminar una raza?");
            resp2 = entrada.next();
            switch (resp2.toLowerCase()) {
                case "si":
                    
                    System.out.println("Que raza desea eliminar");
                    String razaAbuscar = entrada.next();
                    Iterator<Perro> it = listaPerro.iterator();
                    while (it.hasNext()) {
                        if (it.next().getRaza().equalsIgnoreCase(razaAbuscar)) {
                            it.remove();
                        }
                          
                        
                    }
                   

                    break;
                case "no":
                    visualizarLista();
                    resp2 = "no";
                    break;
                default:
                    System.out.println("No ingresó una opción válida");

            }

        } while (!(resp2.equalsIgnoreCase("No")));

    }
    
    public void ordenarRazas(){
        
        listaPerro.sort(compararRaza);
        visualizarLista();
    }
    
    
    
    
    public static Comparator<Perro> compararRaza = new Comparator<Perro>(){
        
        @Override
        public int compare(Perro p1, Perro p2) {
            return p1.getRaza().compareTo(p2.getRaza());
        }
        
    };  
    
    
    
    

}
