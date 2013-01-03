package com.game.action;

import java.util.List;

import com.game.page.Page;
import com.game.page.Result;
import com.game.service.CommodityService;
import com.opensymphony.xwork2.ActionSupport;
import com.game.po.Commodity;

public class CommodityListAction extends ActionSupport{
	private CommodityService commodityService;//ҵ���߼���
	private List<Commodity> commodities;// ��Ʒ��Ϣ�б�
	private int currentPage;			//��ǰҳ
	private Page page;					//��ҳ��Ϣ
	
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

	public String execute() throws Exception {
		Page newPage = new Page();				//���÷�ҳ��Ϣ
		newPage.setCurrentPage(currentPage);	//���õ�ǰҳ
		newPage.setEveryPage(10);				//����ÿҳ��ʾ
		Result result = commodityService.findAllCommodity(newPage);//��ȡ��ѯ���
		page = result.getPage();		//��ȡ��ҳ��Ϣ
		commodities = result.getList();	//��ȡ��Ʒ��Ϣ�б�
		
		return SUCCESS;
	}
}
