package exercise_04_example;

import java.util.Comparator;

public class ComparadorOrdenAlfabTitulo implements Comparator<Pelicula> {
    @Override
    public int compare(Pelicula a, Pelicula b) {
        return a.getTitulo().compareTo(b.getTitulo());
    }
}
