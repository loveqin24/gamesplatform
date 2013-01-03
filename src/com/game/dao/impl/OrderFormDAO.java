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

import com.game.po.OrderForm;
import com.game.util.HibernateSessionFactory;
import com.game.util.Order;

public class OrderFormDAO extends BaseHibernateDAO{

    public OrderFormDAO() {
    }

    public void insert(OrderForm orderform){
    	Session session = null;
		 try {
			 	session = HibernateSessionFactory.getSession();
			 	session.save(orderform);
       
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

    public void update(OrderForm orderform){
    	Session session = null;
		 try {
			 	session = HibernateSessionFactory.getSession();
			 	session.saveOrUpdate(orderform);
       
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

    public void delete(OrderForm orderform){
    	
    	Session session = null;
		 try {
			 	session = HibernateSessionFactory.getSession();
			 	session.delete(orderform);
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

    public OrderForm findByOrderFormid(java.lang.Integer orderformid){
        OrderForm orderform = new OrderForm();
        List<OrderForm> list = findAll();
        for (OrderForm o : list) {
			if (o.getOrderFormId().equals(orderformid))
			{
				orderform = o;
				break;
			}
		}
        return orderform;
    }

    public List<OrderForm> findAll(){
        String hql = "from OrderForm" ;
        Query query = HibernateSessionFactory.getSession().createQuery(hql);
        return query.list();
    }

    public List<OrderForm> findAll(Integer pageFrom, Integer pageNumber, Order order){
        Query query = HibernateSessionFactory.getSession().createQuery("from OrderForm model " + order.toSQLString())
                     .setFirstResult((pageFrom-1)*pageNumber)
                     .setMaxResults(pageNumber);     
        return query.list();
    }

    public Integer countAll(){
        String hql = "select count(m) from OrderForm m";
        return ((Number)HibernateSessionFactory.getSession()
    	        .createQuery(hql)
    	        .uniqueResult()).intValue();
    }

    public List<OrderForm> findByExample(OrderForm orderform){
        List results = HibernateSessionFactory.getSession().createCriteria("OrderForm")
                .add(Example.create(orderform))
                .list();
        return results;
    }

    public List<OrderForm> findByExampleEx(OrderForm orderform){
        List results = HibernateSessionFactory.getSession().createCriteria("OrderForm")
                .add(Example.create(orderform).enableLike(MatchMode.ANYWHERE))
                .list();
        return results;
    }

    public List<OrderForm> findByExample(OrderForm orderform, Integer pageFrom, Integer pageNumber){
        List results = HibernateSessionFactory.getSession().createCriteria("OrderForm")
                .add(Example.create(orderform))
                .setFirstResult((pageFrom - 1) * pageNumber)
                .setMaxResults(pageNumber)
                .list();
        return results;
    }

    public int countByExample(OrderForm orderform, Integer pageFrom, Integer pageNumber){
        return ((Number)HibernateSessionFactory.getSession().createCriteria("OrderForm")
                .add(Example.create(orderform))
                .setProjection(Projections.rowCount())
                .uniqueResult()).intValue();
    }

    public List<OrderForm> findByExampleEx(OrderForm orderform, Integer pageFrom, Integer pageNumber){
        List results = HibernateSessionFactory.getSession().createCriteria("OrderForm")
                .add(Example.create(orderform).enableLike(MatchMode.ANYWHERE))
                .setFirstResult((pageFrom - 1) * pageNumber)
                .setMaxResults(pageNumber)
                .list();
        return results;
    }

    public int countByExampleEx(OrderForm orderform, Integer pageFrom, Integer pageNumber){
        return ((Number)HibernateSessionFactory.getSession().createCriteria("OrderForm")
                .add(Example.create(orderform).enableLike(MatchMode.ANYWHERE))
                .setProjection(Projections.rowCount())
                .uniqueResult()).intValue();
    }

    public List<OrderForm> findByProperty(String name, Object value){
        String hql = "from OrderForm as model where model." + name + "= ?";
        Query query = HibernateSessionFactory.getSession().createQuery(hql);
        query.setParameter(0, value);
        return query.list();
    }

    public Integer countByProperty(String name, Object value){
        String hql = "select count(model) from OrderForm as model where model." + name + "= ?";
        return ((Number)HibernateSessionFactory.getSession().createQuery(hql)
                .setParameter(0, value)
                .uniqueResult()).intValue();
    }

    public List<OrderForm> findByProperty(String name, Object value, Integer pageFrom, Integer pageNumber){
        String hql = "from OrderForm as model where model." + name + "= ?";
        List results = HibernateSessionFactory.getSession().createQuery(hql)
                .setParameter(0, value)
                .setFirstResult((pageFrom - 1) * pageNumber)
                .setMaxResults(pageNumber)
                .list();
        return results;
    }

    public List<OrderForm> findByAmount(java.lang.Integer amount, Integer pageFrom, Integer pageNumber, Order order){
        Query query = HibernateSessionFactory.getSession().createQuery("from OrderForm model where model.amount=? " + (order==null?"":order.toSQLString()))
                     .setParameter(0, amount)
                     .setFirstResult((pageFrom-1)*pageNumber)
                     .setMaxResults(pageNumber);     
        return query.list();
    }

    public Integer countByAmount(java.lang.Integer amount){
        String hql = "select count(model) from OrderForm model where model.amount=?";
        return ((Number)HibernateSessionFactory.getSession()
               .createQuery(hql)
               .setParameter(0, amount)
               .uniqueResult()).intValue();
    }

    public List<OrderForm> findByAmount(java.lang.Integer amount){
        String hql = "from OrderForm model where model.amount=? ";
        Query query = HibernateSessionFactory.getSession().createQuery(hql)
                     .setParameter(0, amount);
        return query.list();
    }
}
