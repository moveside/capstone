package moveside.service;

import moveside.domain.Repository.EslRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EslService {
    private final EslRepository eslRepository;


}
