package com.game.service.impl;

import java.util.List;

import com.game.dao.CommodityClassDAO;
import com.game.page.Page;
import com.game.page.PageUtil;
import com.game.page.Result;
import com.game.po.CommodityClass;
import com.game.service.CommodityClassService;

public class CommodityClassServiceImpl implements CommodityClassService{
	private CommodityClassDAO commodityClassDAO;//ע�����ݷ��ʲ�
	public void setCommodityClassDAO(CommodityClassDAO commodityClassDAO) {
		this.commodityClassDAO = commodityClassDAO;//�������ݷ��ʲ�
	}
	public void addCommodityClass(CommodityClass commodityClass) {
		commodityClassDAO.save(commodityClass);//������ݱ���
	}
	public Result findAllCommodityClass(Page page) {
		page = PageUtil.createPage(page, 
				commodityClassDAO.findAllCount());	//������ҳ����
		List<CommodityClass> commodityClasses
				= commodityClassDAO.findAll(page);	//ִ�в�ѯ
		Result result = new Result();	//�����������
		result.setPage(page);			//���÷�ҳ��Ϣ
		result.setList(commodityClasses);//������Ʒ�����б�
		return result;
	}
	public List<CommodityClass> findAllCommodityClass() {
		return commodityClassDAO.findAll();
	}
	public CommodityClass queryByID(int commodityClassID) {
		return commodityClassDAO.findByID(commodityClassID);
	}
	@Override
	public void deleteCommodityClassID(Integer commodityClassID) {
		commodityClassDAO.delete(commodityClassID);
	}
}
