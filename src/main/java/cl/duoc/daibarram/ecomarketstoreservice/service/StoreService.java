package cl.duoc.daibarram.ecomarketstoreservice.service;

import cl.duoc.daibarram.ecomarketstoreservice.repository.StoreRepository;
import cl.duoc.daibarram.ecomarketstoreservice.repository.entity.StoreEntity;
import cl.duoc.daibarram.ecomarketstoreservice.service.domain.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;

    public List<Store> getStores() {
        List<StoreEntity> stores = storeRepository.getAll();
        List<Store> storeList = new ArrayList<>();
        for (StoreEntity storeEntity : stores) {
            storeList.add(
                    new Store(
                        storeEntity.getId(),
                        storeEntity.getName(),
                        storeEntity.getAddress(),
                        storeEntity.getPhone(),
                        storeEntity.isActive()
                    ));
        }
        return storeList;
    }

    public Store getStoreById(int id) {
        List<Store> stores = getStores();
        for (Store store : stores) {
            if (store.getId() == id) {
                return store;
            }
        }
        return null;
    }

    public boolean saveStore(Store store) {
        StoreEntity storeEntity = storeRepository.getByNameOrAddress(store.getName(), store.getAddress());
        if (storeEntity == null) {
            storeRepository.save(
                    new StoreEntity(
                        store.getId(),
                        store.getName(),
                        store.getAddress(),
                        store.getPhone(),
                        store.isActive()
                    ));
            return true;
        }
        return false;
    }

    public boolean replaceStore(int id, Store newStore) {
        StoreEntity found = null;
        List<StoreEntity> stores = storeRepository.getAll();
        for (StoreEntity store : stores) {
            if (store.getId() == id) {
                found = store;
            }
        }
        if (found != null) {
            storeRepository.replace(
                    found,
                    new StoreEntity(
                        newStore.getId(),
                        newStore.getName(),
                        newStore.getAddress(),
                        newStore.getPhone(),
                        newStore.isActive()
            ));
            return true;
        }
        return false;
    }

    public boolean deleteStore(int id) {
        StoreEntity found = null;
        List<StoreEntity> stores = storeRepository.getAll();
        for (StoreEntity store : stores) {
            if (store.getId() == id) {
                found = store;
            }
        }
        if (found != null) {
            storeRepository.delete(found);
            return true;
        }
        return false;
    }
}
