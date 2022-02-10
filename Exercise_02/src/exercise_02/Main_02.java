////////// CONSIGNA //////////////////////////
/*
Continuando el ejercicio anterior, después de mostrar los perros, al usuario se le
pedirá un perro y se recorrerá la lista con un Iterator, se buscará el perro en la lista.
Si el perro está en la lista, se eliminará el perro que ingresó el usuario y se mostrará
la lista ordenada. Si el perro no se encuentra en la lista, se le informará al usuario y
se mostrará la lista ordenada.

*/
package exercise_02;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;


public class Main_02 {

    
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);
        ArrayList<String> razas = new ArrayList();

        System.out.println("Ingrese una raza de perro: ");
        String raza = entrada.next();

        razas.add(raza);

        boolean respuesta = true;

        while (respuesta) {
            System.out.println("Quiere ingresar una raza nueva o no?");
            String resp = entrada.next();
            if (resp.equalsIgnoreCase("Si")) {
                System.out.println("Ingrese una nueva raza de perro: ");
                razas.add(entrada.next());
            } else if (resp.equalsIgnoreCase("No")) {
                System.out.println(razas);
                respuesta = false;
            } else {
                System.out.println("Ingrese una opción válida");
            }

        }

        System.out.println("Quiere eliminar una raza de la lista?");
        String resp2 = entrada.next();
    
        boolean existeRaza = false;
        
        if (resp2.equalsIgnoreCase("Si")) {
            System.out.println("Cual es la raza que desea eliminar?");
            String respRaza = entrada.next();

            Iterator<String> it = razas.iterator();
            while (it.hasNext()) {
                if(it.next().equals(respRaza)){
                    it.remove();
                    existeRaza = true;
                }
            }
            
            if(existeRaza){
                System.out.println("Se eliminó la raza correctamente.");
                System.out.println(razas);
            }else{
                System.out.println("La raza ingresada no existe.");
                System.out.println(razas);
            }
                

        } else if (resp2.equalsIgnoreCase("No")) {
            System.out.println("Bueno, no hay problema.");
        } else {
            System.out.println("Nos pusiste cualquier cosa, así que chau.");
        }
        
        
        
        
    }
    
}
