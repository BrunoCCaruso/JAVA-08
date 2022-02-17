package exercise_03_v2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;

public class AlumnoServicio {

    private ArrayList<Alumno> alumnos = new ArrayList();
    private static Scanner entrada = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);
    Alumno alumnito = new Alumno();

    public String menu() {
        System.out.println("----------- MENU -------------");
        System.out.println("a- Crear alumno\nb- Calcular promedio\nc- Salir");
        String resp = entrada.next();
        return resp;
    }

    public void ingresarDatos() {

        String respUsuario = "";
        do {
            respUsuario = menu();
            switch (respUsuario.toLowerCase()) {
                case "a":
                    ArrayList<Integer> notas = new ArrayList();
                    System.out.println("Ingrese el nombre: ");
                    String nombre = entrada.next();
                    for (int i = 0; i < 3; i++) {
                        System.out.println("Ingrese la nota número " + (i + 1) + ": ");
                        int nota = entrada.nextInt();
                        notas.add(nota);
                    }
                    crearAlumno(nombre, notas);
                    break;
                case "b":
                    calcularPromedio(alumnito.getNotas());
                    break;
                case "c":
                    System.out.println("Salió exitosamente.");
                    break;
                default:
                    System.out.println("No ingresó una opción válida.");
            }

        } while (!(respUsuario.equalsIgnoreCase("c")));
    }

    public void crearAlumno(String nombre, ArrayList<Integer> notas) {

        alumnito = new Alumno(nombre, notas);
        agregarAlumno(alumnito);
    }

    public void agregarAlumno(Alumno alumnito) {
        alumnos.add(alumnito);
    }

    public void calcularPromedio(ArrayList<Integer> notas) {
        System.out.println("ingrese nombre a buscar y calcular promedio");
        String nombreAbuscar = entrada.next();
        boolean existeAlumno = false;
        Iterator<Alumno> it = alumnos.iterator();
        while (it.hasNext()) {

            if (it.next().getNombre().equals(nombreAbuscar)) {
                System.out.println("El promedio es " + notaFinal(notas));
                existeAlumno = true;
            }

        }
        if (!existeAlumno) {
            System.out.println("no se encontro el nombre");
        }
    }

    public int notaFinal(ArrayList<Integer> notas) {

        int acu = 0;
        Iterator<Integer> iterator = notas.iterator();
        while (iterator.hasNext()) {
            Integer notaIngresada = iterator.next();
            acu += notaIngresada;
        }
        return acu / 3;

    }

}
