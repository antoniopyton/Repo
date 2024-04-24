package it.nextdevs.esercizio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        Product prodotto1 = new Product(1L, "School of Rock", "Books", 125.99);
        Product prodotto2 = new Product(2L, "School of Punk", "Books", 105.99);
        Product prodotto3 = new Product(3L, "School of Pop", "Books", 85.99);

        Product prodotto4 = new Product(4L, "Forrest Gump", "Movies", 15.99);
        Product prodotto5 = new Product(5L, "The Wolf of Wall Street", "Movies", 10.99);
        Product prodotto6 = new Product(6L, "Dragon Ball z: Broly Return", "Movies", 5.99);

        Product prodotto7 = new Product(7L, "Culla", "Baby", 225.99);
        Product prodotto8 = new Product(8L, "Latte in polvere x24", "Baby", 105.99);
        Product prodotto9 = new Product(9L, "Ciuccio", "Baby", 17.99);

        Product prodotto10 = new Product(10L, "Fumetto Topolino", "Boys", 15.99);
        Product prodotto11 = new Product(11L, "Manga One Piece Vol. 111", "Boys", 10.99);
        Product prodotto12 = new Product(12L, "iPad mini 256gb", "Boys", 485.99);



        List<Product> prodotti = new ArrayList<Product>();
        prodotti.add(prodotto1);
        prodotti.add(prodotto2);
        prodotti.add(prodotto3);
        prodotti.add(prodotto4);
        prodotti.add(prodotto5);
        prodotti.add(prodotto6);
        prodotti.add(prodotto7);
        prodotti.add(prodotto8);
        prodotti.add(prodotto9);
        prodotti.add(prodotto10);
        prodotti.add(prodotto11);
        prodotti.add(prodotto12);
        List<Product> libriCostosi = prodotti.stream().filter(product -> product.getCategory().equals("Books"))
                .filter(product -> product.getPrice() > 100).toList();
        libriCostosi.stream().forEachOrdered(prodotto -> {
            System.out.println("Id: " + prodotto.getId());
            System.out.println("Nome: " +prodotto.getName());
            System.out.println("Categoria: " + prodotto.getCategory());
            System.out.println("Prezzo: " + prodotto.getPrice());
            System.out.println("-             -");
        });

        //

        Customer utente = new Customer(1L, "Antonio Copetti", 1);
        Customer utente2 = new Customer(2L, "Vito D'Agnello", 1);
        Customer utente3 = new Customer(3L, "Luigi Copetti", 1);
        Customer utente4 = new Customer(4L, "Fabio Brogi", 2);

        Order ordine = new Order(1L, "ordinato", LocalDate.now(), LocalDate.now().plusDays(3), new ArrayList<Product>(), utente);
        ordine.addProduct(prodotto6);
        ordine.addProduct(prodotto11);
        ordine.addProduct(prodotto12);
        Order ordine2 = new Order(2L, "ordinato", LocalDate.now(), LocalDate.now().plusDays(2), new ArrayList<Product>(), utente2);
        ordine2.addProduct(prodotto7);
        ordine2.addProduct(prodotto8);
        ordine2.addProduct(prodotto9);
        Order ordine3 = new Order(3L, "ordinato", LocalDate.now(), LocalDate.now().plusDays(4), new ArrayList<Product>(), utente3);
        ordine3.addProduct(prodotto1);
        ordine3.addProduct(prodotto2);
        ordine3.addProduct(prodotto3);
        Order ordine4 = new Order(4L, "ordinato", LocalDate.now(), LocalDate.now().plusDays(1), new ArrayList<Product>(), utente4);
        ordine4.addProduct(prodotto10);
        ordine4.addProduct(prodotto9);

        List<Order> ordini = Order.getOrders();
        List<Order> ordiniBaby = ordini.stream().filter(order -> {
            List<Product> prodottiBaby = order.getProducts().stream().filter(product -> product.getCategory().equals("Baby"))
                    .toList();
            return  !prodottiBaby.isEmpty();
        }).toList();

        ordiniBaby.forEach(order -> {
            System.out.println("Id: " + order.getId());
            System.out.println("Status: " + order.getStatus());
            System.out.println("Data Ordine: " + order.getOrderDate());
            System.out.println("Data Consegna: " + order.getDeliveryDate());
            Integer articoli = order.getProducts().size();
            System.out.println("Articoli: " + articoli);
            System.out.println("Cliente Id: " + order.getCustomer().getId());
            System.out.println("Nome Cliente: " + order.getCustomer().getName());
            System.out.println("Tier: " + order.getCustomer().getTier());
            System.out.println("-                  -");
        });

        List<Product> boysProd = prodotti.stream()
                .filter(product -> product.getCategory().equals("Boys"))
                .peek(product -> product.setPrice(product.getPrice()*0.9))
                .toList();
        boysProd.forEach(prodotto -> {
            System.out.println("Id: " + prodotto.getId());
            System.out.println("Nome: " + prodotto.getName());
            System.out.println("Categoria: " + prodotto.getCategory());
            System.out.println("Prezzo scontato: " + prodotto.getPrice());
            System.out.println("-             -");
        });

        List<Order> prodOrdinati = ordini.stream()
                .filter(order -> order.getCustomer().getTier() == 2)
                .filter(order -> {
                    LocalDate inizio = LocalDate.of(2024, 2, 1 );
                    LocalDate fine = LocalDate.of(2024,6,1);
                    if(order.getOrderDate().isAfter(inizio) && order.getOrderDate().isBefore(fine)) {
                        return true;
                    }
                        return false;
                }).toList();

List<Product> prodOrdTier2 = new ArrayList<>();
prodOrdinati.forEach(order -> {
    prodOrdTier2.addAll(order.getProducts());
});
prodOrdTier2.forEach(prodotto -> {
    System.out.println("Id: " + prodotto.getId());
    System.out.println("Nome: " + prodotto.getName());
    System.out.println("Categoria: " + prodotto.getCategory());
    System.out.println("Prezzo: " + prodotto.getPrice());
    System.out.println("-             -");

});

    }

}
