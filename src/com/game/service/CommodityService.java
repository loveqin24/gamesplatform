package com.game.service;

import java.util.List;

import com.game.page.Page;
import com.game.page.Result;
import com.game.po.Commodity;
import com.game.po.CommodityClass;

public interface CommodityService {
	public void addCommodity(Commodity commodity);//������Ʒ
	public Result findAllCommodity(Page page);//��ҳ��ѯ��Ʒ
	public void deleteCommodity(int commodityID);//��IDɾ����Ʒ
	public List<Commodity> queryByRegTime(int num);//���ύʱ�䵹�����
	public Commodity queryByCommodityID(int commodityID);//��ID������Ʒ
	public Result queryByCommodityClass(CommodityClass commodityClass,Page page);
}
