package hello.itemservice.domain.item;

import lombok.*;

@NoArgsConstructor
@Getter @Setter
public class Item {

    private Long id;
    private String itemName;
    private Integer price;
    private Integer quentity;

    public Item(String itemName, Integer price, Integer quentity) {
        this.itemName = itemName;
        this.price = price;
        this.quentity = quentity;
    }
}
