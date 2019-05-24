package com.ms.ihub.order.Service.Impl;

import com.ms.ihub.Common.IhubException;
import com.ms.ihub.order.Service.IIhubOrderManageService;
import com.ms.ihub.order.dao.IIhubOrderDao;
import com.ms.ihub.order.vo.IhubOrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IhubOrderMangeServiceImpl implements IIhubOrderManageService {

    @Autowired
    private IIhubOrderDao orderDao;

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
}
