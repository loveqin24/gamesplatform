package com.game.po;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class OrderForm implements java.io.Serializable {
	private Integer orderFormId;	//�������

	private Integer userId;
	private String orderFormNo;		//�������
	private Date submitTime;		//�ύ����ʱ��
	private Date consignmentTime;	//����ʱ��
	private Double totalPrice;		//�ܽ��
	private String remark;			//��ұ�ע
	private String ipaddress;		//���IP��ַ
	private Integer isPayoff;		//����Ƿ񸶿�
	private Integer isConsignment;	//�Ƿ񷢻�

	public OrderForm() {
	}

	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public OrderForm(Integer userId, String orderFormNo, Date submitTime,
			Date consignmentTime, Double totalPrice, String remark,
			String ipaddress, Integer isPayoff, Integer isConsignment) {
		//this.user = user;
		this.userId = userId;
		this.orderFormNo = orderFormNo;
		this.submitTime = submitTime;
		this.consignmentTime = consignmentTime;
		this.totalPrice = totalPrice;
		this.remark = remark;
		this.ipaddress = ipaddress;
		this.isPayoff = isPayoff;
		this.isConsignment = isConsignment;
	}

	public Integer getOrderFormId() {
		return this.orderFormId;
	}

	public void setOrderFormId(Integer orderFormId) {
		this.orderFormId = orderFormId;
	}



	public String getOrderFormNo() {
		return this.orderFormNo;
	}

	public void setOrderFormNo(String orderFormNo) {
		this.orderFormNo = orderFormNo;
	}

	public Date getSubmitTime() {
		return this.submitTime;
	}

	public void setSubmitTime(Date submitTime) {
		this.submitTime = submitTime;
	}

	public Date getConsignmentTime() {
		return this.consignmentTime;
	}

	public void setConsignmentTime(Date consignmentTime) {
		this.consignmentTime = consignmentTime;
	}

	public Double getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getIpaddress() {
		return this.ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

	public Integer getIsPayoff() {
		return this.isPayoff;
	}

	public void setIsPayoff(Integer isPayoff) {
		this.isPayoff = isPayoff;
	}

	public Integer getIsConsignment() {
		return this.isConsignment;
	}

	public void setIsConsignment(Integer isConsignment) {
		this.isConsignment = isConsignment;
	}

}