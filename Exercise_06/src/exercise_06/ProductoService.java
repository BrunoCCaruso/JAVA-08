package exercise_06;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class ProductoService {
    HashMap<String, Double> mapaProductos = new HashMap<>();


    private static Scanner entrada = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);

    public void menu() {
        System.out.println
                (
                        "\n|-------------- MENU -----------------|\n" +
                                "a- Ingresar producto.\n" +
                                "b- Ver lista de productos.\n" +
                                "c- Modificar precio.\n" +
                                "d- Eliminar producto.\n" +
                                "e- Salir.\n" +
                                "|-------------------------------------|\n"
                );
        respuestaUsuario();
    }

    public void respuestaUsuario() {
        System.out.print("Opción seleccionada: ");
        String resp = entrada.next();

        seleccionadorOpciones(resp);
    }

    public void seleccionadorOpciones(String resp) {

        switch (resp.toLowerCase()) {
            case "a":
                crearProducto();
                menu();
                break;
            case "b":
                verListaProductos();
                menu();
                break;
            case "c":
                modificarPrecio();
                menu();
                break;
            case "d":
                eliminarProducto();
                menu();
                break;
            case "e":
                System.out.println("Salió exitosamente!");
                break;
            default:
                System.out.println("Ingrese una opción válida.");
                menu();
                break;
        }

    }

    public void crearProducto() {

        System.out.println("Ingrese el producto: ");
        String producto = entrada.next();
        System.out.println("Ingrese su precio: ");
        double precio = entrada.nextDouble();

        añadirProducto(producto, precio);
    }

    public void añadirProducto(String producto, double precio) {
        mapaProductos.put(producto, precio);
    }

    public void verListaProductos() {
        for (Map.Entry<String, Double> prod : mapaProductos.entrySet()) {
            System.out.println("|-Producto = " + prod.getKey() + ", precio = $" + prod.getValue() + " |");
        }

    }

    public void eliminarProducto() {
        System.out.println("Que producto desea eliminar?");
        String prod = entrada.next();

        if (mapaProductos.containsKey(prod)) {
            mapaProductos.remove(prod);
            System.out.println("Producto eliminado correctamente!");
        } else {
            System.out.println("No se encontró el producto en la lista.");
        }
    }


    public void modificarPrecio() {
        System.out.println("Que producto desea modificar su precio?");
        String prod2 = entrada.next();
        boolean existeProd2 = false;

        for (Map.Entry<String, Double> producto : mapaProductos.entrySet()) {
            if (producto.getKey().equalsIgnoreCase(prod2)) {
                System.out.println("Producto encontrado!");
                System.out.print("Ingrese el nuevo precio: ");
                double precioNuevo = entrada.nextDouble();
                producto.setValue(precioNuevo);
                existeProd2 = true;
            }
        }
        if (existeProd2) {
            System.out.println("Precio modificado con éxito!");
        } else {
            System.out.println("No se encontró el producto en la lista.");
        }


    }
}
