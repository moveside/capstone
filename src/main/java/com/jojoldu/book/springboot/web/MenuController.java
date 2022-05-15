package com.jojoldu.book.springboot.web;


import com.jojoldu.book.springboot.service.MenuService;
import com.jojoldu.book.springboot.web.dto.MenuSaveRequestDto;
import com.jojoldu.book.springboot.web.dto.MenuUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class MenuController {
    private final MenuService menuService;

    @PostMapping("/api/v1/menu")
    public Long save(@RequestBody MenuSaveRequestDto menuSaveRequestDto) {
        return menuService.save(menuSaveRequestDto);
    }
    @PutMapping("/api/v1/menu/{id}")
    public Long update(@PathVariable Long id, @RequestBody MenuUpdateRequestDto menuUpdateRequestDto) {
        return menuService.update(id,menuUpdateRequestDto);
    }
}
