package cl.duoc.daibarram.ecomarketstoreservice.controller;

import jakarta.validation.Valid;
import cl.duoc.daibarram.ecomarketstoreservice.controller.request.AddStoreRequest;
import cl.duoc.daibarram.ecomarketstoreservice.service.domain.Store;
import cl.duoc.daibarram.ecomarketstoreservice.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stores")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @GetMapping
    public List<Store> getStores() {
        return storeService.getStores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Store> getStore(@PathVariable int id) {
        Store found = storeService.getStoreById(id);
        if (found != null) {
            return ResponseEntity.ok(found);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Void> addStore(@Valid @RequestBody AddStoreRequest request) {
        Store store = new Store(0, request.getName(), request.getAddress(), request.getPhone(), true);
        boolean saved = storeService.saveStore(store);
        if (saved) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> replaceStore(@PathVariable int id, @RequestBody Store request) {
        boolean replaced = storeService.replaceStore(id, request);
        if (replaced) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStore(@PathVariable int id) {
        boolean deleted = storeService.deleteStore(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
