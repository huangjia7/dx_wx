package com.zy.framework.service;
import java.io.Serializable;
import java.util.Collection;

import com.zy.framework.exception.SqlException;
/**
 * 
 * 业务处理接口
 * 
 * @author grq
 * 
 */
public interface BaseService {
	/**
	 * 根据sql ID，查询记录
	 */
	public Object getObject(String queryname, Object param);

	/**
	 * 根据sql ID，查询记录结果集
	 */
	public Collection getObjects(String queryname, Object param);
	
	/**
	 * 获取资源信息列表 扩展信息
	 * @param queryname
	 * @param param
	 * @return
	 */
	public Collection getObjects(Object param);
	
	/**
	 * 根据sql ID，查询记录结果集
	 */
	public Collection getObjects(String queryname, Object param,int nPageNo,int nPageSize);

	/**
	 * 修改记录信息
	 */
	public int updateObject(String sqlname, Object param) throws SqlException;

	/**
	 * 增加记录
	 */
	public int insertObject(Object o) throws SqlException;

	/**
	 * 修改记录
	 */
	public int updateObject(Object o) throws SqlException;

	/**
	 * 删除记录
	 */
	public int deleteObject(Class clazz, Serializable id) throws SqlException;
    
	 
	/**
	 * 根据ID，查询一条记录
	 */
	public Object getObject(Class clazz, Serializable id);

	/**
	 * 查询多条记录的结果集
	 */
	public Collection getObjects(Class clazz);

	/**
	 * 根据查询条件，查询结果集
	 */
	public Collection getObjects(Class clazz, Object parameters);

	/**
	 * 根据KEY名称,生成ID
	 */
	public String createKeyID(String keyname);
}
