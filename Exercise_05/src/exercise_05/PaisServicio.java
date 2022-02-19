package exercise_05;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;


public class PaisServicio {

    private ArrayList<Pais> listaPaises = new ArrayList<>();
    private Pais pais;

    private Scanner entrada = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);

    public void menu() {
        System.out.println(" /////////////// MENU //////////////////\n" + "a- Ingresar país.\n" + "b- Mostrar lista de países.\n" + "c- Eliminar un país de la lista.\n" + "d- Salir.\n" + "-------------------------------------------\n");
        respuestaUsuario();
    }

    public void respuestaUsuario() {
        System.out.print("Ingresar opción: ");
        String resp = entrada.next();
        selectorOpciones(resp);
    }

    public void selectorOpciones(String resp) {
        switch (resp.toLowerCase()) {
            case "a":
                crearPais();
                menu();
                break;
            case "b":
                mostrarPaises();
                menu();
                break;
            case "c":
                eliminarPais();
                menu();
                break;
            case "d":
                System.out.println("Salió exitosamente.");
                break;
            default:
                System.out.println("Ingrese una opción válida.");
                menu();
                break;
        }

    }

    public void crearPais() {
        pais = new Pais();
        System.out.println("Ingrese el país: ");
        String nombrePais = entrada.next();
        pais.setPais(nombrePais);
        añadirPais(pais);
    }

    public void añadirPais(Pais pais) {
        listaPaises.add(pais);
    }

    public void mostrarPaises() {
        System.out.println("|--------- LISTA DE PAISES ------------|");
        for (Pais pais : listaPaises) {
            System.out.println("-" + pais.getPais());
        }

    }

    public void eliminarPais() {
        System.out.println("Qué país desea quitar de la lista?");
        String resp2 = entrada.next();
        boolean band = false;
        Iterator<Pais> it = listaPaises.iterator();
        while (it.hasNext()) {
            if (it.next().getPais().equalsIgnoreCase(resp2)) {
                it.remove();
                band = true;
            }
        }
        if (band) {
            System.out.println("Se eliminó el país correctamente!");
        } else {
            System.out.println("No se encontró el país en la lista.");
        }
    }


}
