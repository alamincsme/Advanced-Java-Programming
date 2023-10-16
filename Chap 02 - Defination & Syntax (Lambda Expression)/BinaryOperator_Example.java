package learn_alamin_functional_interface;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

public class BinaryOperator_Example {

    public static BinaryOperator<Product> higherPricedProduct = (p1 , p2) -> p1.getPrice()  > p2.getPrice() ? p1 : p2 ;
    public static void main(String[] args) {
        Product product1 = new Product("Laptop", 5000);
        Product product2 = new Product("Iphone", 6400);
        Product higherPriced = higherPricedProduct.apply(product1, product2);
        System.out.println(higherPriced);
    }
}
