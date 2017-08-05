package sy.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface BaseDaoI<T> {
	/*增加记录*/
	public Serializable save(T o);
	
	public void saveOrUpdate(T o);
	/*删除记录*/
	public void delete(T o);
	/*取出记录*/
	public T get(String hql);
	
	public T get(String hql, Map<String, Object> params);
	
	public T get(Class<T> c, Serializable id);
	
	public List<T> find(String hql);
	
	public List<T> find(String hql, Map<String, Object> params);
	
	public List<T> find(String hql, int page, int rows);
	
	public List<T> find(String hql, Map<String, Object> params, int page, int rows);
	/*统计取出记录的条数*/
	public Long count(String hql);
	
	public Long count(String hql, Map<String, Object> params);
	
	public int executeHql(String hql);
}
