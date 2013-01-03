package com.game.service;

import java.util.List;

import com.game.page.Page;
import com.game.page.Result;
import com.game.po.Admin;
import com.game.util.Order;

public interface AdminsService {
	public void addAdmin(Admin Admin);//保存商品种类
	//public Result findAllAdmin(Page page);//分页查询商品种类
	public List<Admin> findAllAdmin();//查询所有商品种类
	public Admin queryByID(int AdminID);
	public void deleteAdmin(Admin Admin);//按ID删除商品
	public Admin queryByID(Admin Admin);
	public Integer countAll();
	public List<Admin> findAll(Integer page, Integer pageNumber, Order desc);
	public void update(Admin admin);
}
