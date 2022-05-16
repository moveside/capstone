package moveside.service;


import moveside.domain.Entity.Menu;
import moveside.domain.Repository.MenuRepository;
import moveside.web.dto.MenuListResponseDto;
import moveside.web.dto.MenuSaveRequestDto;
import moveside.web.dto.MenuUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MenuService {
    private final MenuRepository menuRepository;

    @Transactional
    public Long save(MenuSaveRequestDto menuSaveRequestDto){
        return menuRepository.save(menuSaveRequestDto.toEntity()).getId();
    }
    public Long update(Long id, MenuUpdateRequestDto menuUpdateRequestDto) {
        Menu menu = menuRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 음식이 존재하지 않음"));

        menu.update(menuUpdateRequestDto.getName(), menuUpdateRequestDto.getPrice(), menuUpdateRequestDto.getInfo(),menuUpdateRequestDto.getStore());

        return id;
    }
    public List<MenuListResponseDto> findAllDesc(String Store) {
        return menuRepository.findAllDesc(Store).stream().map(MenuListResponseDto::new).collect(Collectors.toList());
    }
}
