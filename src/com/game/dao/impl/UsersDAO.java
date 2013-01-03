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
import org.hibernate.criterion.Restrictions;

import com.game.page.Page;
import com.game.po.User;
import com.game.util.HibernateSessionFactory;
import com.game.util.Order;



public class UsersDAO extends BaseHibernateDAO{

    public UsersDAO() {
    }

    public void insert(User User){
    	Session session = null;
		 try {
			 	session = HibernateSessionFactory.getSession();
			 	session.save(User);
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

    public void update(User User){
    	Session session = null;
		 try {
			 	session = HibernateSessionFactory.getSession();
			 	session.saveOrUpdate(User);
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

    public void delete(User User){
    	Session session = null;
		 try {
			 	session = HibernateSessionFactory.getSession();
			 	session.delete(User);
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

    public User findByUserid(java.lang.Integer userid){
//    	String hql = "select * from User model  where  model.userid={1}";
//        User User = (User) HibernateSessionFactory.getSession().createQuery(hql).setInteger(1, userid).uniqueResult();//.get("User", userid);
    	List<User> list = findAll();
    	User user = new User();
    	for (User u : list) {
			if (u.getUserId().equals(userid))
			{
				user =u;
				break;
			}
		}
        return user;
    }

    public List<User> findAll(){
        String hql = "from User " ;
        Query query = HibernateSessionFactory.getSession().createQuery(hql);
        return query.list();
    }

    public List<User> findAll(Integer pageFrom, Integer pageNumber, Order order){
        Query query = HibernateSessionFactory.getSession().createQuery("from User model " + order.toSQLString())
                     .setFirstResult((pageFrom-1)*pageNumber)
                     .setMaxResults(pageNumber);     
        return query.list();
    }

    public Integer countAll(){
        String hql = "select count(m) from User m";
        return ((Number)HibernateSessionFactory.getSession()
    	        .createQuery(hql)
    	        .uniqueResult()).intValue();
    }

    public List<User> findByExample(User User){
        List results = HibernateSessionFactory.getSession().createCriteria("User")
                .add(Example.create(User))
                .list();
        return results;
    }

    public List<User> findByExampleEx(User User){
        List results = HibernateSessionFactory.getSession().createCriteria("User")
                .add(Example.create(User).enableLike(MatchMode.ANYWHERE))
                .list();
        return results;
    }

    public List<User> findByExample(User User, Integer pageFrom, Integer pageNumber){
        List results = HibernateSessionFactory.getSession().createCriteria("User")
                .add(Example.create(User))
                .setFirstResult((pageFrom - 1) * pageNumber)
                .setMaxResults(pageNumber)
                .list();
        return results;
    }

    public int countByExample(User User, Integer pageFrom, Integer pageNumber){
        return ((Number)HibernateSessionFactory.getSession().createCriteria("User")
                .add(Example.create(User))
                .setProjection(Projections.rowCount())
                .uniqueResult()).intValue();
    }

    public List<User> findByExampleEx(User User, Integer pageFrom, Integer pageNumber){
        List results = HibernateSessionFactory.getSession().createCriteria("User")
                .add(Example.create(User).enableLike(MatchMode.ANYWHERE))
                .setFirstResult((pageFrom - 1) * pageNumber)
                .setMaxResults(pageNumber)
                .list();
        return results;
    }

    public int countByExampleEx(User User, Integer pageFrom, Integer pageNumber){
        return ((Number)HibernateSessionFactory.getSession().createCriteria("User")
                .add(Example.create(User).enableLike(MatchMode.ANYWHERE))
                .setProjection(Projections.rowCount())
                .uniqueResult()).intValue();
    }

    public List<User> findByProperty(String name, Object value){
        String hql = "from User as model where model." + name + "= ?";
        Query query = HibernateSessionFactory.getSession().createQuery(hql);
        query.setParameter(0, value);
        return query.list();
    }

    public Integer countByProperty(String name, Object value){
        String hql = "select count(model) from User as model where model." + name + "= ?";
        return ((Number)HibernateSessionFactory.getSession().createQuery(hql)
                .setParameter(0, value)
                .uniqueResult()).intValue();
    }

    public List<User> findByProperty(String name, Object value, Integer pageFrom, Integer pageNumber){
        String hql = "from User as model where model." + name + "= ?";
        List results = HibernateSessionFactory.getSession().createQuery(hql)
                .setParameter(0, value)
                .setFirstResult((pageFrom - 1) * pageNumber)
                .setMaxResults(pageNumber)
                .list();
        return results;
    }

    public List<User> findByUsername(java.lang.String username, Integer pageFrom, Integer pageNumber, Order order){
        Query query = HibernateSessionFactory.getSession().createQuery("from User model where model.username like ? " + (order==null?"":order.toSQLString()))
                     .setString(0, "%" + username + "%")
                     .setFirstResult((pageFrom-1)*pageNumber)
                     .setMaxResults(pageNumber);     
        return query.list();
    }

    public Integer countByUsername(java.lang.String username){
        String hql = "select count(model) from User model where model.username like ?";
        return ((Number)HibernateSessionFactory.getSession()
               .createQuery(hql)
               .setString(0, "%" + username + "%")
               .uniqueResult()).intValue();
    }

    public List<User> findByUsername(java.lang.String username){
        String hql = "from User model where model.username like ? ";
        Query query = HibernateSessionFactory.getSession().createQuery(hql)
                     .setString(0, "%" + username + "%");
        return query.list();
    }

    public List<User> findByPassword(java.lang.String password, Integer pageFrom, Integer pageNumber, Order order){
        Query query = HibernateSessionFactory.getSession().createQuery("from User model where model.password like ? " + (order==null?"":order.toSQLString()))
                     .setString(0, "%" + password + "%")
                     .setFirstResult((pageFrom-1)*pageNumber)
                     .setMaxResults(pageNumber);     
        return query.list();
    }

    public Integer countByPassword(java.lang.String password){
        String hql = "select count(model) from User model where model.password like ?";
        return ((Number)HibernateSessionFactory.getSession()
               .createQuery(hql)
               .setString(0, "%" + password + "%")
               .uniqueResult()).intValue();
    }

    public List<User> findByPassword(java.lang.String password){
        String hql = "from User model where model.password like ? ";
        Query query = HibernateSessionFactory.getSession().createQuery(hql)
                     .setString(0, "%" + password + "%");
        return query.list();
    }

	public List<User> findAll(Page page) {
		Session session = HibernateSessionFactory.getSession();		//获得session对象
		Query query = session.createQuery("from User");//执行查询
		query.setFirstResult(page.getBeginIndex());	//设置查询起点位置
		query.setMaxResults(page.getEveryPage());	//设置查询最大值
		return query.list();		//返回查询结果
	}

//	public int countAll(User user) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	public List<User> findByTime(int num) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	
}

