package com.game.service;

import java.util.List;

import com.game.po.OrderForm;
import com.game.util.Order;

public interface OrderFormService {

	Integer countAll();

	List<OrderForm> findAll(Integer page, Integer pageNumber, Order desc);

	OrderForm findByOrderFormid(Integer orderFormId);

	void update(OrderForm orderform);

	void insert(OrderForm orderform);

	void delete(OrderForm orderform);

}
