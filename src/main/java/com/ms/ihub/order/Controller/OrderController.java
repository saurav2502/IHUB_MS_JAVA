package com.ms.ihub.order.Controller;

import com.ms.ihub.order.Service.IIhubOrderManageService;
import com.ms.ihub.order.vo.IhubOrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private IIhubOrderManageService ihubOrderManageService;

    @PostMapping("/create")
    public List<IhubOrderVO> createOrder(@RequestBody  IhubOrderVO ihubOrderVO) {
        List<IhubOrderVO> voList = null;
        try{
            voList = ihubOrderManageService.createNewOrder(ihubOrderVO);
        } catch (Exception e){
            e.printStackTrace();
        }
        return voList;
    }
    
    @GetMapping("/findOrderByDomain")
    public List<IhubOrderVO> findOrderByDomain(IhubOrderVO vo){
        List<IhubOrderVO> orderVOS = null;
        try{
            orderVOS = ihubOrderManageService.findOrderByDomain(vo);
        } catch (Exception e){
            e.printStackTrace();
        }
        return orderVOS;
    }
    @GetMapping("newOrder/{ioaId}")
    public IhubOrderVO findOrderByIoaId(@PathVariable Long ioaId){
        return ihubOrderManageService.findOrderByIoaId(ioaId);
    }

    @GetMapping("/findlookup/{classifyCode}")
    List<Map<String,String>> findlookup(@PathVariable("classifyCode") int classifyCode){
        List<Map<String,String>> lookupMap = null;
        try{
            lookupMap = ihubOrderManageService.findlookUpData(classifyCode);
        } catch (Exception e){
            e.printStackTrace();
        }
        return lookupMap;
    }

    @GetMapping("/map")
    Map<String, Integer> findmap(){
        final Map<String, Integer> map = new HashMap<>();
        map.put("mercedez", 123);
        map.put("Toyota", 1234);
        map.put("Mahindra", 12345);
        map.put("Hundai", 123456);
        map.put("Suzuki", 1234567);
        for (Map.Entry<String,Integer> data: map.entrySet())
        {
            if (data.getKey().contains("mercedez")){
                data.setValue(1235677789);
            }
            else {
                continue;
            }
        }
        return map;
    }
}
