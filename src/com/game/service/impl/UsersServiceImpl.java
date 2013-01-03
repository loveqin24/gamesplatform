package com.game.service.impl;

import java.util.List;

import com.game.dao.impl.UsersDAO;
import com.game.po.User;
import com.game.service.UsersService;
import com.game.util.Order;

public class UsersServiceImpl implements UsersService {
	private UsersDAO usersDAO;// ע�����ݷ��ʲ�
	

	public UsersDAO getUsersDAO() {
		return usersDAO;
	}

	

	public void setUsersDAO(UsersDAO usersDAO) {
		this.usersDAO = usersDAO;// �������ݷ��ʲ�
	}

//	public UsersServiceImpl(UsersDAO usersDAO, User user) {
//		super();
//		this.usersDAO = usersDAO;
//		this.user = user;
//	}

	public void addUser(User user) {
		usersDAO.insert(user);// ������ݱ���
	}

//	public Result findAllUser(Page page) {
//		page = PageUtil.createPage(page, usersDAO.countAll()); // ������ҳ����
//		List<User> useres = usersDAO.findAll(page); // ִ�в�ѯ
//		Result result = new Result(); // �����������
//		result.setPage(page); // ���÷�ҳ��Ϣ
//		result.setList(useres);// ������Ʒ�����б�
//		return result;
//	}

	public void deleteUser(User user) {
		usersDAO.delete(user);
	}

	// public List<User> queryByRegTime(int num) {
	// return usersDAO.findByTime(num);
	// }

	public User queryByUserID(int userId) {
		return usersDAO.findByUserid(userId);
	}

	@Override
	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		return usersDAO.findAll();
	}

	@Override
	public User queryByID(User user) {
		// TODO Auto-generated method stub
		return usersDAO.findByUserid(user.getUserId());
	}

	@Override
	public List<User> findAllUser(int page, int PAGE_NUMBER, Order order) {
		List<User> list = usersDAO.findAll(page, PAGE_NUMBER, Order
				.asc("userID"));
		return list;
	}

	@Override
	public Integer countAll() {
		return usersDAO.countAll();
	}

	@Override
	public User findByUserid(Integer userId) {
		return usersDAO.findByUserid(userId);
	}

	@Override
	public void update(User user) {
		usersDAO.update(user);
	}

	@Override
	public User findByUserName(String username,String password) {
		List<User> list = usersDAO.findAll();
		User user = new User();
		for (User u : list) {
			if (u.getUsername().equals(username)&&u.getPassword().equals(password))
			{
				user = u;
				break;
			}
		}
		return user;
	}
}
