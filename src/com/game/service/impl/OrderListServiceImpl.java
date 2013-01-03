package com.game.service.impl;

import java.util.List;

import com.game.dao.impl.OrderListDAO;
import com.game.po.OrderList;
import com.game.service.OrderListService;
import com.game.util.Order;

public class OrderListServiceImpl implements OrderListService {
	private OrderListDAO orderListDAO;

	public OrderListDAO getOrderListDAO() {
		return orderListDAO;
	}

	public void setOrderListDAO(OrderListDAO orderListDAO) {
		this.orderListDAO = orderListDAO;
	}

	@Override
	public Integer countAll() {
		return orderListDAO.countAll();
	}

	@Override
	public List<OrderList> findAll(Integer page, Integer pageNumber, Order order) {
		return orderListDAO.findAll(page, pageNumber, order);
	}

	@Override
	public OrderList findByOrderListid(Integer orderListId) {
		return orderListDAO.findByOrderListid(orderListId);
	}

	@Override
	public void update(OrderList orderlist) {
		orderListDAO.update(orderlist);
	}

	@Override
	public void insert(OrderList orderlist) {
		orderListDAO.insert(orderlist);
	}

	@Override
	public void delete(OrderList orderlist) {
		orderListDAO.delete(orderlist);
	}

}
