package exercise_04_example;

import java.util.Comparator;

public class ComparadorMayorAMenorDur implements Comparator<Pelicula> {
    @Override
    public int compare(Pelicula a, Pelicula b) {
        if(a.getDuracion()>b.getDuracion()){
            return -1;
        }else if(a.getDuracion()<b.getDuracion()){
            return 1;
        }else{
            return 0;
        }

    }
}
