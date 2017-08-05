package sy.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import sy.dao.BaseDaoI;


public class BaseDaoImpl<T> implements BaseDaoI<T> {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Serializable save(T o){
		return sessionFactory.getCurrentSession().save(o);

	}

	@Override
	public T get(String hql) {
		Query q = this.sessionFactory.getCurrentSession().createQuery(hql);
		List<T> l = q.list();
		if(l != null && l.size() > 0){
			return l.get(0);
		}
		return null;
	}

	@Override
	public T get(String hql, Map<String, Object> params) {
		Query q = this.sessionFactory.getCurrentSession().createQuery(hql);
		if(params != null && !params.isEmpty()){
			for(String key: params.keySet()){
				q.setParameter(key, params.get(key));
			}
		}
		List<T> l = q.list();
		if(l != null && l.size()>0){
			return l.get(0);
		}
		return null;
	}
	@Override
	public T get(Class<T> c, Serializable id) {
		return (T) this.getSessionFactory().getCurrentSession().get(c, id);
	}

	
	@Override
	public void delete(T o) {
		this.getSessionFactory().getCurrentSession().delete(o);	
	}

	@Override
	public void saveOrUpdate(T o) {
		// TODO Auto-generated method stub
		this.getSessionFactory().getCurrentSession().saveOrUpdate(o);
	}

	@Override
	public List<T> find(String hql) {
		Query q = this.getSessionFactory().getCurrentSession().createQuery(hql);
		return q.list();
	}

	@Override
	public List<T> find(String hql, Map<String, Object> params) {
		Query q = this.getSessionFactory().getCurrentSession().createQuery(hql);
		if(params != null && !params.isEmpty()){
			for(String key : params.keySet()){
				q.setParameter(key, params.get(key));
			}
		}
		return q.list();
	}

	@Override
	public List<T> find(String hql, int page, int rows) {
		Query q = this.getSessionFactory().getCurrentSession().createQuery(hql);
		return  q.setFirstResult((page-1) * rows).setMaxResults(rows).list();
	}

	@Override
	public List<T> find(String hql, Map<String, Object> params, int page,
			int rows) {
		Query q = this.getSessionFactory().getCurrentSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}

	@Override
	public Long count(String hql) {
		Query q = this.getSessionFactory().getCurrentSession().createQuery(hql);
		return (Long)q.uniqueResult();
	}

	@Override
	public Long count(String hql, Map<String, Object> params) {
		Query q = this.getSessionFactory().getCurrentSession().createQuery(hql);
		if(params != null && !params.isEmpty()){
			for(String key : params.keySet()){
				q.setParameter(key, params.get(key));
			}
		}
		return (Long)q.uniqueResult();
	}

	@Override
	public int executeHql(String hql) {
		Query q = this.getSessionFactory().getCurrentSession().createQuery(hql);
		return q.executeUpdate();
	}
}
