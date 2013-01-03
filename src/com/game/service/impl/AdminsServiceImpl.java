package com.game.service.impl;

import java.util.List;

import com.game.dao.impl.AdminsDAO;
import com.game.page.Page;
import com.game.page.PageUtil;
import com.game.page.Result;
import com.game.po.Admin;
import com.game.po.User;
import com.game.service.AdminsService;
import com.game.util.Order;

public class AdminsServiceImpl implements AdminsService {
	private AdminsDAO adminsDAO;// 注入数据访问层
	List<Admin> admins;
	private Admin admin = new Admin();// 注入数据
	
	public Admin getAdmin() {
		return admin;
	}

	public List<Admin> getAdmins() {
		return admins;
	}

	public void setAdmins(List<Admin> admins) {
		this.admins = admins;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public AdminsDAO getAdminsDAO() {
		return adminsDAO;
	}

	public void setAdminsDAO(AdminsDAO adminsDAO) {
		this.adminsDAO = adminsDAO;// 设置数据访问层
	}

//	public AdminsServiceImpl(AdminsDAO adminsDAO, Admin admin) {
//		super();
//		this.adminsDAO = adminsDAO;
//		this.admin = admin;
//	}

	public void addAdmin(Admin admin) {
		adminsDAO.insert(admin);// 完成数据保存
	}

//	public Result findAllAdmin(Page page) {
//		page = PageUtil.createPage(page, adminsDAO.countAll()); // 创建分页对象
//		List<Admin> admines = adminsDAO.findAll(page); // 执行查询
//		Result result = new Result(); // 创建结果对象
//		result.setPage(page); // 设置分页信息
//		result.setList(admines);// 设置商品种类列表
//		return result;
//	}

	public void deleteAdmin(Admin admin) {
		adminsDAO.delete(admin);
	}

	// public List<Admin> queryByRegTime(int num) {
	// return adminsDAO.findByTime(num);
	// }

	public Admin queryByAdminID(int adminId) {
		return adminsDAO.findByAdminid(adminId);
	}

	@Override
	public List<Admin> findAllAdmin() {
		// TODO Auto-generated method stub
		return adminsDAO.findAll();
	}

	public List<Admin> findAllAdmin(int page, int PAGE_NUMBER, Order order) {
		List<Admin> list = adminsDAO.findAll(page, PAGE_NUMBER, Order
				.desc("adminID"));
		return list;
	}
	
	@Override
	public Admin queryByID(Admin Admin) {
		// TODO Auto-generated method stub
		return adminsDAO.findByAdminid(admin.getAdminId());
	}

	@Override
	public Admin queryByID(int adminid) {
		return adminsDAO.findByAdminid(adminid);
	}

	@Override
	public Integer countAll() {
		return adminsDAO.countAll();
	}

	@Override
	public List<Admin> findAll(Integer page, Integer pageNumber, Order order) {
		return adminsDAO.findAll(page, pageNumber, order);
	}

	@Override
	public void update(Admin admin) {
		adminsDAO.update(admin);
	}
}
