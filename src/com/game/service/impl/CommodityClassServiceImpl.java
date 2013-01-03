package com.game.service.impl;

import java.util.List;

import com.game.dao.CommodityClassDAO;
import com.game.page.Page;
import com.game.page.PageUtil;
import com.game.page.Result;
import com.game.po.CommodityClass;
import com.game.service.CommodityClassService;

public class CommodityClassServiceImpl implements CommodityClassService{
	private CommodityClassDAO commodityClassDAO;//注入数据访问层
	public void setCommodityClassDAO(CommodityClassDAO commodityClassDAO) {
		this.commodityClassDAO = commodityClassDAO;//设置数据访问层
	}
	public void addCommodityClass(CommodityClass commodityClass) {
		commodityClassDAO.save(commodityClass);//完成数据保存
	}
	public Result findAllCommodityClass(Page page) {
		page = PageUtil.createPage(page, 
				commodityClassDAO.findAllCount());	//创建分页对象
		List<CommodityClass> commodityClasses
				= commodityClassDAO.findAll(page);	//执行查询
		Result result = new Result();	//创建结果对象
		result.setPage(page);			//设置分页信息
		result.setList(commodityClasses);//设置商品种类列表
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
