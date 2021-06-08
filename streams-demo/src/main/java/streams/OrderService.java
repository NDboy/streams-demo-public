package streams;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class OrderService {

    private List<Order> orders = new ArrayList<>();


    public void saveOrder(Order order){
        orders.add(order);
    }

    public long countOrderByStatus(String status) {
        return orders.stream()
                .filter(o -> status.equals(o.getStatus()))
                .count();
    }

    public List<Order> collectOrdersWithProductCategory(String category) {
        return orders.stream()
                .filter(o -> o.getProducts().stream().anyMatch(p -> category.equals(p.getCategory())))
                .collect(Collectors.toList());
    }

}
