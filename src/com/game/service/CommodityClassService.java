package com.game.service;

import java.util.List;

import com.game.page.Page;
import com.game.page.Result;
import com.game.po.CommodityClass;

public interface CommodityClassService {
	public void addCommodityClass(CommodityClass commodityClass);//保存商品种类
	public Result findAllCommodityClass(Page page);//分页查询商品种类
	public List<CommodityClass> findAllCommodityClass();//查询所有商品种类
	public CommodityClass queryByID(int commodityClassID);
	public void deleteCommodityClassID(Integer commodityClassID);
}
