package com.game.action;

import java.util.List;

import com.game.page.Page;
import com.game.page.Result;
import com.game.service.CommodityClassService;
import com.opensymphony.xwork2.ActionSupport;
import com.game.po.CommodityClass;

public class CommodityClassListAction extends ActionSupport{
	private CommodityClassService commodityClassService;//ҵ���߼���
	private int currentPage;			//��ǰҳ
	private Page page;					//��ҳ��Ϣ
	private List<CommodityClass> commodityClasses;//��Ʒ�����б�
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
		Page newPage = new Page();				//���÷�ҳ��Ϣ
		newPage.setCurrentPage(currentPage);	//���õ�ǰҳ
		newPage.setEveryPage(10);				//����ÿҳ��ʾ
		Result result = commodityClassService.findAllCommodityClass(newPage);//��ȡ��ѯ���
		page = result.getPage();		//��ȡ��ҳ��Ϣ
		commodityClasses = result.getList();	//��ȡ��Ʒ��Ϣ�б�
		return SUCCESS;
	}
}
