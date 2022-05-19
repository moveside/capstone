package moveside.service;


import moveside.domain.Entity.Store;
import moveside.domain.Repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StoreService {

    private final StoreRepository storeRepository;

    public List<String> findAllCode() {
        return storeRepository.findAllCode();
    }

    public Store findStore(String code) { return storeRepository.findCode(code); }
}