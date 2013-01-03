package com.game.dao.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.MatchMode;

import com.game.po.OrderList;
import com.game.util.HibernateSessionFactory;
import com.game.util.Order;

public class OrderListDAO extends BaseHibernateDAO{

    public OrderListDAO() {
    }

    public void insert(OrderList orderlist){
        HibernateSessionFactory.getSession().save(orderlist);
        try {
			HibernateSessionFactory.getSession().connection().commit();
			HibernateSessionFactory.closeSession();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }

    public void update(OrderList orderlist){
        HibernateSessionFactory.getSession().saveOrUpdate(orderlist);
        try {
			HibernateSessionFactory.getSession().connection().commit();
			HibernateSessionFactory.closeSession();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public void delete(OrderList orderlist){
        HibernateSessionFactory.getSession().delete(orderlist);
        try {
			HibernateSessionFactory.getSession().connection().commit();
			HibernateSessionFactory.closeSession();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public OrderList findByOrderListid(java.lang.Integer orderlistid){
        OrderList orderlist = (OrderList) HibernateSessionFactory.getSession().get("OrderList", orderlistid);
        return orderlist;
    }

    public List<OrderList> findAll(){
        String hql = "from OrderList" ;
        Query query = HibernateSessionFactory.getSession().createQuery(hql);
        return query.list();
    }

    public List<OrderList> findAll(Integer pageFrom, Integer pageNumber, Order order){
        Query query = HibernateSessionFactory.getSession().createQuery("from OrderList model " + order.toSQLString())
                     .setFirstResult((pageFrom-1)*pageNumber)
                     .setMaxResults(pageNumber);     
        return query.list();
    }

    public Integer countAll(){
        String hql = "select count(m) from OrderList m";
        return ((Number)HibernateSessionFactory.getSession()
    	        .createQuery(hql)
    	        .uniqueResult()).intValue();
    }

    public List<OrderList> findByExample(OrderList orderlist){
        List results = HibernateSessionFactory.getSession().createCriteria("OrderList")
                .add(Example.create(orderlist))
                .list();
        return results;
    }

    public List<OrderList> findByExampleEx(OrderList orderlist){
        List results = HibernateSessionFactory.getSession().createCriteria("OrderList")
                .add(Example.create(orderlist).enableLike(MatchMode.ANYWHERE))
                .list();
        return results;
    }

    public List<OrderList> findByExample(OrderList orderlist, Integer pageFrom, Integer pageNumber){
        List results = HibernateSessionFactory.getSession().createCriteria("OrderList")
                .add(Example.create(orderlist))
                .setFirstResult((pageFrom - 1) * pageNumber)
                .setMaxResults(pageNumber)
                .list();
        return results;
    }

    public int countByExample(OrderList orderlist, Integer pageFrom, Integer pageNumber){
        return ((Number)HibernateSessionFactory.getSession().createCriteria("OrderList")
                .add(Example.create(orderlist))
                .setProjection(Projections.rowCount())
                .uniqueResult()).intValue();
    }

    public List<OrderList> findByExampleEx(OrderList orderlist, Integer pageFrom, Integer pageNumber){
        List results = HibernateSessionFactory.getSession().createCriteria("OrderList")
                .add(Example.create(orderlist).enableLike(MatchMode.ANYWHERE))
                .setFirstResult((pageFrom - 1) * pageNumber)
                .setMaxResults(pageNumber)
                .list();
        return results;
    }

    public int countByExampleEx(OrderList orderlist, Integer pageFrom, Integer pageNumber){
        return ((Number)HibernateSessionFactory.getSession().createCriteria("OrderList")
                .add(Example.create(orderlist).enableLike(MatchMode.ANYWHERE))
                .setProjection(Projections.rowCount())
                .uniqueResult()).intValue();
    }

    public List<OrderList> findByProperty(String name, Object value){
        String hql = "from OrderList as model where model." + name + "= ?";
        Query query = HibernateSessionFactory.getSession().createQuery(hql);
        query.setParameter(0, value);
        return query.list();
    }

    public Integer countByProperty(String name, Object value){
        String hql = "select count(model) from OrderList as model where model." + name + "= ?";
        return ((Number)HibernateSessionFactory.getSession().createQuery(hql)
                .setParameter(0, value)
                .uniqueResult()).intValue();
    }

    public List<OrderList> findByProperty(String name, Object value, Integer pageFrom, Integer pageNumber){
        String hql = "from OrderList as model where model." + name + "= ?";
        List results = HibernateSessionFactory.getSession().createQuery(hql)
                .setParameter(0, value)
                .setFirstResult((pageFrom - 1) * pageNumber)
                .setMaxResults(pageNumber)
                .list();
        return results;
    }

    public List<OrderList> findByAmount(java.lang.Integer amount, Integer pageFrom, Integer pageNumber, Order order){
        Query query = HibernateSessionFactory.getSession().createQuery("from OrderList model where model.amount=? " + (order==null?"":order.toSQLString()))
                     .setParameter(0, amount)
                     .setFirstResult((pageFrom-1)*pageNumber)
                     .setMaxResults(pageNumber);     
        return query.list();
    }

    public Integer countByAmount(java.lang.Integer amount){
        String hql = "select count(model) from OrderList model where model.amount=?";
        return ((Number)HibernateSessionFactory.getSession()
               .createQuery(hql)
               .setParameter(0, amount)
               .uniqueResult()).intValue();
    }

    public List<OrderList> findByAmount(java.lang.Integer amount){
        String hql = "from OrderList model where model.amount=? ";
        Query query = HibernateSessionFactory.getSession().createQuery(hql)
                     .setParameter(0, amount);
        return query.list();
    }
}
