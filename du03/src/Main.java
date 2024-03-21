public class Main {
    public static void main(String[] args) {
        Item item1 = new Item("Tričko", 250.00, 4);
        Item item2 = new Item("Boty", 1999.90, 1);
        Item item3 = new Item("Kraťasy", 750.50,2);

        ShoppingCart cart = new ShoppingCart();
        cart.add(item1);
        cart.add(item2);
        cart.add(item3);

        System.out.println("Cena nákupu v Kč: " + cart.getTotalPrice());
        System.out.println("Cena nákupu s 20% slevou v Kč: " + cart.getTotalPriceWithDiscount(20));
        System.out.println("Název položek: " + cart.getItemNames());


        double averagePrice = cart.getAveragePrice();
        System.out.println("Průměrná cena v košíku je: " + averagePrice);
    }
}
