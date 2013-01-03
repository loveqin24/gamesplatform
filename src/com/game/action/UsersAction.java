package com.game.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.game.dao.impl.UsersDAO;
import com.game.po.Commodity;
import com.game.po.User;
import com.game.service.UsersService;
import com.game.service.impl.UsersServiceImpl;
import com.game.util.Order;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class UsersAction extends ActionSupport {
	public static final Integer PAGE_NUMBER = 20;
	public UsersService usersService;
	public UsersService getUsersService() {
		return usersService;
	}

	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}

	List<User> users = new ArrayList<User>();
	User user = new User();
	
	java.lang.Integer[] ids ;	
	Integer page = 1;
	Integer totals = 1;
	
	@SkipValidation
	public String list(){		
		Integer records = usersService.countAll();
		
		totals = records/PAGE_NUMBER + (records%PAGE_NUMBER == 0?0:1);
		totals = totals < 1 ? 1 : totals;
		page = (page < 1)? page : (page > totals ? totals : page);
		
		users = usersService.findAllUser(page, PAGE_NUMBER, Order.desc("userid"));
		return "success";
	}
	
	@SkipValidation
	public String login(){
		String username = user.getUsername();
		String password = user.getPassword();
		user = usersService.findByUserName(username,password);
		if (null==user.getUserId())
			return "loginfail";
		Map session = ActionContext.getContext().getSession();//获得session对象
		session.put("user", user);
		
		
		return "login";
	}
	
	@SkipValidation
	public String show(){
		Map session = ActionContext.getContext().getSession();//获得session对象
		User u = ( User)session.get("user");//取得购物车
		
		if (null==u||null==u.getUserId())
			return "showfail";
		user = u;///usersService.findByUserid(u.getUserId());
	
		return "show";
	}
	
	
	@SkipValidation
	public String prelogin(){
	
		return "prelogin";
	}
	
	
	@SkipValidation
	public String register(){
	
		return "register";
	}
	
	@SkipValidation
	public String registersave(){
		if (null==user.getPost())
			user.setPost("1");
		if (null==user.getRegIpAddress())
			user.setRegIpAddress("127.0.0.1");
		if (null==user.getRegTime());
			user.setRegTime(new Date());
		usersService.addUser(user);
		return "registersave";
	}
	
	@SkipValidation
	public String preedit(){
		
		user = usersService.findByUserid(user.getUserId());
	
		return "edit";
	}
	
	@SkipValidation
	public String detail(){
		
		user = usersService.findByUserid(user.getUserId());
		
		return "detail";
	}
	
	public String edit(){		
		if (null==user.getPost())
			user.setPost("1");
		if (null==user.getRegIpAddress())
			user.setRegIpAddress("127.0.0.1");
		if (null==user.getRegTime());
			user.setRegTime(new Date());
		usersService.update(user);
		return "list";
	}
	
	@SkipValidation
	public String preinsert(){
		
		return "insert";
	}
	
	public String insert(){		
		if (null==user.getPost())
			user.setPost("1");
		if (null==user.getRegIpAddress())
			user.setRegIpAddress("127.0.0.1");
		if (null==user.getRegTime());
			user.setRegTime(new Date());
		usersService.addUser(user);
		return "list";
	}
	
	@SkipValidation
	public String delete(){
		
		usersService.deleteUser(user);
		return "list";
	}
	
	@SkipValidation
	public String deleteAll(){
		if(ids == null || ids.length <= 0)
			return "list";
		
		
		for(java.lang.Integer id : ids){
			User model = usersService.findByUserid(id);
			if(model != null){
				usersService.deleteUser(user);
			}
		}
		return "list";
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
