package exercise_01_v2;

import java.util.ArrayList;
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
                    System.out.println("Hasta la próxima");
                    resp = "no";
                    break;
                default:
                    System.out.println("No ingresó una opción válida");
                    
            }

        } while (!(resp.equalsIgnoreCase("No")));
        visualizarLista();
    }

    public void visualizarLista() {
        System.out.println("LISTA DE PERROS");
        for(Perro perro : listaPerro) {
            System.out.println(perro.getRaza());
        }

    }

}
