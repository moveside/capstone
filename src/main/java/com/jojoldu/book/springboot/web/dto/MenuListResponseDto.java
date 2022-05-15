package com.jojoldu.book.springboot.web.dto;


import com.jojoldu.book.springboot.domain.Entity.Menu;
import lombok.Getter;

@Getter
public class MenuListResponseDto {
    private Long id;
    private String name;
    private Integer price;
    private String info;

    private String store;
    public MenuListResponseDto(Menu entity){
        this.id= entity.getId();
        this.name=entity.getName();
        this.price=entity.getPrice();
        this.info= entity.getInfo();
        this.store=entity.getStore();
    }
}
