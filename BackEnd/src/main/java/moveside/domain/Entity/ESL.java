package moveside.domain.Entity;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class ESL {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String openTime;

    @Column
    private String closeTime;
    @Column
    private String breakTime1;
    @Column
    private String breakTime2;
    @Column
    private String exp;

    @Column
    private String menuName1;
    @Column
    private String menuName2;

    @Column
    private String menuCost1;
    @Column
    private String menuCost2;



    @Builder
    public ESL(Long id,String openTime,String closeTime,String breakTime1,String breakTime2,String explain,String menuName1,String menuName2,String menuCost1,String menuCost2){
        this.id=id;
        this.openTime=openTime;
        this.closeTime=closeTime;
        this.breakTime1=breakTime1;
        this.breakTime2=breakTime2;
        this.exp=explain;
        this.menuName1=menuName1;
        this.menuName2=menuName2;
        this.menuCost1=menuCost1;
        this.menuCost2=menuCost2;
    }

    public void update(String openTime,String closeTime,String breakTime1,String breakTime2,String explain,String menuName1,String menuName2,String menuCost1,String menuCost2){
        this.openTime=openTime;
        this.closeTime=closeTime;
        this.breakTime1=breakTime1;
        this.breakTime2=breakTime2;
        this.exp=explain;
        this.menuName1=menuName1;
        this.menuName2=menuName2;
        this.menuCost1=menuCost1;
        this.menuCost2=menuCost2;
    }
}
