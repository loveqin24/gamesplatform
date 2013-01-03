package com.game.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.game.dao.CommodityDAO;
import com.game.page.Page;
import com.game.po.Commodity;
import com.game.po.CommodityClass;
import com.game.util.HibernateSessionFactory;

public class CommodityDAOImpl  extends HibernateDaoSupport implements CommodityDAO{
	public List<Commodity> findAll(Page page) {
		Session session = HibernateSessionFactory.getSession();		//获得session对象
		Query query = session.createQuery("from Commodity");//执行查询
		query.setFirstResult(page.getBeginIndex());	//设置查询起点位置
		query.setMaxResults(page.getEveryPage());	//设置查询最大值
		return query.list();		//返回查询结果
	}
	public void save(Commodity commodity) {
		Session session = null;
		 try {
			 	session = HibernateSessionFactory.getSession();
			 	session.saveOrUpdate(commodity);//保存实体
			 	session.beginTransaction().commit();
			 	 if(session!=null){
	                  session.close();
	            }
			} catch (Exception e) {
				 session.beginTransaction().rollback();
		            if(session!=null){
		                  session.close();
		            }
		            System.out.println(e.getMessage());
			}
	}
	public int findAllCount() {
		List<CommodityClass> commodities  = 
				HibernateSessionFactory.getSession().createQuery("from Commodity").list();//查询所有记录
		return commodities.size();//返回记录数
	}
	public void delete(int commodityID) {	//删除商品信息
		Session session = HibernateSessionFactory.getSession();		//获得session对象
		Commodity commodity = (Commodity)session.get(Commodity.class, commodityID);//加载对象
		session.delete(commodity);//删除对象
		session.beginTransaction().commit();
		HibernateSessionFactory.closeSession();
	}
	public List<Commodity> findByTime(int num) {
		Session session = HibernateSessionFactory.getSession();;		//获得session对象
		Query query = session.createQuery
			("from Commodity order by regTime desc");//执行查询
		query.setFirstResult(0);	//设置查询起点位置
		query.setMaxResults(num);	//设置查询最大值
		return query.list();		//返回查询结果
	}
	public Commodity findByID(int commodityID) {
		return (Commodity)HibernateSessionFactory.getSession().get(Commodity.class, commodityID);
	}
	public List<Commodity> findByClass(CommodityClass commodityClass, Page page) {
		Session session = HibernateSessionFactory.getSession();		//获得session对象
		Query query = session.createQuery("from Commodity where commodityClass =:commodityClass");//执行查询
		query.setEntity("commodityClass", commodityClass);
		query.setFirstResult(page.getBeginIndex());	//设置查询起点位置
		query.setMaxResults(page.getEveryPage());	//设置查询最大值
		return query.list();		//返回查询结果
	}
	public int findAllCount(CommodityClass commodityClass) {
		Session session = HibernateSessionFactory.getSession();		//获得session对象
		Query query = session.createQuery("from Commodity where commodityClass =:commodityClass");//执行查询
		query.setEntity("commodityClass", commodityClass);
		return query.list().size();//返回记录数
	}
}
