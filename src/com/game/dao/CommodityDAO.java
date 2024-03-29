package com.game.dao;

import java.util.List;

import com.game.page.Page;
import com.game.po.Commodity;
import com.game.po.CommodityClass;

public interface CommodityDAO {
	public void save(Commodity commodity);//保存商品信息
	public List<Commodity> findAll(Page page);//分页查询所有的商品
	public int findAllCount();//查询所有记录数
	public void delete(int commodityID);//删除商品信息
	public List<Commodity> findByTime(int num);//按时间倒序查找
	public Commodity findByID(int commodityID);//按ID查找
	public List<Commodity> findByClass(CommodityClass commodityClass,Page page);
	public int findAllCount(CommodityClass commodityClass);//查询分类记录数
}
