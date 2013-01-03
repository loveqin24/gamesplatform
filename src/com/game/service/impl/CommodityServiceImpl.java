package com.game.service.impl;

import java.util.List;

import com.game.dao.CommodityDAO;
import com.game.page.Page;
import com.game.page.PageUtil;
import com.game.page.Result;
import com.game.po.Commodity;
import com.game.po.CommodityClass;
import com.game.service.CommodityService;

public class CommodityServiceImpl implements CommodityService{
	private CommodityDAO commodityDAO;//ע�����ݷ��ʲ�
	public void setCommodityDAO(CommodityDAO commodityDAO) {
		this.commodityDAO = commodityDAO;//�������ݷ��ʲ�
	}
	public void addCommodity(Commodity commodity) {
		commodityDAO.save(commodity);//������ݱ���
	}
	public Result findAllCommodity(Page page) {
		page = PageUtil.createPage(page, 
				commodityDAO.findAllCount());	//������ҳ����
		List<Commodity> commodityes
				= commodityDAO.findAll(page);	//ִ�в�ѯ
		Result result = new Result();	//�����������
		result.setPage(page);			//���÷�ҳ��Ϣ
		result.setList(commodityes);//������Ʒ�����б�
		return result;
	}
	public void deleteCommodity(int commodityID) {
		commodityDAO.delete(commodityID);
	}
	public List<Commodity> queryByRegTime(int num) {
		return commodityDAO.findByTime(num);
	}
	public Commodity queryByCommodityID(int commodityID) {
		return commodityDAO.findByID(commodityID);
	}
	public Result queryByCommodityClass(CommodityClass commodityClass, Page page) {
		page = PageUtil.createPage(page, 
				commodityDAO.findAllCount(commodityClass));	//������ҳ����
		List<Commodity> commodityes
				= commodityDAO.findByClass(commodityClass, page);	//ִ�в�ѯ
		Result result = new Result();	//�����������
		result.setPage(page);			//���÷�ҳ��Ϣ
		result.setList(commodityes);//������Ʒ�����б�
		return result;
	}
}
