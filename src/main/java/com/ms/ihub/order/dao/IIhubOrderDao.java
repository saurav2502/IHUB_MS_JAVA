package com.ms.ihub.order.dao;

import com.ms.ihub.order.vo.IhubOrderVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface IIhubOrderDao {
    List<IhubOrderVO> createNewOrder(@Param("ihubOrderVO") IhubOrderVO ihubOrderVO);

    List<IhubOrderVO> findOrderByDomain(@Param("vo") IhubOrderVO vo);

    IhubOrderVO findOrderByIoaId(@Param("ioaId") Long ioaId);

    List<Map<String, String>> findlookUpData(@Param("code") int classifyCode);

    int createihubOrder(IhubOrderVO orderVO);
}
