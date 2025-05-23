package cl.duoc.daibarram.ecomarketstoreservice.service;

import cl.duoc.daibarram.ecomarketstoreservice.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;



}
