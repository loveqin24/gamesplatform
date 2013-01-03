package com.game.action;

import java.util.List;

import com.game.page.Page;
import com.game.page.Result;
import com.game.service.CommodityClassService;
import com.game.service.CommodityService;
import com.opensymphony.xwork2.ActionSupport;
import com.game.po.Commodity;
import com.game.po.CommodityClass;

public class ShowByClass extends ActionSupport{	//根据商品种类分页显示商品
	private int commodityClassID;
	private int currentPage;
	private Page page;					//分页信息
	private CommodityService commodityService;//业务逻辑层
	private List<Commodity> commodities;// 商品信息列表
	private CommodityClassService commodityClassService;// 业务逻辑层
	private List<CommodityClass> commodityClasses;// 商品种类列表
	private CommodityClass commodityClass;
	public int getCommodityClassID() {
		return commodityClassID;
	}
	public void setCommodityClassID(int commodityClassID) {
		this.commodityClassID = commodityClassID;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public CommodityService getCommodityService() {
		return commodityService;
	}
	public void setCommodityService(CommodityService commodityService) {
		this.commodityService = commodityService;
	}
	public List<Commodity> getCommodities() {
		return commodities;
	}
	public void setCommodities(List<Commodity> commodities) {
		this.commodities = commodities;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public CommodityClassService getCommodityClassService() {
		return commodityClassService;
	}
	public void setCommodityClassService(CommodityClassService commodityClassService) {
		this.commodityClassService = commodityClassService;
	}
	public List<CommodityClass> getCommodityClasses() {
		return commodityClasses;
	}
	public void setCommodityClasses(List<CommodityClass> commodityClasses) {
		this.commodityClasses = commodityClasses;
	}
	public CommodityClass getCommodityClass() {
		return commodityClass;
	}
	public void setCommodityClass(CommodityClass commodityClass) {
		this.commodityClass = commodityClass;
	}
	public String execute() throws Exception {
		commodityClasses = commodityClassService.findAllCommodityClass();// 查询所有的商品种类
		commodityClass = commodityClassService.queryByID(commodityClassID);
		Page newPage = new Page();				//设置分页信息
		newPage.setCurrentPage(currentPage);	//设置当前页
		newPage.setEveryPage(9);				//设置每页显示
		Result result = commodityService.
			queryByCommodityClass(commodityClass, newPage);//获取查询结果
		page = result.getPage();		//获取分页信息
		commodities = result.getList();	//获取商品信息列表
		return SUCCESS;
	}
}
