package com.jojoldu.book.springboot.domain.Entity;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class ESL {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tag_id;

    @Column
    private Long seat_no;

    @Column
    private String menuName;

    @Column
    private String menuCost;

    @Column
    private String openTime;

    @Column
    private String closeTime;


    public ESL(Long tag_id,Long seat_no,String menuName,String menuCost,String openTime,String closeTime){
        this.tag_id=tag_id;
        this.seat_no=seat_no;
        this.menuName=menuName;
        this.menuCost=menuCost;
        this.openTime=openTime;
        this.closeTime=closeTime;
    }
}
