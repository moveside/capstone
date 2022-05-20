package moveside.web.dto;


import lombok.Getter;
import moveside.domain.Entity.ESL;

@Getter
public class EslListResponseDto {
    private Long id;
    private String menuName;
    private String menuCost;
    private String openTime;
    private String closeTime;

    public EslListResponseDto(ESL entity){
        this.id=entity.getId();
        this.menuName=entity.getMenuName();
        this.menuCost=entity.getMenuCost();
        this.openTime=entity.getOpenTime();
        this.closeTime=entity.getCloseTime();


    }

}
