package moveside.web.dto;


import lombok.Getter;
import moveside.domain.Entity.ESL;

@Getter
public class EslListResponseDto {
    private Long id;
    private String openTime;


    private String closeTime;

    private String breakTime1;

    private String breakTime2;

    private String exp;


    private String menuName1;

    private String menuName2;


    private String menuCost1;

    private String menuCost2;


    public EslListResponseDto(ESL entity){
        this.id=entity.getId();
        this.openTime=entity.getOpenTime();
        this.closeTime=entity.getCloseTime();
        this.breakTime1=entity.getBreakTime1();
        this.breakTime2= entity.getBreakTime2();
        this.exp=entity.getExp();
        this.menuName1=entity.getMenuName1();
        this.menuName2=entity.getMenuName2();
        this.menuCost1=entity.getMenuCost1();
        this.menuCost2=entity.getMenuCost2();
    }

}
