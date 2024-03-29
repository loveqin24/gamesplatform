package com.game.action;

import java.util.List;

import com.game.page.Page;
import com.game.page.Result;
import com.game.service.CommodityClassService;
import com.opensymphony.xwork2.ActionSupport;
import com.game.po.CommodityClass;

public class CommodityClassListAction extends ActionSupport{
	private CommodityClassService commodityClassService;//业务逻辑层
	private int currentPage;			//当前页
	private Page page;					//分页信息
	private List<CommodityClass> commodityClasses;//商品种类列表
	public List<CommodityClass> getCommodityClasses() {
		return commodityClasses;
	}
	public void setCommodityClassService(CommodityClassService commodityClassService) {
		this.commodityClassService = commodityClassService;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
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
	public void setCommodityClasses(List<CommodityClass> commodityClasses) {
		this.commodityClasses = commodityClasses;
	}
	public String execute() throws Exception {
		Page newPage = new Page();				//设置分页信息
		newPage.setCurrentPage(currentPage);	//设置当前页
		newPage.setEveryPage(10);				//设置每页显示
		Result result = commodityClassService.findAllCommodityClass(newPage);//获取查询结果
		page = result.getPage();		//获取分页信息
		commodityClasses = result.getList();	//获取商品信息列表
		return SUCCESS;
	}
}
