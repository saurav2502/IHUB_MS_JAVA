package com.ms.ihub.order.Service;

import com.ms.ihub.Common.IhubException;
import com.ms.ihub.order.vo.IhubOrderVO;

import java.util.List;

public interface IIhubOrderManageService {
    List<IhubOrderVO> createNewOrder(IhubOrderVO ihubOrderVO) throws IhubException;

    List<IhubOrderVO> findOrderByDomain(IhubOrderVO vo) throws IhubException;

    IhubOrderVO findOrderByIoaId(Long ioaId);
}
