package cl.duoc.daibarram.ecomarketstoreservice.service.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Store {
    private int id;
    private String name;
    private String address;
    private String phone;
    private boolean active;

    public Store(int id, String name, String address, String phone, boolean active) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.active = active;
    }
}
