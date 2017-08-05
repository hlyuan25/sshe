package sy.dao.impl;

import org.springframework.stereotype.Repository;

import sy.dao.MenuDaoI;

@Repository("menuDao")
public class MenuDaoImpl<Tmenu> extends BaseDaoImpl<Tmenu> implements MenuDaoI<Tmenu> {

}
