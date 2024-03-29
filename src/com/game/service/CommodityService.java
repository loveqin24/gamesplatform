package com.game.service;

import java.util.List;

import com.game.page.Page;
import com.game.page.Result;
import com.game.po.Commodity;
import com.game.po.CommodityClass;

public interface CommodityService {
	public void addCommodity(Commodity commodity);//保存商品
	public Result findAllCommodity(Page page);//分页查询商品
	public void deleteCommodity(int commodityID);//按ID删除商品
	public List<Commodity> queryByRegTime(int num);//按提交时间倒序查找
	public Commodity queryByCommodityID(int commodityID);//按ID查找商品
	public Result queryByCommodityClass(CommodityClass commodityClass,Page page);
}
