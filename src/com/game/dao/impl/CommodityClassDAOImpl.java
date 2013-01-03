package com.game.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


import com.game.dao.CommodityClassDAO;
import com.game.page.Page;
import com.game.po.Commodity;
import com.game.po.CommodityClass;
import com.game.util.HibernateSessionFactory;

public class CommodityClassDAOImpl extends HibernateDaoSupport  implements CommodityClassDAO{
	
	
	public List<CommodityClass> findAll(Page page) {
		Query queryObject = null;
		try {
			queryObject = HibernateSessionFactory.getSession().createQuery(
					"from CommodityClass");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		// Session session = HibernateSessionFactory.getSession(); //���session����
		// Query query = session.createQuery("from CommodityClass");//ִ�в�ѯ
		// query.setFirstResult(page.getBeginIndex()); //���ò�ѯ���λ��
		// query.setMaxResults(page.getEveryPage()); //���ò�ѯ���ֵ
		return queryObject.list(); // ���ز�ѯ���
	}
	public void save(CommodityClass commodityclass) {
		//getHibernateTemplate().save(commodityclass);//����ʵ��
		Session  session  = null;
        try {
            session = HibernateSessionFactory.getSession();
            session.save(commodityclass);
            session.beginTransaction().commit();
            if(session!=null){
                  session.close();
            }
        } catch (RuntimeException e) {
            session.beginTransaction().rollback();
            if(session!=null){
                  session.close();
            }
            throw e;
        }
	}
	
	public int findAllCount() {
		List<CommodityClass> commodityClasses  = 
				HibernateSessionFactory.getSession().createQuery("from CommodityClass").list();//��ѯ���м�¼
		return commodityClasses .size();//���ؼ�¼��
	}
	public List<CommodityClass> findAll() {
		return HibernateSessionFactory.getSession().createQuery("from CommodityClass").list();
	}
	public CommodityClass findByID(int commodityClassID) {
		//return (CommodityClass)getHibernateTemplate().load(CommodityClass.class, commodityClassID);
		CommodityClass  instance  = null;
		try {
              instance  = (CommodityClass) HibernateSessionFactory.getSession().get(CommodityClass.class,commodityClassID);
            
        } catch (Exception e) {
            //throw e;
        }
		return instance;
	}
	@Override
	public void delete(Integer commodityClassID) {
		Session session = HibernateSessionFactory.getSession();
		CommodityClass  commodityClass  = (CommodityClass)session.get(CommodityClass.class, commodityClassID);//���ض���
		session.delete(commodityClass);//ɾ������
		session.beginTransaction().commit();
		HibernateSessionFactory.closeSession();
	}
	

}
