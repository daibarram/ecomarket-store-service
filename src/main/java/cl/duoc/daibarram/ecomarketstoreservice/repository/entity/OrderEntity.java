package cl.duoc.daibarram.ecomarketstoreservice.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity {
    private int id;
    private List<ProductEntity> products;
    private double total;
    private double subtotal;
    private double iva;
    private String status;
}
