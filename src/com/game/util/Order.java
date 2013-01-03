package com.game.util;

import java.util.ArrayList;
import java.util.List;

public class Order {
	
	private String asc = "";
	private String desc = "";
	private List<Order> orders = new ArrayList<Order>();
	
	private Order(){
	}
	
	public String toSQLString(){
		StringBuilder sb = new StringBuilder("order by ");
		if(asc.length() > 1){
			sb.append(asc).append(" asc,");
		}else{
			sb.append(desc).append(" desc,");
		}
		
		for(Order order : orders){
			if(order.asc.length() > 1){
				sb.append(order.asc).append(" asc,");
			}else{
				sb.append(order.desc).append(" desc,");
			}
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}
	
	public Order add(Order order){
		orders.add(order);
		return this;
	}
	
	public static Order asc(String propertyName){
		Order order = new Order();
		order.asc = propertyName;
		return order;
	}
	
	public static Order desc(String propertyName){
		Order order = new Order();
		order.desc = propertyName;
		return order;
	}
//	public static void main(String[] args) {
//		Order order = Order.asc("username").add(Order.desc("password"));
//		System.out.println(order.toSQLString());
//	}
}
