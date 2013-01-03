package com.game.action;

import com.game.service.CommodityClassService;
import com.opensymphony.xwork2.ActionSupport;
import com.game.po.CommodityClass;

public class CommodityClassDeleteAction extends ActionSupport {
	private Integer commodityClassID;		//商品种类名称
	private CommodityClassService commodityClassService;//业务逻辑层


	public Integer getCommodityClassID() {
		return commodityClassID;
	}

	public void setCommodityClassID(Integer commodityClassID) {
		this.commodityClassID = commodityClassID;
	}

	public CommodityClassService getCommodityClassService() {
		return commodityClassService;
	}

	public void setCommodityClassService(CommodityClassService commodityClassService) {
		this.commodityClassService = commodityClassService;
	}

	public String execute() throws Exception {
		commodityClassService.deleteCommodityClassID(commodityClassID);
		return SUCCESS;
	}
}
