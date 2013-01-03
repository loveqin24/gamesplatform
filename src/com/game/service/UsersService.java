package com.game.service;

import java.util.List;
import com.game.po.User;
import com.game.util.Order;


public interface UsersService {
	public void addUser(User User);//
	//public Result findAllUser(Page page);//
	public List<User> findAllUser();// 
	public List<User> findAllUser(int page, int PAGE_NUMBER, Order order);// 
	public User queryByID(User User);
	public void deleteUser(User User);// 
	public Integer countAll();
	public User findByUserid(Integer userId);
	public void update(User user);
	public User findByUserName(String username,String password);
	
}
