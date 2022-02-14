///////////// CONSIGNA ///////////////////////////

/*Crear una clase llamada Alumno que mantenga información sobre las notas de
distintos alumnos. La clase Alumno tendrá como atributos, su nombre y una lista de
tipo Integer con sus 3 notas.
En el main deberemos tener un bucle que crea un objeto Alumno. Se pide toda la
información al usuario y ese Alumno se guarda en una lista de tipo Alumno y se le
pregunta al usuario si quiere crear otro Alumno o no.
Después de ese bluce tendremos el siguiente método en la clase Alumno:
Método notaFinal(): El usuario ingresa el nombre del alumno que quiere calcular su
nota final y se lo busca en la lista de Alumnos. Si está en la lista, se llama al método.
Dentro del método se usará la lista notas para calcular el promedio final de alumno.
Siendo este promedio final, devuelto por el método y mostrado en el main.
 */
package exercise_03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;

public class Exercise_03 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);
        ArrayList<Alumno> alumnos = new ArrayList();
        Alumno alumnito = new Alumno();
        String resp, nombreAbuscar;
        do {
            System.out.println("----------- MENU -------------");
            System.out.println("a- Crear alumno\nb- Calcular promedio\nc- Salir");
            resp = entrada.next();

            if (resp.equalsIgnoreCase("a")) {

                ArrayList<Integer> notas = new ArrayList();
                System.out.println("Ingrese el nombre: ");
                String nombre = entrada.next();
                for (int i = 0; i < 3; i++) {
                    System.out.println("Ingrese la nota número " + (i+1) + ": ");
                    int nota = entrada.nextInt();
                    notas.add(nota);

                }
                alumnito = new Alumno(nombre, notas);
                alumnos.add(alumnito);

            } else if (resp.equalsIgnoreCase("b")) {
                System.out.println("ingrese nombre a buscar y calcular promedio");
                nombreAbuscar = entrada.next();
                boolean existeAlumno = false;
                Iterator<Alumno> it = alumnos.iterator();
                while (it.hasNext()) {

                    if (it.next().getNombre().equals(nombreAbuscar)) {
                        System.out.println("El promedio es " + alumnito.notaFinal(alumnito.getNotas()));
                        existeAlumno = true;
                    }

                }
                if (!existeAlumno) {
                    System.out.println("no se encontro el nombre");
                }
                
            } else if (resp.equalsIgnoreCase("c")) {
                System.out.println("Salió exitosamente.");
            } else {
                System.out.println("No ingresó una opción válida.");
            }

        } while (!(resp.equalsIgnoreCase("c")));

    }

}
