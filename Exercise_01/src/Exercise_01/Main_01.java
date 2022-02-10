///////////// CONSIGNA /////////////////
/*
Diseñar un programa que lea y guarde razas de perros en un ArrayList de tipo String.
El programa pedirá una raza de perro en un bucle, el mismo se guardará en la lista y
después se le preguntará al usuario si quiere guardar otro perro o si quiere salir. Si
decide salir, se mostrará todos los perros guardados en el ArrayList.
 */
package exercise_01;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main_01 {

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

    }

}
