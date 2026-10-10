package encapsulation.assignment;

public class ShoppingCart {
    public static class Cart {
        private final String cartId;
        private final double[] prices;
        private int count;

        public Cart(String id, int cap) {
            cartId = id;
            prices = new double[cap];
        }

        public boolean addItem(double price) {
            if (count == prices.length || price < 0) return false;
            prices[count++] = price;
            return true;
        }

        public String getCartId() {
            return cartId;
        }

        public int getItemCount() {
            return count;
        }

        public double getTotal() {
            double sum = 0;
            for (int i = 0; i < count; i++) sum += prices[i];
            return sum;
        }
    }

    public static void main(String[] x) {
        Cart c = new Cart("CART-5", 20);
        c.addItem(250);
        c.addItem(99);
        c.addItem(151);
        System.out.println(c.getTotal() + " " + c.getItemCount());
    }
}
