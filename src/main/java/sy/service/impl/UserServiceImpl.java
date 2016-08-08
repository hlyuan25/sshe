package sy.service.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sy.dao.UserDaoI;
import sy.model.Tuser;
import sy.service.UserServiceI;

@Service("userService")
public class UserServiceImpl implements UserServiceI {

	private UserDaoI userDao;

	public UserDaoI getUserDao() {
		return userDao;
	}

	@Autowired
	public void setUserDao(UserDaoI userDao) {
		this.userDao = userDao;
	}

	@Override
	public void test() {
		System.out.println("test");
	}

	@Override
	public Serializable save(Tuser t) {
		// TODO Auto-generated method stub
		return userDao.save(t);
	}

}
