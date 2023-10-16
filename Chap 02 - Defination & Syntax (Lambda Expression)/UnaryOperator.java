package learn_alamin_functional_interface;


import java.util.function.UnaryOperator;

class ProductDiscount {
    private String name;
    private double price;


    public ProductDiscount(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

 class DiscountCalculator {

    public static UnaryOperator<Double> discountCalculator = (Double price) -> price * 0.9;

    public static void main(String[] args) {
        ProductDiscount product = new ProductDiscount("Laptop", 1000.0);
        double discountedPrice = discountCalculator.apply(product.getPrice());
        System.out.println("Discounted Price: $" + discountedPrice);
    }
}