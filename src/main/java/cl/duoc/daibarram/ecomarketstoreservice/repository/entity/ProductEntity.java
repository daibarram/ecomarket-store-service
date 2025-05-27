package cl.duoc.daibarram.ecomarketstoreservice.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ProductEntity {
    private int id;
    private int storeId;
    private String name;
    private String descripcion;
    private double price;
}


