package moveside.service;

import moveside.domain.Entity.ESL;
import moveside.domain.Repository.EslRepository;
import lombok.RequiredArgsConstructor;
import moveside.web.dto.EslListResponseDto;
import moveside.web.dto.EslSaveDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional
public class EslService {
    private final EslRepository eslRepository;


    public Long update(Long id, EslSaveDto eslSaveDto) {
        ESL esl = eslRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("esl 접근 오류"));

        esl.update(esl.getOpenTime(),esl.getCloseTime(),esl.getBreakTime1(),esl.getBreakTime2(),esl.getExp(),esl.getMenuName1(),esl.getMenuName2(),esl.getMenuCost1(),esl.getMenuCost2());

        return id;
    }

    public List<EslListResponseDto> findAllESL() {
        return eslRepository.findAll().stream().map(EslListResponseDto::new).collect(Collectors.toList());
    }
}
