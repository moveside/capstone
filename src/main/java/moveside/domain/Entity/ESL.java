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
    private String menuName;

    @Column
    private String menuCost;

    @Column
    private String openTime;

    @Column
    private String closeTime;

    @Builder
    public ESL(Long id,String menuName,String menuCost,String openTime,String closeTime){
        this.id=id;
        this.menuName=menuName;
        this.menuCost=menuCost;
        this.openTime=openTime;
        this.closeTime=closeTime;
    }

    public void update(String menuName,String menuCost,String openTime,String closeTime){
        this.menuName=menuName;
        this.menuCost=menuCost;
        this.openTime=openTime;
        this.closeTime=closeTime;
    }
}
