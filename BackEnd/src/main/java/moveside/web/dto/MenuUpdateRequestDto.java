package moveside.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MenuUpdateRequestDto {
    private String name;
    private Integer price;
    private String info;

    private String store;
    @Builder
    public MenuUpdateRequestDto(String name,Integer price,String info,String store){
        this.name = name;
        this.price = price;
        this.info = info;
        this.store = store;
    }
}
