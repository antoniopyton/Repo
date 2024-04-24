package Lambada;

import java.util.TreeSet;

public class ProvaLambda3 {

    public static void main(String[] args) {

        TreeSet<String> parole = new TreeSet<>(((o1, o2) -> o2.compareTo(o1)));

        parole.add("java");
        parole.add("html");
        parole.add("css");
        parole.add("javascript");

        System.out.println(parole);

        for(String s:parole) {
            System.out.println(s);
        }
        // il metodo removeIf accetta una espressione lambda nella quale inseriamo la condizione per la quale
        // rimuovere una parola nel treeset
        parole.removeIf(s -> s.contains("j"));

        parole.forEach(s -> System.out.println(s));


    }
}
