package com.ms.ihub.order.Service.Impl;

import com.ms.ihub.Common.IhubException;
import com.ms.ihub.Constant.IhubConstantService;
import com.ms.ihub.order.Service.IIhubOrderManageService;
import com.ms.ihub.order.dao.IIhubOrderDao;
import com.ms.ihub.order.vo.IhubOrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IhubOrderMangeServiceImpl implements IIhubOrderManageService {

    @Autowired
    private IIhubOrderDao orderDao;

    @Autowired
    private IhubConstantService ihubConstantService;

    @Override
    public List<IhubOrderVO> createNewOrder(IhubOrderVO ihubOrderVO) throws IhubException {
        List<IhubOrderVO> vos = null;
        vos = orderDao.createNewOrder(ihubOrderVO);
        return vos;
    }

    @Override
    public List<IhubOrderVO> findOrderByDomain(IhubOrderVO vo) {
        return orderDao.findOrderByDomain(vo);
    }

    @Override
    public IhubOrderVO findOrderByIoaId(Long ioaId) {
        return orderDao.findOrderByIoaId(ioaId);
    }

    @Override
    public List<Map<String, String>> findlookUpData(int classifyCode) {
        final String succ = "Success";
        final String code = "0";
        final String error = "Error";
        final String errcode = "1";
        List<Map<String, String>> map = null;
        try{
            map = orderDao.findlookUpData(classifyCode);
        }catch (Exception e){
            e.printStackTrace();
        }
//        for (Map<String, String> ite: map){
//            for (Map.Entry<String, String> finalmap : ite.entrySet()){
//                finalmap.setValue(succ);
//            }
//        }
        return map;
    }

    @Override
    public Map<String, String> createihubOrder(IhubOrderVO orderVO) throws IhubException{
        Map<String, String> retmap = new HashMap<String, String>();
        int count=0;
        try{
            count = orderDao.createihubOrder(orderVO);
        }catch (Exception e){
            e.printStackTrace();
        }
        if (count>0){
            retmap.put(ihubConstantService.RetCode, String.valueOf(orderVO.getOrderId()));
            retmap.put(ihubConstantService.Result, ihubConstantService.Success);
        }else {
            retmap.put(ihubConstantService.RetCode, "1");
            retmap.put(ihubConstantService.ERR, ihubConstantService.Failure);
        }
        return retmap;
    }
}
