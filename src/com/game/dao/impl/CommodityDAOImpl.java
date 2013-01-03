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
		Session session = HibernateSessionFactory.getSession();		//���session����
		Query query = session.createQuery("from Commodity");//ִ�в�ѯ
		query.setFirstResult(page.getBeginIndex());	//���ò�ѯ���λ��
		query.setMaxResults(page.getEveryPage());	//���ò�ѯ���ֵ
		return query.list();		//���ز�ѯ���
	}
	public void save(Commodity commodity) {
		Session session = null;
		 try {
			 	session = HibernateSessionFactory.getSession();
			 	session.saveOrUpdate(commodity);//����ʵ��
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
				HibernateSessionFactory.getSession().createQuery("from Commodity").list();//��ѯ���м�¼
		return commodities.size();//���ؼ�¼��
	}
	public void delete(int commodityID) {	//ɾ����Ʒ��Ϣ
		Session session = HibernateSessionFactory.getSession();		//���session����
		Commodity commodity = (Commodity)session.get(Commodity.class, commodityID);//���ض���
		session.delete(commodity);//ɾ������
		session.beginTransaction().commit();
		HibernateSessionFactory.closeSession();
	}
	public List<Commodity> findByTime(int num) {
		Session session = HibernateSessionFactory.getSession();;		//���session����
		Query query = session.createQuery
			("from Commodity order by regTime desc");//ִ�в�ѯ
		query.setFirstResult(0);	//���ò�ѯ���λ��
		query.setMaxResults(num);	//���ò�ѯ���ֵ
		return query.list();		//���ز�ѯ���
	}
	public Commodity findByID(int commodityID) {
		return (Commodity)HibernateSessionFactory.getSession().get(Commodity.class, commodityID);
	}
	public List<Commodity> findByClass(CommodityClass commodityClass, Page page) {
		Session session = HibernateSessionFactory.getSession();		//���session����
		Query query = session.createQuery("from Commodity where commodityClass =:commodityClass");//ִ�в�ѯ
		query.setEntity("commodityClass", commodityClass);
		query.setFirstResult(page.getBeginIndex());	//���ò�ѯ���λ��
		query.setMaxResults(page.getEveryPage());	//���ò�ѯ���ֵ
		return query.list();		//���ز�ѯ���
	}
	public int findAllCount(CommodityClass commodityClass) {
		Session session = HibernateSessionFactory.getSession();		//���session����
		Query query = session.createQuery("from Commodity where commodityClass =:commodityClass");//ִ�в�ѯ
		query.setEntity("commodityClass", commodityClass);
		return query.list().size();//���ؼ�¼��
	}
}
