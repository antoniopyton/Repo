package List;

import java.util.ArrayList;

public class Prova1 {

    public static void main(String[] args) {

        ArrayList<String> lista = new ArrayList<String>();
        lista.add("zero");
        lista.add("ciao");
        lista.add("true");

        lista.get(1);
        lista.set(1, "primo");
        System.out.println(lista.size() + " " + lista.get(2));
        lista.remove(2);
        System.out.println(lista.size() + " " + lista.get(1));

        System.out.println(lista.contains("java"));

        System.out.println(lista.isEmpty());

        System.out.println(lista.indexOf("java"));

        lista.add("css");
        lista.add("javascript");
        lista.add("css");
        lista.add("python");
        lista.add("html");
        lista.add("antonio");

        System.out.println(lista.indexOf("css"));
        System.out.println(lista.lastIndexOf("css"));
        System.out.println(lista.size());


    }

}
