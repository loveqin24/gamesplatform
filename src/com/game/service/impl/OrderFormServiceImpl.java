package com.game.service.impl;

import java.util.List;

import com.game.dao.impl.OrderFormDAO;
import com.game.po.OrderForm;
import com.game.service.OrderFormService;
import com.game.util.Order;

public class OrderFormServiceImpl implements OrderFormService {
	private OrderFormDAO orderFormDAO;
	
	public OrderFormDAO getOrderFormDAO() {
		return orderFormDAO;
	}

	public void setOrderFormDAO(OrderFormDAO orderFormDAO) {
		this.orderFormDAO = orderFormDAO;
	}

	@Override
	public Integer countAll() {
		return orderFormDAO.countAll();
	}

	@Override
	public List<OrderForm> findAll(Integer page, Integer pageNumber, Order order) {
		return orderFormDAO.findAll(page, pageNumber, order);
	}

	@Override
	public OrderForm findByOrderFormid(Integer orderFormId) {
		return orderFormDAO.findByOrderFormid(orderFormId);
	}

	@Override
	public void update(OrderForm orderform) {
		orderFormDAO.update(orderform);
	}

	@Override
	public void insert(OrderForm orderform) {
		orderFormDAO.insert(orderform);
	}

	@Override
	public void delete(OrderForm orderform) {
		orderFormDAO.delete(orderform);
	}

}
