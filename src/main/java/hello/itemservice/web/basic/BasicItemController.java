package hello.itemservice.web.basic;

import hello.itemservice.domain.item.Item;
import hello.itemservice.domain.item.ItemRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/basic/items")
@RequiredArgsConstructor
public class BasicItemController {

    private final ItemRepository itemRepository;

    @GetMapping
    public String items(Model model){
        List<Item> all = itemRepository.findAll();
        model.addAttribute("items",all);
        return "basic/items";
    }


    @GetMapping("/{itemId}")
    public String item(@PathVariable long itemId,Model model){
        Item findItem = itemRepository.findById(itemId);
        model.addAttribute("item",findItem);
        return "basic/item";
    }

    @GetMapping("/add")
    public String addForm(){

        return "basic/addForm";
    }
//    @PostMapping("/add")
    public String addItemV1(@RequestParam("itemName")String itemName,
                       int price,
                       Integer quantity,
                       Model model){
        Item item = new Item();
        item.setQuantity(quantity);
        item.setPrice(price);
        item.setItemName(itemName);

        Item save = itemRepository.save(item);

        model.addAttribute("item",save);

        return "basic/addForm";
    }
//    @PostMapping("/add")
    public String addItemV2(@ModelAttribute("item2") Item item,
                       Model model){
        itemRepository.save(item);
//        model.addAttribute("item",item); // LINE :: 자동 추가, 생략 가능
        return "basic/addForm";
    }
//    @PostMapping("/add")
    public String addItemV3(@ModelAttribute Item item2,
                       Model model){
        itemRepository.save(item2);
//        model.addAttribute("item",item); // LINE :: 자동 추가, 생략 가능
        return "basic/addForm";
    }
    @PostMapping("/add")
    public String addItemV4(Item item2,
                       Model model){
        itemRepository.save(item2);
//        model.addAttribute("item",item); // LINE :: 자동 추가, 생략 가능
        return "basic/item";
    }

    /**
     * 테스트용 데이터 추가
     */
    @PostConstruct
    public void init(){
        itemRepository.save(new Item("itemA",10000,10));
        itemRepository.save(new Item("itemB",20000,20));
    }



}
