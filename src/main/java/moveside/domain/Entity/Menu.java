package moveside.domain.Entity;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Integer price;

    @Column
    private String info;

    @Column
    private String store;

    @Builder
    public Menu(String name,Integer price,String info,String store) {
        this.name = name;
        this.price = price;
        this.info = info;
        this.store=store;
    }
    public void update(String name,Integer price,String info,String store){
        this.name = name;
        this.price = price;
        this.info = info;
        this.store=store;
    }
}
