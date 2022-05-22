package moveside.web.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import moveside.domain.Entity.ESL;

import javax.persistence.Column;

@Getter
@NoArgsConstructor
public class EslSaveDto {

    private String openTime;


    private String closeTime;

    private String breakTime1;

    private String breakTime2;

    private String exp;


    private String menuName1;

    private String menuName2;


    private String menuCost1;

    private String menuCost2;


    @Builder
    public EslSaveDto (String openTime,String closeTime,String breakTime1,String breakTime2,String exp,String menuName1,String menuName2,String menuCost1,String menuCost2) {
        this.openTime=openTime;
        this.closeTime=closeTime;
        this.breakTime1=breakTime1;
        this.breakTime2=breakTime2;
        this.exp=exp;
        this.menuName1=menuName1;
        this.menuName2=menuName2;
        this.menuCost1=menuCost1;
        this.menuCost2=menuCost2;
    }

    public void update (String openTime,String closeTime,String breakTime1,String breakTime2,String exp,String menuName1,String menuName2,String menuCost1,String menuCost2) {
        this.openTime=openTime;
        this.closeTime=closeTime;
        this.breakTime1=breakTime1;
        this.breakTime2=breakTime2;
        this.exp=exp;
        this.menuName1=menuName1;
        this.menuName2=menuName2;
        this.menuCost1=menuCost1;
        this.menuCost2=menuCost2;
    }
}
