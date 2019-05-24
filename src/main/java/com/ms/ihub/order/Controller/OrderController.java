package com.ms.ihub.order.Controller;

import com.ms.ihub.order.Service.IIhubOrderManageService;
import com.ms.ihub.order.vo.IhubOrderVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<IhubOrderVO> findOrderByDomain(@RequestPart IhubOrderVO vo){
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
}
