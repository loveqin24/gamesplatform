package com.game.service;

import java.util.List;

import com.game.po.OrderList;
import com.game.util.Order;

public interface OrderListService {

	Integer countAll();

	List<OrderList> findAll(Integer page, Integer pageNumber, Order desc);

	OrderList findByOrderListid(Integer orderListId);

	void update(OrderList orderlist);

	void insert(OrderList orderlist);

	void delete(OrderList orderlist);

}
