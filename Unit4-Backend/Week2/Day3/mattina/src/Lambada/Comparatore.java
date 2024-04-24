package Lambada;

import java.util.Comparator;

public class Comparatore implements Comparator<String> {


    @Override
    public int compare(String o1, String o2) {
        //restituisce un numero negativo se o2 viene prima di o1, in caso contrario un numero positivo, restituisce 0 se o1 = o2
        return o2.compareTo(o1);
    }

}
