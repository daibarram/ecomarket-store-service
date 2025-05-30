package cl.duoc.daibarram.ecomarketstoreservice.service.domain;

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

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public boolean isActive() {
        return active;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
