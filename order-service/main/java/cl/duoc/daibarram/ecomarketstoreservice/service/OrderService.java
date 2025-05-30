package cl.duoc.daibarram.ecomarketstoreservice.service;

import cl.duoc.daibarram.ecomarketstoreservice.repository.OrderRepository;
import cl.duoc.daibarram.ecomarketstoreservice.repository.entity.OrderEntity;
import cl.duoc.daibarram.ecomarketstoreservice.service.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getOrders() {
        List<OrderEntity> orders = orderRepository.getAll();
        List<Order> orderList = new ArrayList<>();
        for (OrderEntity orderEntity : orders) {
            orderList.add(
                    new Order(
                            orderEntity.getId(),
                            orderEntity.getProducts(),
                            orderEntity.getStatus()
                    ));
        }
        return orderList;
    }

    public Order getOrderById(int id) {
        List<Order> orders = getOrders();
        for (Order order : orders) {
            if (order.getId() == id) {
                return order;
            }
        }
        return null;
    }

    public boolean saveOrder(Order order) {
        OrderEntity orderEntity = orderRepository.getById(order.getId());
        if (orderEntity == null) {
            orderRepository.save(
                    new OrderEntity(
                            order.getId(),
                            order.getProducts(),
                            order.getStatus()
                    ));
            return true;
        }
        return false;
    }

    public boolean replaceOrder(int id, Order newOrder) {
        OrderEntity found = null;
        List<OrderEntity> orders = orderRepository.getAll();
        for (OrderEntity order : orders) {
            if (order.getId() == id) {
                found = order;
            }
        }
        if (found != null) {
            orderRepository.replace(
                    found,
                    new OrderEntity(
                            newOrder.getId(),
                            newOrder.getProducts(),
                            newOrder.getStatus()
                    ));
            return true;
        }
        return false;
    }

    public boolean deleteOrder(int id) {
        OrderEntity found = null;
        List<OrderEntity> orders = orderRepository.getAll();
        for (OrderEntity order : orders) {
            if (order.getId() == id) {
                found = order;
            }
        }
        if (found != null) {
            orderRepository.delete(found);
            return true;
        }
        return false;
    }

}
