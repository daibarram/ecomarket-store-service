package cl.duoc.daibarram.ecomarketstoreservice.service;

import cl.duoc.daibarram.ecomarketstoreservice.repository.StoreRepository;
import cl.duoc.daibarram.ecomarketstoreservice.repository.entity.StoreEntity;
import org.apache.catalina.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

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

}
