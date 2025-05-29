package cl.duoc.daibarram.ecomarketstoreservice.repository;

import cl.duoc.daibarram.ecomarketstoreservice.repository.entity.OrderEntity;
import cl.duoc.daibarram.ecomarketstoreservice.repository.entity.ProductEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class OrderRepository {

    List<OrderEntity> orders;

    public OrderRepository() {
        orders = new ArrayList<>();

        List<ProductEntity> products1 = Arrays.asList (
                new ProductEntity(1, 1, "Pan", "Pan integral", 1500),
                new ProductEntity(2, 1, "Leche", "Leche descremada", 1200)
        );

        List<ProductEntity> products2 = Arrays.asList(
                new ProductEntity(3, 1, "Arroz", "Arroz largo", 1800)
        );

        orders.add(new OrderEntity(1, products1, "PENDIENTE"));
        orders.add(new OrderEntity(2, products2, "ENVIADO"));
    }

    public List<OrderEntity> getAll() {
        return orders;
    }

    public void save(OrderEntity order) {
        order.setId(orders.size() + 1);
        orders.add(order);
    }

    public void replace(OrderEntity found, OrderEntity replacement) {
        int index = orders.indexOf(found);
        replacement.setId(found.getId());
        orders.set(index, replacement);
    }

    public void delete(OrderEntity found) {
        orders.remove(found);
    }

    public OrderEntity getById(int id) {
        for (OrderEntity order : orders) {
            if (order.getId() == id) {
                return order;
            }
        }
        return null;
    }
}
