package com.zy.framework.service.impl;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zy.framework.dao.IBaseDao;
import com.zy.framework.exception.SqlException;
import com.zy.framework.model.BaseEntity;
import com.zy.framework.service.BaseService;
/**
 * 业务处理类的 基础类
 * @author grq
 *
 */
@Service("baseService")
public class BaseServiceImpl implements BaseService{
	protected final Log log = LogFactory.getLog(getClass());  //日志处理类
	@Resource(name="dao")
	protected IBaseDao dao = null;   //数据库持久化对象

	/**
	 * 根据sql ID，查询记录
	 */
	public Object getObject(String queryname, Object param) {
		return dao.getObject(queryname, param);
	}

	/**
	 * 根据sql ID，查询记录结果集
	 */
	public Collection getObjects(String queryname, Object param) {
		return dao.getObjects(queryname, param);
	}
	/**
	 * 根据sql ID，查询记录结果集
	 */
	public Collection getObjects(String queryname, Object param,int nPageNo,int nPageSize){
		return dao.getObjects(queryname, param,nPageNo,nPageSize);
	}
	/**
	 * 根据ID，查询一条记录
	 */
	public Object getObject(Class clazz, Serializable id) {
		return dao.getObject(clazz, id);
	}
	/**
	 * 更新数据库信息
	 */
	public int updateObject(String sqlname, Object param) {
		String[] sqlA = sqlname.split(",");
		int length = sqlA.length;
		int retInt = 0;
		for(int i=0; i<length; i++){
			if(sqlA[i]==null||sqlA[i].trim().equals("")) continue;
			retInt = retInt + dao.updateObject(sqlA[i], param);
		}
		return retInt;
	}
	/**
	 * 更新sql执行前所作的必要的数据库校验
	 * @param sql
	 * @param o
	 * @throws SqlException
	 */
	protected void sqlBeforeChecked(String sql, Object o, String preStr) throws SqlException{
		if(sql==null||sql.trim().equals("")){
			return;
		}
		java.util.List listdata = dao.getObjects(sql, o);
		StringBuffer buffer = new StringBuffer("");
		int length = listdata.size();
		for(int i=0; i<length; i++){
			String str = listdata.get(i).toString();
			buffer.append(str + "<br>");
		}
		if(buffer.toString().length()>0){
			throw new SqlException(preStr + buffer.toString());
		}
	}
	/**
	 * 增加记录
	 */
	@Transactional
	public int insertObject(Object o) throws SqlException{
		int retInt = 0;
		if(o instanceof BaseEntity){  //联合操作
			BaseEntity bEntity = (BaseEntity)o;
			sqlBeforeChecked(bEntity.getJoinInsertCheckedSQL(), o, "新增失败:<br>");
			String sql = bEntity.getJoinInsertSQL();
			retInt = updateObject(sql, o);
		}
		retInt = retInt + dao.insertObject(o);
		return retInt;
	}

	/**
	 * 修改记录
	 */
	public int updateObject(Object o) throws SqlException{
		int retInt = 0;
		if(o instanceof BaseEntity){ //联合操作
			BaseEntity bEntity = (BaseEntity)o;
			sqlBeforeChecked(bEntity.getJoinUpdateCheckedSQL(), o, "修改失败:<br>");
			String sql = bEntity.getJoinUpdateSQL();
			retInt = updateObject(sql, o);
		}
		retInt = retInt + dao.updateObject(o);
		return retInt;

	}

	/**
	 * 删除记录
	 */
	public int deleteObject(Class clazz, Serializable id) throws SqlException{
		int retInt = 0;
		Object o = null;
		try{
			o = clazz.newInstance();
		}catch(Exception ee){}
		
		if(id instanceof String){
			 
		   String[] ids =((String)id).split(",");
		   for(int i=0;i<ids.length;i++){
			   if(ids[i]!=null && !ids[i].equals("")){
				   if(o instanceof BaseEntity){ //联合操作
						BaseEntity bEntity = (BaseEntity)o;
						sqlBeforeChecked(bEntity.getJoinDeleteCheckedSQL(), ids[i], "删除失败:<br>");
						String sql = bEntity.getJoinDeleteSQL();
						retInt = updateObject(sql, ids[i]);
					}
				   retInt = retInt + dao.deleteObject(clazz, ids[i]); 
			   }
		   }
		   
		}else{
		   retInt = retInt + dao.deleteObject(clazz, id);
		}
		return retInt;
	}
	 
	/**
	 * 查询多条记录的结果集
	 */
	public Collection getObjects(Class clazz) {
		return dao.getObjects(clazz);
	}

	/**
	 * 根据查询条件，查询结果集
	 */
	public Collection getObjects(Class clazz, Object parameters) {

		return dao.getObjects(clazz, parameters);
	}

	/**
	 * 根据KEY名称,生成ID
	 */
	public String createKeyID(String keyname) {
		String id = "1";
		id = (String) dao.createKeyID(keyname);
		return id;
	}

	/**
	 * 取数据操作dao
	 * 
	 * @return
	 */
	public IBaseDao getDao() {
		return dao;
	}
	/**
	 * 设置数据操作dao
	 */
	public void setDao(IBaseDao dao) {
		this.dao = dao;
	}

	/*@Override
	public int deleteObject(Class clazz, Serializable id) throws SqlException {
		// TODO Auto-generated method stub
		return 0;
	}
    */
	
	/**
	 * 获取资源信息列表 扩展信息
	 * @param queryname
	 * @param param
	 * @return
	 */
	public Collection getObjects(Object param){
		return null;
	}
	 
}
