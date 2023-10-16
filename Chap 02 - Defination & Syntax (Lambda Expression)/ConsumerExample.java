package learn_alamin_functional_interface;


import java.util.List;
import java.util.function.Consumer;

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

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}


public class ConsumerExample {

    static Consumer<Product> applyDiscount = (Product product) -> {
                                      double discountPrice = product.getPrice() * .9;
                                      product.setPrice(discountPrice);
    };


    public static void main(String[] args) {

        List<Product> products = List.of (new Product("Laptop", 64000), new Product("Iphone14", 90000));
        products.forEach(applyDiscount);
        products.forEach(System.out::println);

    }
}

