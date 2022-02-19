package exercise_04_example;

import java.util.*;

public class PeliculaService {

    private ArrayList<Pelicula> listaPeli = new ArrayList<>();


    private static Scanner entrada = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);

    public void menu() {
        System.out.println("|----------------------- MENU -----------------------------|\n" + "a-Ingresar película.\n" + "b-Ver lista de películas.\n" + "c-Ver películas de más de una hora.\n" + "d-Ver películas de acuerdo a su duración (de mayor a menor)\n" + "e-Ver películas de acuerdo a su duración (de menor a mayor)\n" + "f-Ordenar las películas por titulo, alfabéticamente.\n" + "g-Ordenar las películas por director, alfabéticamente.\n" + "h-Salir." + "|----------------------------------------------------------|\n");
        respuestaUsuario();
    }

    public void respuestaUsuario() {
        System.out.print("Opción elegida: ");
        String resp = entrada.next();

        llamadorDeMetodos(resp);
    }

    public void llamadorDeMetodos(String resp) {

        switch (resp.toLowerCase()) {
            case "a":
                crearPelicula();
                menu();
                break;
            case "b":
                verListaPelis();
                menu();
                break;
            case "c":
                verListaMayorHora();
                menu();
                break;
            case "d":
                verListaMayorAMenorDur();
                menu();
                break;
            case "e":
                verListaMenorAMayorDur();
                menu();
                break;
            case "f":
                verListaOrdenAlfabTitulo();
                menu();
                break;
            case "g":
                verListaOrdenAlfabDirector();
                menu();
                break;
            case "h":
                System.out.println("Salió exitosamente.");
                break;
            default:
                System.out.println("Ingrese una opción válida");
                menu();
                break;
        }

    }

    public void crearPelicula() {
        Pelicula peli = new Pelicula();
        System.out.println("Ingrese el título: ");
        String titulo = entrada.next();
        peli.setTitulo(titulo);
        System.out.println("Ingrese el director: ");
        String director = entrada.next();
        peli.setDirector(director);
        System.out.println("Ingrese la duración en horas: ");
        double duracion = entrada.nextDouble();
        peli.setDuracion(duracion);

        crearListaPeliculas(peli);

    }

    public void crearListaPeliculas(Pelicula peli) {

        listaPeli.add(peli);

    }

    public void verListaPelis() {
        for (Pelicula pelicula : listaPeli) {
            System.out.println("-------------------------------------------");
            System.out.println("Título: " + pelicula.getTitulo());
            System.out.println("Director/a: " + pelicula.getDirector());
            System.out.println("Duración: " + pelicula.getDuracion() + "hs.");
            System.out.println("-------------------------------------------");
        }

    }

    public void verListaMayorHora() {
        System.out.println("//////////////// Lista de películas mayores a una hora: ");
        for (Pelicula pelicula : listaPeli) {
            if (pelicula.getDuracion() > 1) {
                System.out.println("-------------------------------------------");
                System.out.println("Título: " + pelicula.getTitulo());
                System.out.println("Director/a: " + pelicula.getDirector());
                System.out.println("Duración: " + pelicula.getDuracion() + "hs.");
                System.out.println("-------------------------------------------");
            }
        }
    }


    public void verListaMayorAMenorDur() {

        Collections.sort(listaPeli, new ComparadorMayorAMenorDur());
        verListaPelis();
    }

    public void verListaMenorAMayorDur() {

        Collections.sort(listaPeli, new ComparadorMenorAMayorDur());
        verListaPelis();
    }

    public void verListaOrdenAlfabTitulo() {
        Collections.sort(listaPeli, new ComparadorOrdenAlfabTitulo());
        verListaPelis();
    }

    public void verListaOrdenAlfabDirector() {
        Collections.sort(listaPeli, new ComparadorOrdenAlfabDirector());
        verListaPelis();
    }


}