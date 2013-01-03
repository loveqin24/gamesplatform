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
	private CommodityDAO commodityDAO;//注入数据访问层
	public void setCommodityDAO(CommodityDAO commodityDAO) {
		this.commodityDAO = commodityDAO;//设置数据访问层
	}
	public void addCommodity(Commodity commodity) {
		commodityDAO.save(commodity);//完成数据保存
	}
	public Result findAllCommodity(Page page) {
		page = PageUtil.createPage(page, 
				commodityDAO.findAllCount());	//创建分页对象
		List<Commodity> commodityes
				= commodityDAO.findAll(page);	//执行查询
		Result result = new Result();	//创建结果对象
		result.setPage(page);			//设置分页信息
		result.setList(commodityes);//设置商品种类列表
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
				commodityDAO.findAllCount(commodityClass));	//创建分页对象
		List<Commodity> commodityes
				= commodityDAO.findByClass(commodityClass, page);	//执行查询
		Result result = new Result();	//创建结果对象
		result.setPage(page);			//设置分页信息
		result.setList(commodityes);//设置商品种类列表
		return result;
	}
}
