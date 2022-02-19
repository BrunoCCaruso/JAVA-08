package exercise_04_example;

import java.util.Comparator;

public class ComparadorOrdenAlfabDirector implements Comparator<Pelicula> {
    @Override
    public int compare(Pelicula a, Pelicula b) {
        return a.getDirector().compareTo(b.getDirector());
    }
}
