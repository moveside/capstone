package moveside.web.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import moveside.domain.Entity.ESL;

import javax.persistence.Column;

@Getter
@NoArgsConstructor
public class EslSaveDto {

    private String menuName;
    private String menuCost;
    private String openTime;
    private String closeTime;

    public EslSaveDto (String menuName,String menuCost,String openTime,String closeTime) {
        this.menuName=menuName;
        this.menuCost=menuCost;
        this.openTime=openTime;
        this.closeTime=closeTime;
    }

    public ESL to_Entity() { return ESL.builder().menuName(menuName).menuCost(menuCost).openTime(openTime).closeTime(closeTime).build(); }
}
