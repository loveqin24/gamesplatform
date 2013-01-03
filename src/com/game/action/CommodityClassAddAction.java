package com.game.action;

import com.game.service.CommodityClassService;
import com.opensymphony.xwork2.ActionSupport;
import com.game.po.CommodityClass;

public class CommodityClassAddAction extends ActionSupport {
	private String commodityClassName;		//��Ʒ��������
	private CommodityClassService commodityClassService;//ҵ���߼���

	public void setCommodityClassName(String commodityClassName) {
		this.commodityClassName = commodityClassName;
	}

	public void setCommodityClassService(CommodityClassService commodityClassService) {
		this.commodityClassService = commodityClassService;
	}

	public String execute() throws Exception {
		CommodityClass commodityClass = new CommodityClass();//�½���Ʒ�������
		commodityClass.setCommodityClassName(commodityClassName);//������Ʒ��������
		commodityClassService.addCommodityClass(commodityClass);//������Ʒ����
		return SUCCESS;
	}
}
