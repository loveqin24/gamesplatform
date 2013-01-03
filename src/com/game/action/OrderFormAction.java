package com.game.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.validation.SkipValidation;
import org.jgroups.stack.IpAddress;

import sun.net.util.IPAddressUtil;

import com.game.page.Page;
import com.game.page.Result;
import com.game.po.Commodity;
import com.game.po.CommodityClass;
import com.game.po.OrderForm;
import com.game.po.User;
import com.game.service.CommodityClassService;
import com.game.service.OrderFormService;
import com.game.service.OrderListService;
import com.game.util.Order;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class OrderFormAction extends ActionSupport {
	public static final Integer PAGE_NUMBER = 20;
	public OrderFormService orderFormService;
	public OrderFormService getOrderFormService() {
		return orderFormService;
	}

	public void setOrderFormService(OrderFormService orderFormService) {
		this.orderFormService = orderFormService;
	}

	public List<OrderForm> getOrderforms() {
		return orderforms;
	}

	public void setOrderforms(List<OrderForm> orderforms) {
		this.orderforms = orderforms;
	}

	public OrderForm getOrderform() {
		return orderform;
	}

	public void setOrderform(OrderForm orderform) {
		this.orderform = orderform;
	}

	List<OrderForm> orderforms = new ArrayList<OrderForm>();
	OrderForm orderform = new OrderForm();
	private List<CommodityClass> commodityClasses;//商品种类列表
    
	public List<CommodityClass> getCommodityClasses() {
		return commodityClasses;
	}

	public void setCommodityClasses(List<CommodityClass> commodityClasses) {
		this.commodityClasses = commodityClasses;
	}
	private CommodityClassService commodityClassService;
	
	public CommodityClassService getCommodityClassService() {
		return commodityClassService;
	}

	public void setCommodityClassService(CommodityClassService commodityClassService) {
		this.commodityClassService = commodityClassService;
	}

	java.lang.Integer[] ids ;	
	Integer page = 1;
	Integer totals = 1;
	
	@SkipValidation
	public String list(){		
		
		Integer records = orderFormService.countAll();
		
		totals = records/PAGE_NUMBER + (records%PAGE_NUMBER == 0?0:1);
		totals = totals < 1 ? 1 : totals;
		page = (page < 1)? page : (page > totals ? totals : page);
		
		orderforms = orderFormService.findAll(page, PAGE_NUMBER, Order.desc("orderformid"));
		return "success";
	}
	
	@SkipValidation
	public String showcar(){
		Page newPage = new Page();				//设置分页信息
		newPage.setCurrentPage(1);	//设置当前页
		newPage.setEveryPage(10);	
		Result result = commodityClassService.findAllCommodityClass(newPage);//获取查询结果
		commodityClasses = result.getList();	//获取商品信息列表
		
		return "showcar";
	}
	
	@SkipValidation
	public String preedit(){
		
		orderform = orderFormService.findByOrderFormid(orderform.getOrderFormId());
		return "edit";
	}
	
	@SkipValidation
	public String detail(){
		
		orderform = orderFormService.findByOrderFormid(orderform.getOrderFormId());
		return "detail";
	}
	
	public String edit(){		
		orderFormService.update(orderform);
		return "list";
	}
	
	@SkipValidation
	public String preinsert(){
		return "insert";
	}
	
	

	public String add(){	
		Map session = ActionContext.getContext().getSession();//获得session对象
		List<Commodity> car = null;				//声明一个购物车
		if(session.get("car") == null) {	//如果session中不存在购物车
				car = new ArrayList<Commodity>();	//新建一个ArrayList实例
		}else {
			car = (List<Commodity>)session.get("car");//取得购物车
		}
		
		User u = ( User)session.get("user");//取得购物车
		
		if (null==u||null==u.getUserId())
		{
			u = new User();
			u.setUserId(13);
		}
		double to = 0.0;
		for (Commodity commodity : car) {
			to +=commodity.getCommodityPrice();
		}
		if (to>0)
		{
		OrderForm f = new OrderForm();
		Integer a = (int) (Math.random()*1000/10);
		f.setOrderFormNo(a.toString());
		f.setUserId(u.getUserId());
		f.setSubmitTime(new Date());
		f.setRemark("good");
		f.setTotalPrice(to);
		f.setConsignmentTime(new Date());
		f.setIpaddress("127.0.0.1");
		f.setIsPayoff(0);
		f.setIsConsignment(0);
		
		
		orderFormService.insert(f);
		
		session.clear();
		}
		return "add";
	}
	
	
	public String insert(){		
		orderFormService.insert(orderform);
		return "list";
	}
	
	@SkipValidation
	public String delete(){
		orderFormService.delete(orderform);
		return "list";
	}
	
	@SkipValidation
	public String deleteAll(){
		if(ids == null || ids.length <= 0)
			return "list";
		
		
		for(java.lang.Integer id : ids){
			OrderForm model = orderFormService.findByOrderFormid(id);
			if(model != null){
				orderFormService.delete(orderform);
			}
		}
		return "list";
	}

	public List<OrderForm> getOrderForms() {
		return orderforms;
	}

	public void setOrderForms(List<OrderForm> orderforms) {
		this.orderforms = orderforms;
	}

	public OrderForm getOrderForm() {
		return orderform;
	}

	public void setOrderForm(OrderForm orderform) {
		this.orderform = orderform;
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
