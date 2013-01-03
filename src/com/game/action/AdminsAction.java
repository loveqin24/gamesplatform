package com.game.action;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.game.dao.impl.AdminsDAO;
import com.game.po.Admin;
import com.game.service.AdminsService;
import com.game.util.Order;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;



public class AdminsAction extends ActionSupport {
	public static final Integer PAGE_NUMBER = 20;
	public AdminsService adminsService;
	public AdminsService getAdminsService() {
		return adminsService;
	}

	public void setAdminsService(AdminsService adminsService) {
		this.adminsService = adminsService;
	}

	List<Admin> admins = new ArrayList<Admin>();
	Admin admin = new Admin();
	private String username;						//管理员用户名
	private String password;
	private String oldpassword;
	private String newpassword;
	private String renewpassword;
	
	
	public String getUsername() {
		return username;
	}

	public String getOldpassword() {
		return oldpassword;
	}

	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public String getRenewpassword() {
		return renewpassword;
	}

	public void setRenewpassword(String renewpassword) {
		this.renewpassword = renewpassword;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	java.lang.Integer[] ids ;	
	Integer page = 1;
	Integer totals = 1;
	
	@SkipValidation
	public String list(){		
		
		Integer records = adminsService.countAll();
		
		totals = records/PAGE_NUMBER + (records%PAGE_NUMBER == 0?0:1);
		totals = totals < 1 ? 1 : totals;
		page = (page < 1)? page : (page > totals ? totals : page);
		
		admins = adminsService.findAll(page, PAGE_NUMBER, Order.desc("adminid"));
		return "success";
	}
	
	
	@SkipValidation
	public String login(){
		admins = adminsService.findAllAdmin();
		for (Admin a : admins) {
			if (username.equals(a.getUsername())&&password.equals(a.getPassword()))
			{
				admin = a;
				break;
			}
		}
		
		Map session = ActionContext.getContext().getSession();//获得session对象
		if (null==admin || null==admin.getAdminId())
		{
			
			return "loginfail";
		}
		session.put("admin", admin);
		return "login";
	}
	
	@SkipValidation
	public String changepassword(){
		Map session = ActionContext.getContext().getSession();//获得session对象
		admin = (Admin)session.get("admin");
		if (null == admin ||null == admin.getUsername())
			return "changefail";
		if (oldpassword ==null || !oldpassword.equals(admin.getPassword()))
			return "changefail";
		if (newpassword ==null ||  renewpassword ==null || !newpassword.equals(renewpassword))
			return "changefail";
		
		admin.setPassword(newpassword);
		adminsService.update(admin);
		
		return "changepassword";
	}
	
	
	@SkipValidation
	public String editpassword(){
		
		admin = adminsService.queryByID(admin.getAdminId());
		
		return "editpassword";
	}
	
	
	@SkipValidation
	public String preedit(){
		
		admin = adminsService.queryByID(admin.getAdminId());
		
		return "edit";
	}
	
	@SkipValidation
	public String detail(){
		
		admin = adminsService.queryByID(admin.getAdminId());
		
		return "detail";
	}
	
	public String edit(){		
		
		adminsService.update(admin);
		return "list";
	}
	
	@SkipValidation
	public String preinsert(){
		
		return "insert";
	}
	
	public String insert(){		
		
		adminsService.addAdmin(admin);
		return "list";
	}
	
	@SkipValidation
	public String delete(){
		
		adminsService.deleteAdmin(admin);
		return "list";
	}
	
	@SkipValidation
	public String deleteAll(){
		if(ids == null || ids.length <= 0)
			return "list";
		
		
		for(java.lang.Integer id : ids){
			Admin model = adminsService.queryByID(id);
			if(model != null){
				adminsService.deleteAdmin(admin);
			}
		}
		return "list";
	}

	public List<Admin> getAdmins() {
		return admins;
	}

	public void setAdmins(List<Admin> admins) {
		this.admins = admins;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public java.lang.Integer[] getIds() {
		return ids;
	}

	public void setIds(java.lang.Integer[] ids) {
		this.ids = ids;
	}

	

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getTotals() {
		return totals;
	}

	public void setTotals(Integer totals) {
		this.totals = totals;
	}
}
