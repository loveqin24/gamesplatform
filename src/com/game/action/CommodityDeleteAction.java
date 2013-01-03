package com.game.action;

import com.game.service.CommodityService;
import com.opensymphony.xwork2.ActionSupport;

public class CommodityDeleteAction extends ActionSupport{
	private Integer commodityID;//��Ʒ���
	private CommodityService commodityService;//��Ʒҵ���߼����

	public void setCommodityID(Integer commodityID) {
		this.commodityID = commodityID;
	}
	
	public void setCommodityService(CommodityService commodityService) {
		this.commodityService = commodityService;
	}

	public String execute() throws Exception {
		commodityService.deleteCommodity(commodityID);
		return SUCCESS;
	}
}
