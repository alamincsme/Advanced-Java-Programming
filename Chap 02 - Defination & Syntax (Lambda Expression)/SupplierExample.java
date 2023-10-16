package learn_alamin_functional_interface;


import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

class Order {
    private String orderId;
    private String productName;


    public Order(String productName, Supplier<String> orderGenrator) {
        this.productName = productName;
        this.orderId = orderGenrator.get();
    }

    public String getOrderId() {
        return orderId;
    }

    public String getProductName() {
        return productName;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", productName='" + productName + '\'' +
                '}';
    }
}



public class SupplierExample {

    public static Supplier<String> orderGenrator = () -> "ORD"+Math.round(Math.random() * 1000);
    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(new Order("Laptop",orderGenrator),
                             new Order("Phone", orderGenrator),
                             new Order("Tablet", orderGenrator));

        orders.forEach(System.out :: println);

    }
}
