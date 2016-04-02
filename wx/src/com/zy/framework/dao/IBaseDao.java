package com.zy.framework.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * dao基本接口
 * 
 * @author grq
 * 
 */
public interface IBaseDao {
	/**
	 * 根据sql ID，查询记录
	 */
	public Object getObject(String queryname, Object param);
	/**
	 * 根据sql ID，查询记录结果集
	 */
	public java.util.List getObjects(String queryname, Object param);
	/**
	 * 修改记录信息
	 */
	public int updateObject(String sqlname, Object param);
	
	/**
	 * 根据ID，查询一条记录
	 */
	public Object getObject(Class clazz, Serializable id);

	/**
	 * 查询多条记录的结果集
	 */
	public List getObjects(Class clazz);

	/**
	 * 根据查询条件，查询结果集
	 */
	public List getObjects(Class clazz, Object parameters);

	/**
	 * 查询数据总行数
	 */
	public int getTotalRow(Class clazz, Object parameters);
	/**
	 * 查询数据总行数
	 */
	public int getTotalRow(String sname, Object parameters);
	/**
	 * 根据KEY名称,生成ID
	 */
	public String createKeyID(String keyname);
	/**
	 * 调用存储过程
	 * @param sqlname
	 * @param parameters
	 * @return 数据集
	 */
	public Map callProc(String sqlname, Map parameters);

	/**
	 * 增加记录
	 */
	public int insertObject(Object o);

	/**
	 * 修改记录
	 */
	public int updateObject(Object o);

	/**
	 * 删除记录
	 */
	public int deleteObject(Class clazz, Serializable id);
	/**
	 * 设置分页查询
	 * @param queryname
	 * @param param
	 * @param nPageNo
	 * @param nPageSize
	 * @return
	 */
	public List getObjects(String queryname, Object param,int nPageNo,int nPageSize);

}