package cl.duoc.daibarram.ecomarketstoreservice.repository;

import cl.duoc.daibarram.ecomarketstoreservice.repository.entity.StoreEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StoreRepository {

    List<StoreEntity> stores;

    public StoreRepository() {
        stores = new ArrayList<>();
        stores.add(new StoreEntity(1, "Store 1", "Address 1", "Phone 1", true));
        stores.add(new StoreEntity(2, "Store 2", "Address 2", "Phone 2", true));
        stores.add(new StoreEntity(3, "Store 3", "Address 3", "Phone 3", true));
        stores.add(new StoreEntity(4, "Store 4", "Address 4", "Phone 4", true));
    }

    public List<StoreEntity> getAll() {
        return stores;
    }

    public void save(StoreEntity store) {
        store.setId(stores.size() + 1);
        stores.add(store);
    }

    public void replace(StoreEntity found, StoreEntity replacement) {
        int index = stores.indexOf(found);
        replacement.setId(found.getId());
        stores.set(index, replacement);
    }

    public void delete(StoreEntity found) {
        stores.remove(found);
    }

    public StoreEntity getByNameOrAddress(String name, String address) {
        for (StoreEntity store : stores) {
            if (store.getName().equals(name) || store.getAddress().equals(address)) {
                return store;
            }
        }
        return null;
    }
}
