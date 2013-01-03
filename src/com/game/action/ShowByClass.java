package com.game.action;

import java.util.List;

import com.game.page.Page;
import com.game.page.Result;
import com.game.service.CommodityClassService;
import com.game.service.CommodityService;
import com.opensymphony.xwork2.ActionSupport;
import com.game.po.Commodity;
import com.game.po.CommodityClass;

public class ShowByClass extends ActionSupport{	//������Ʒ�����ҳ��ʾ��Ʒ
	private int commodityClassID;
	private int currentPage;
	private Page page;					//��ҳ��Ϣ
	private CommodityService commodityService;//ҵ���߼���
	private List<Commodity> commodities;// ��Ʒ��Ϣ�б�
	private CommodityClassService commodityClassService;// ҵ���߼���
	private List<CommodityClass> commodityClasses;// ��Ʒ�����б�
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
		commodityClasses = commodityClassService.findAllCommodityClass();// ��ѯ���е���Ʒ����
		commodityClass = commodityClassService.queryByID(commodityClassID);
		Page newPage = new Page();				//���÷�ҳ��Ϣ
		newPage.setCurrentPage(currentPage);	//���õ�ǰҳ
		newPage.setEveryPage(9);				//����ÿҳ��ʾ
		Result result = commodityService.
			queryByCommodityClass(commodityClass, newPage);//��ȡ��ѯ���
		page = result.getPage();		//��ȡ��ҳ��Ϣ
		commodities = result.getList();	//��ȡ��Ʒ��Ϣ�б�
		return SUCCESS;
	}
}
