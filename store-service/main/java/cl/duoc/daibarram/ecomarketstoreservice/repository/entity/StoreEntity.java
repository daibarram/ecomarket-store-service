package cl.duoc.daibarram.ecomarketstoreservice.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StoreEntity {
    private int id;
    private String name;
    private String address;
    private String phone;
    private boolean active;
}
