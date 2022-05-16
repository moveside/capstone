package moveside.web.dto;


import moveside.domain.Entity.Menu;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MenuSaveRequestDto {
    private String name;
    private Integer price;

    private String info;
    @Builder
    public MenuSaveRequestDto(String name,Integer price,String info){
        this.name = name;
        this.price = price;
        this.info=info;
    }
    public Menu toEntity() {
        return Menu.builder().name(name).price(price).info(info).build();
    }
}
