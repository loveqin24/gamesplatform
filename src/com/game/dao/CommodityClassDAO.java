package com.game.dao;

import java.util.List;

import com.game.page.Page;
import com.game.po.CommodityClass;

public interface CommodityClassDAO {
	public void save(CommodityClass commodityclass);//������Ʒ����
	public List<CommodityClass> findAll(Page page);//��ҳ��ѯ���е���Ʒ����
	public int findAllCount();//��ѯ���м�¼��
	public List<CommodityClass> findAll();//��ѯ���е���Ʒ����
	public CommodityClass findByID(int commodityClassID);
	public void delete(Integer commodityClassID);
}
