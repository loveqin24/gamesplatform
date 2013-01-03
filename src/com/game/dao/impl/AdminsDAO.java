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

import com.game.page.Page;
import com.game.page.PageUtil;
import com.game.page.Result;
import com.game.po.Admin;
import com.game.po.Commodity;
import com.game.util.HibernateSessionFactory;
import com.game.util.Order;



public class AdminsDAO extends BaseHibernateDAO{

    public AdminsDAO() {
    }

    public void insert(Admin Admin){
    	Session session = null;
        
        try {
        	session = HibernateSessionFactory.getSession();
        	session.save(Admin);
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

    public void update(Admin Admin){
        Session session = null;
        
        try {
        	session = HibernateSessionFactory.getSession();
        	session.update(Admin);
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

    public void delete(Admin Admin){
    	 Session session = null;
         
         try {
         	session = HibernateSessionFactory.getSession();
         	session.delete(Admin);
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

    public Admin findByAdminid(java.lang.Integer adminid){
        Admin Admin = (Admin) HibernateSessionFactory.getSession().get("Admin", adminid);
        return Admin;
    }

    public List<Admin> findAll(){
        String hql = "from Admin " ;
        Query query = HibernateSessionFactory.getSession().createQuery(hql);
        return query.list();
    }

    public List<Admin> findAll(Integer pageFrom, Integer pageNumber, Order order){
        Query query = HibernateSessionFactory.getSession().createQuery("from Admin model " + order.toSQLString())
                     .setFirstResult((pageFrom-1)*pageNumber)
                     .setMaxResults(pageNumber);     
        return query.list();
    }

    public Integer countAll(){
        String hql = "select count(m) from Admin m";
        return ((Number)HibernateSessionFactory.getSession()
    	        .createQuery(hql)
    	        .uniqueResult()).intValue();
    }

    public List<Admin> findByExample(Admin Admin){
        List results = HibernateSessionFactory.getSession().createCriteria("Admin")
                .add(Example.create(Admin))
                .list();
        return results;
    }

    public List<Admin> findByExampleEx(Admin Admin){
        List results = HibernateSessionFactory.getSession().createCriteria("Admin")
                .add(Example.create(Admin).enableLike(MatchMode.ANYWHERE))
                .list();
        return results;
    }

    public List<Admin> findByExample(Admin Admin, Integer pageFrom, Integer pageNumber){
        List results = HibernateSessionFactory.getSession().createCriteria("Admin")
                .add(Example.create(Admin))
                .setFirstResult((pageFrom - 1) * pageNumber)
                .setMaxResults(pageNumber)
                .list();
        return results;
    }

    public int countByExample(Admin Admin, Integer pageFrom, Integer pageNumber){
        return ((Number)HibernateSessionFactory.getSession().createCriteria("Admin")
                .add(Example.create(Admin))
                .setProjection(Projections.rowCount())
                .uniqueResult()).intValue();
    }

    public List<Admin> findByExampleEx(Admin Admin, Integer pageFrom, Integer pageNumber){
        List results = HibernateSessionFactory.getSession().createCriteria("Admin")
                .add(Example.create(Admin).enableLike(MatchMode.ANYWHERE))
                .setFirstResult((pageFrom - 1) * pageNumber)
                .setMaxResults(pageNumber)
                .list();
        return results;
    }

    public int countByExampleEx(Admin Admin, Integer pageFrom, Integer pageNumber){
        return ((Number)HibernateSessionFactory.getSession().createCriteria("Admin")
                .add(Example.create(Admin).enableLike(MatchMode.ANYWHERE))
                .setProjection(Projections.rowCount())
                .uniqueResult()).intValue();
    }

    public List<Admin> findByProperty(String name, Object value){
        String hql = "from Admin as model where model." + name + "= ?";
        Query query = HibernateSessionFactory.getSession().createQuery(hql);
        query.setParameter(0, value);
        return query.list();
    }

    public Integer countByProperty(String name, Object value){
        String hql = "select count(model) from Admin as model where model." + name + "= ?";
        return ((Number)HibernateSessionFactory.getSession().createQuery(hql)
                .setParameter(0, value)
                .uniqueResult()).intValue();
    }

    public List<Admin> findByProperty(String name, Object value, Integer pageFrom, Integer pageNumber){
        String hql = "from Admin as model where model." + name + "= ?";
        List results = HibernateSessionFactory.getSession().createQuery(hql)
                .setParameter(0, value)
                .setFirstResult((pageFrom - 1) * pageNumber)
                .setMaxResults(pageNumber)
                .list();
        return results;
    }

    public List<Admin> findByUsername(java.lang.String username, Integer pageFrom, Integer pageNumber, Order order){
        Query query = HibernateSessionFactory.getSession().createQuery("from Admin model where model.username like ? " + (order==null?"":order.toSQLString()))
                     .setString(0, "%" + username + "%")
                     .setFirstResult((pageFrom-1)*pageNumber)
                     .setMaxResults(pageNumber);     
        return query.list();
    }

    public Integer countByUsername(java.lang.String username){
        String hql = "select count(model) from Admin model where model.username like ?";
        return ((Number)HibernateSessionFactory.getSession()
               .createQuery(hql)
               .setString(0, "%" + username + "%")
               .uniqueResult()).intValue();
    }

    public List<Admin> findByUsername(java.lang.String username){
        String hql = "from Admin model where model.username like ? ";
        Query query = HibernateSessionFactory.getSession().createQuery(hql)
                     .setString(0, "%" + username + "%");
        return query.list();
    }

    public List<Admin> findByPassword(java.lang.String password, Integer pageFrom, Integer pageNumber, Order order){
        Query query = HibernateSessionFactory.getSession().createQuery("from Admin model where model.password like ? " + (order==null?"":order.toSQLString()))
                     .setString(0, "%" + password + "%")
                     .setFirstResult((pageFrom-1)*pageNumber)
                     .setMaxResults(pageNumber);     
        return query.list();
    }

    public Integer countByPassword(java.lang.String password){
        String hql = "select count(model) from Admin model where model.password like ?";
        return ((Number)HibernateSessionFactory.getSession()
               .createQuery(hql)
               .setString(0, "%" + password + "%")
               .uniqueResult()).intValue();
    }

    public List<Admin> findByPassword(java.lang.String password){
        String hql = "from Admin model where model.password like ? ";
        Query query = HibernateSessionFactory.getSession().createQuery(hql)
                     .setString(0, "%" + password + "%");
        return query.list();
    }

	public List<Admin> findAll(Page page) {
		Session session = HibernateSessionFactory.getSession();		//获得session对象
		Query query = session.createQuery("from Admin");//执行查询
		query.setFirstResult(page.getBeginIndex());	//设置查询起点位置
		query.setMaxResults(page.getEveryPage());	//设置查询最大值
		return query.list();		//返回查询结果
	}

	
}
