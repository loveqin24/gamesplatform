package com.game.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.game.po.OrderList;
import com.game.service.OrderListService;
import com.game.util.Order;
import com.opensymphony.xwork2.ActionSupport;


public class OrderListAction extends ActionSupport {
	public static final Integer PAGE_NUMBER = 20;
	public OrderListService orderlistService;
	List<OrderList> orderlists = new ArrayList<OrderList>();
	OrderList orderlist = new OrderList();
	
	public OrderListService getOrderlistService() {
		return orderlistService;
	}

	public void setOrderlistService(OrderListService orderlistService) {
		this.orderlistService = orderlistService;
	}

	public List<OrderList> getOrderlists() {
		return orderlists;
	}

	public void setOrderlists(List<OrderList> orderlists) {
		this.orderlists = orderlists;
	}

	public OrderList getOrderlist() {
		return orderlist;
	}

	public void setOrderlist(OrderList orderlist) {
		this.orderlist = orderlist;
	}

	java.lang.Integer[] ids ;	
	Integer page = 1;
	Integer totals = 1;
	
	@SkipValidation
	public String list(){		
		
		Integer records = orderlistService.countAll();
		
		totals = records/PAGE_NUMBER + (records%PAGE_NUMBER == 0?0:1);
		totals = totals < 1 ? 1 : totals;
		page = (page < 1)? page : (page > totals ? totals : page);
		
		orderlists = orderlistService.findAll(page, PAGE_NUMBER, Order.desc("orderlistid"));
		return "success";
	}
	
	@SkipValidation
	public String preedit(){
		orderlist = orderlistService.findByOrderListid(orderlist.getOrderListId());
        
		return "edit";
	}
	
	@SkipValidation
	public String showcar(){
		
		
		return "showcar";
	}
	
	@SkipValidation
	public String detail(){
		
		orderlist = orderlistService.findByOrderListid(orderlist.getOrderListId());
		
		return "detail";
	}
	
	public String edit(){		
		
		orderlistService.update(orderlist);
		return "list";
	}
	
	@SkipValidation
	public String preinsert(){
        
		return "insert";
	}
	
	public String insert(){		
		
		orderlistService.insert(orderlist);
		return "list";
	}
	
	@SkipValidation
	public String delete(){
		
		orderlistService.delete(orderlist);
		return "list";
	}
	
	@SkipValidation
	public String deleteAll(){
		if(ids == null || ids.length <= 0)
			return "list";
		
		
		for(java.lang.Integer id : ids){
			OrderList model = orderlistService.findByOrderListid(id);
			if(model != null){
				orderlistService.delete(orderlist);
			}
		}
		return "list";
	}

	public List<OrderList> getOrderLists() {
		return orderlists;
	}

	public void setOrderLists(List<OrderList> orderlists) {
		this.orderlists = orderlists;
	}

	public OrderList getOrderList() {
		return orderlist;
	}

	public void setOrderList(OrderList orderlist) {
		this.orderlist = orderlist;
	}

	public java.lang.Integer[] getIds() {
		return ids;
	}

	public void setIds(java.lang.Integer[] ids) {
		this.ids = ids;
	}

	

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getTotals() {
		return totals;
	}

	public void setTotals(Integer totals) {
		this.totals = totals;
	}
}
