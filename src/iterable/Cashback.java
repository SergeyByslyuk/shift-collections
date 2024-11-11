package iterable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cashback<E extends Product> implements Iterable<Product> {

    private final List<Product> products;

    public Cashback() {
        this.products = new ArrayList<>();
    }

    public void add(E product) {
        products.add(product);
    }

    @Override
    public Iterator<Product> iterator() {
        return new CashbackIterator();
    }

    private class CashbackIterator implements Iterator<Product> {

        int cursor;

        @Override
        public boolean hasNext() {
            if (cursor > products.size()) {
                return false;
            }

            for (int i = cursor; i < products.size(); i++) {
                if (isBigPrice(products.get(i))) {
                    cursor = i;
                    return true;
                }
            }

            return false;
        }

        private boolean isBigPrice(Product product) {
            return product.price > 50;
        }

        @Override
        public Product next() {
            return products.get(cursor++);
        }
    }
}

