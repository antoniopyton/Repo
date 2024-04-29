package it.NextDevs;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Product> prodotti = Arrays.asList(
                new Product("1", "One Piece Vol. 111", 12.99, 10, "Manga"),
                new Product("2", "Funko Pop Franky", 35.99, 5, "Boys"),
                new Product("3", "Sudoku", 9.99, 15, "Entertainment"),
                new Product("4", "Garfield Pupazzo gigante", 39.99, 2, "Kids"),
                new Product("5", "Lego Harry Potter", 34.99, 8, "Kids"),
                new Product("6", "The truman Show", 4.99, 15, "Movies"),
                new Product("7", "Fight Club", 4.99, 5, "Movies"),
                new Product("8", "Naruto Vol. 69", 8.99, 5, "Manga"),
                new Product("9", "Funko Pop Groot", 29.99, 12, "Boys"),
                new Product("10", "Monopoly: Formula 1 Edition", 39.99, 5, "Entertainment")
        );

        List<Customer> customers = Arrays.asList(
                new Customer("1", "Fabio Brogi", "fabio@brogi.it"),
                new Customer("2", "Ionut Alexandru Ifrim", "IOnut@ifrim.ro"),
                new Customer("3", "Enrico Cirotto", "enrico@cirotto.it")
        );

        List<Order> orders = Arrays.asList(
                new Order(customers.get(0), "1"),
                new Order(customers.get(1), "2"),
                new Order(customers.get(2), "3")
        );

        orders.get(0).aggiungiProdotto(prodotti.get(0));

//        //Interazioni con streams
//        //Filtro e prendo solo i prodotti con nome "Sudoku"
//        prodotti.stream().filter(product -> product.getName().equals("Sudoku")).forEach(product -> {
//            System.out.println("Id Prodotto: " + product.getId());
//            System.out.println("Nome prodotto: " + product.getName());
//            System.out.println("Prezzo: " + product.getPrice());
//            System.out.println("------------------------" );
//        });
//
        //Filtro e stampo i prodotti per una determinata categoria
//        prodotti.stream().filter(product -> product.getCategory().equals("Manga")).forEach(product -> {
//            System.out.println("Id Prodotto: " + product.getId());
//            System.out.println("Nome prodotto: " + product.getName());
//            System.out.println("Prezzo: " + product.getPrice());
//            System.out.println("------------------------" );
//        });

        System.out.println("Benvenuto, digita un numero per selezionare la categoria in cui vuoi entrare");
        System.out.println("1 - Manga");
        System.out.println("2 - Boys");
        System.out.println("3 - Entertainment");
        System.out.println("4 - Movies");
        System.out.println("5 - Kids");
        System.out.println("6 - Per uscire.");
        try {
            int categoria = scanner.nextInt();
            switch (categoria) {
                case 1:
                    prodotti.stream().filter(product -> product.getCategory().equals("Manga")).forEach(product -> {
                        System.out.println("Ecco i prodotti per la categoria " + product.getCategory());
                        System.out.println("Id Prodotto: " + product.getId());
                        System.out.println("Nome prodotto: " + product.getName());
                        System.out.println("Prezzo: " + product.getPrice());
                        System.out.println("------------------------" );
                    });
                    break;
                case 2:
                    prodotti.stream().filter(product -> product.getCategory().equals("Boys")).forEach(product -> {
                        System.out.println("Ecco i prodotti per la categoria " + product.getCategory());
                        System.out.println("Id Prodotto: " + product.getId());
                        System.out.println("Nome prodotto: " + product.getName());
                        System.out.println("Prezzo: " + product.getPrice());
                        System.out.println("------------------------" );
                    });
                    break;
                case 3:
                    prodotti.stream().filter(product -> product.getCategory().equals("Entertainment")).forEach(product -> {
                        System.out.println("Ecco i prodotti per la categoria " + product.getCategory());
                        System.out.println("Id Prodotto: " + product.getId());
                        System.out.println("Nome prodotto: " + product.getName());
                        System.out.println("Prezzo: " + product.getPrice());
                        System.out.println("------------------------" );
                    });
                    break;
                case 4:
                    prodotti.stream().filter(product -> product.getCategory().equals("Movies")).forEach(product -> {
                        System.out.println("Ecco i prodotti per la categoria " + product.getCategory());
                        System.out.println("Id Prodotto: " + product.getId());
                        System.out.println("Nome prodotto: " + product.getName());
                        System.out.println("Prezzo: " + product.getPrice());
                        System.out.println("------------------------" );
                    });
                    break;
                case 5:
                    prodotti.stream().filter(product -> product.getCategory().equals("Kids")).forEach(product -> {
                        System.out.println("Ecco i prodotti per la categoria " + product.getCategory());
                        System.out.println("Id Prodotto: " + product.getId());
                        System.out.println("Nome prodotto: " + product.getName());
                        System.out.println("Prezzo: " + product.getPrice());
                        System.out.println("------------------------" );
                    });
                    break;
                case 6:
                    System.out.println("Uscita dall'applicazione...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("numero non accettato");
            }

        } catch (Exception e) {
            System.out.println("Non puoi inserire una stringa, inserisci un numero");

        }



    }
}
