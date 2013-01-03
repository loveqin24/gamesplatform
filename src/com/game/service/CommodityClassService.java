package com.game.service;

import java.util.List;

import com.game.page.Page;
import com.game.page.Result;
import com.game.po.CommodityClass;

public interface CommodityClassService {
	public void addCommodityClass(CommodityClass commodityClass);//������Ʒ����
	public Result findAllCommodityClass(Page page);//��ҳ��ѯ��Ʒ����
	public List<CommodityClass> findAllCommodityClass();//��ѯ������Ʒ����
	public CommodityClass queryByID(int commodityClassID);
	public void deleteCommodityClassID(Integer commodityClassID);
}
