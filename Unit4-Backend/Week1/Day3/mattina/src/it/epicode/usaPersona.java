package it.epicode;

public class usaPersona {

    public static void main(String[] args) {
        Persona p = new Persona("Antonio", "Copetti", 25);

        System.out.println(p.nome);
        System.out.println(p.cognome);
        System.out.println(p.eta);

        System.out.println(p.contatore);

        Persona p2 = new Persona("Luigi", "Copetti", 27);

        System.out.println(p2.nome);
        System.out.println(p2.cognome);
        System.out.println(p2.eta);


        System.out.println(p2.contatore);
    }

}
