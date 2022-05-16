package moveside.web.dto;


import moveside.domain.Entity.Store;
import lombok.Getter;

@Getter
public class StoreLoginDto {



    private Long id;
    private String code;
    private String name;

    public StoreLoginDto(Store entity){
        this.id= entity.getId();
        this.code= entity.getCode();
        this.name= entity.getName();
    }




}
