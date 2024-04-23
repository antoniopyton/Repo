package it.nextdevs.esercizio3;

public class UsaRubrica {
    public static void main(String[] args) {
        Rubrica rubrica = new Rubrica();

        rubrica.inserisciContatto("Carla Russo", "3841546845");
        rubrica.inserisciContatto("Darko Trollo", "1231231231");
        rubrica.inserisciContatto("Franco Manco", "3332548698");
        rubrica.inserisciContatto("Franco Drago", "34567894526");

        rubrica.stampaRubrica();

        System.out.println(rubrica.cercaPerNome("Franco Manco"));
        rubrica.cercaPerNumero("3841546845");

        rubrica.rimuoviContatto("Franco Drago");

        rubrica.stampaRubrica();
    }
}
