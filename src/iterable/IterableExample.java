package iterable;

public class IterableExample {

    public static void main(String[] args) {
        Cashback<Product> cashbackProducts = new Cashback<>();
        cashbackProducts.add(new Meat());
        cashbackProducts.add(new Milk());
        cashbackProducts.add(new Fish());

        double cashBack = calculateCashback(cashbackProducts);

        System.out.println(cashBack);
    }

    private static double calculateCashback(Cashback<Product> cashbackProducts) {
        double cashBack = 0;
        for (Product product : cashbackProducts) {
            cashBack += product.price * 0.1;
        }
        return cashBack;
    }


}
