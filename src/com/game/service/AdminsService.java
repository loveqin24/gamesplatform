package com.game.service;

import java.util.List;

import com.game.page.Page;
import com.game.page.Result;
import com.game.po.Admin;
import com.game.util.Order;

public interface AdminsService {
	public void addAdmin(Admin Admin);//������Ʒ����
	//public Result findAllAdmin(Page page);//��ҳ��ѯ��Ʒ����
	public List<Admin> findAllAdmin();//��ѯ������Ʒ����
	public Admin queryByID(int AdminID);
	public void deleteAdmin(Admin Admin);//��IDɾ����Ʒ
	public Admin queryByID(Admin Admin);
	public Integer countAll();
	public List<Admin> findAll(Integer page, Integer pageNumber, Order desc);
	public void update(Admin admin);
}
