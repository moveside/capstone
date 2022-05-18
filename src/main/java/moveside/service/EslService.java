package moveside.service;

import moveside.domain.Entity.ESL;
import moveside.domain.Repository.EslRepository;
import lombok.RequiredArgsConstructor;
import moveside.web.dto.EslSaveDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class EslService {
    private final EslRepository eslRepository;


    public Long update(Long id, EslSaveDto eslSaveDto) {
        ESL esl = eslRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("esl 접근 오류"));

        esl.update(eslSaveDto.getMenuName(), eslSaveDto.getMenuCost(), eslSaveDto.getOpenTime(), eslSaveDto.getCloseTime());

        return id;
    }
}
