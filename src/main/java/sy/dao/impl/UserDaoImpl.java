package sy.dao.impl;

import org.springframework.stereotype.Repository;

import sy.dao.UserDaoI;

@Repository("userDao")
public class UserDaoImpl<Tuser> extends BaseDaoImpl<Tuser> implements UserDaoI<Tuser>{
	
}
