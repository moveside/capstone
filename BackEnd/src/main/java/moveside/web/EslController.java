package moveside.web;


import lombok.RequiredArgsConstructor;
import moveside.service.EslService;
import moveside.web.dto.EslSaveDto;
import moveside.web.dto.MenuUpdateRequestDto;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
public class EslController {

    private final EslService eslService;
    @PutMapping("/api/v1/esl/{id}")
    public Long update(@PathVariable Long id, @RequestBody EslSaveDto eslSaveDto) {
        return eslService.update(id,eslSaveDto);
    }
}
