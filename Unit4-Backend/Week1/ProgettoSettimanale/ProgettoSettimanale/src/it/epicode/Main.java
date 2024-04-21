package it.epicode;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Audio audio1 = new Audio("Darsena", 10, 10);
        audio1.play();

        Video video1 = new Video("Loving can hurt", 20, 5, 3);
        video1.play();

        Immagine immagine1 = new Immagine("Il prigioniero di Azkaban", 7);
        immagine1.show();

        Scanner scanner = new Scanner(System.in);
        ElementoMultimediale[] elementi = new ElementoMultimediale[5];
        for (int i = 0; i < elementi.length; i++) {
            int risultato;
            do {
                System.out.println("Che elemento vuoi creare?\nDigita:\n1 - Immagine\n2 - Video\n3 - Audio");
                risultato = scanner.nextInt();
                if (risultato < 1 || risultato > 3) {
                    System.out.println("Devi inserire un numero positivo e che sia tra quelli indicati precedentemente");
                }
            } while(risultato < 1 || risultato > 3);
            scanner.nextLine();
            System.out.println("Inserisci un titolo per l'elemento scelto");
            String titolo = scanner.nextLine();
            int luminosita;
            int volume;
            int durata;
            switch (risultato){
                case 1:
                    do {
                        System.out.println("Quanta luminosità deve avere l'immagine? Numero da 0 a 10");
                        luminosita = scanner.nextInt();
                        if (luminosita < 0 || luminosita > 10) {
                            System.out.println("Devi inserire un numero positivo e che sia compreso tra 0 e 10");
                        }
                    } while (luminosita < 0 || luminosita > 10);
                    Immagine immagine = new Immagine(titolo, luminosita);
                    elementi[i] = immagine;
                    break;
                case 2:
                    do {
                        System.out.println("Quanta luminosità deve avere il video? Numero da 0 a 10");
                        luminosita = scanner.nextInt();
                        if (luminosita < 0 || luminosita > 10) {
                            System.out.println("Devi inserire un numero positivo e che sia compreso tra 0 e 10");
                        }
                    } while (luminosita < 0 || luminosita > 10);
                    do {
                        System.out.println("Che durata deve avere il video? Numero positivo da 1 a quanto desiderato");
                        durata = scanner.nextInt();
                        if (durata < 1) {
                            System.out.println("Devi inserire un numero positivo e diverso da 0");
                        }
                    } while (durata < 1);
                    do {
                        System.out.println("Che volume deve avere il video? Numero da 0 a 10");
                        volume = scanner.nextInt();
                        if (volume < 0 || volume > 10) {
                            System.out.println("Devi inserire un numero positivo e che sia compreso tra 0 e 10");
                        }
                    } while (volume < 0 || volume > 10);
                    Video video = new Video(titolo, durata, volume, luminosita);
                    elementi[i] = video;
                    break;
                case 3:
                    do {
                        System.out.println("Che durata deve avere l'audio? Numero positivo da 1 a quanto desiderato");
                        durata = scanner.nextInt();
                        if (durata < 1) {
                            System.out.println("Devi inserire un numero positivo e diverso da 0");
                        }
                    } while (durata < 1);
                    do {
                        System.out.println("Che volume deve avere l'audio? Numero da 0 a 10");
                        volume = scanner.nextInt();
                        if (volume < 0 || volume > 10) {
                            System.out.println("Devi inserire un numero positivo e che sia compreso tra 0 e 10");
                        }
                    } while (volume < 0 || volume > 10);
                    Audio audio = new Audio(titolo, durata, volume);
                    elementi[i] = audio;
                    break;
                default:
                    break;
            }
        }
        int scelta;
        do {
            System.out.println("Scegli uno numero tra 1 e 5 (elementi multimediali creati in precedenza)\nPer terminare" +
                    " il programma digita il numero 0");
            scelta = scanner.nextInt();
            if (scelta == 0) {
                System.out.println("Hai scelto di terminare il programma");
            } else if (scelta > 0 && scelta <= elementi.length) {
                System.out.println("Hai scelto il file multimediale chiamato "+elementi[scelta-1].getTitle());
                if (elementi[scelta-1] instanceof Riproducibile) {
                    ((Riproducibile) elementi[scelta - 1]).play();
                } else {
                    elementi[scelta-1].show();
                }
            } else {
                System.out.println("Devi inserire un numero tra 1 e 5");
            }

        } while (scelta != 0);
    }

    }


