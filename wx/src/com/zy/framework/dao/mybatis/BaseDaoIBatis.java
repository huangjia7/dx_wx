package com.zy.framework.dao.mybatis;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ClassUtils;

import com.zy.framework.dao.IBaseDao;

@Repository("dao")
@Transactional
public class BaseDaoIBatis extends SqlSessionDaoSupport implements IBaseDao {
	private static int position = 1;
	
	   @Resource
	    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
	        super.setSqlSessionTemplate(sqlSessionTemplate);
	    }

	/**
	 * 根据sql ID，查询记录
	 */
	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)  
	public Object getObject(String queryname, Object param) {
		// TODO Auto-generated method stub
		if(param==null){
			return this.getSqlSession().selectOne(queryname);
		}else{
			return this.getSqlSession().selectOne(queryname, param);
			
		}
	}
    
	/**
	 * 根据sql ID，查询记录结果集
	 */
	 @Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)  
	public List getObjects(String queryname, Object param) {
		// TODO Auto-generated method stub
		try{
			if(param==null){
				return this.getSqlSession().selectList(queryname);
			}else{
				return this.getSqlSession().selectList(queryname, param);
				 
			}
		}catch(Exception ee){
			ee.printStackTrace();
		}
		return null;
	 
	}
	
	/**
	 * 根据sql ID，查询记录结果集
	 */
	
	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)  
	public List getObjects(String queryname, Object param,int nPageNo,int nPageSize) {
		// TODO Auto-generated method stub
		System.out.println("=======pageno=="+nPageNo+"==========pagesize==="+nPageSize);
		try{
			/*if(param==null){
				return this.getSqlSession().selectList(queryname,null,new RowBounds(nPageNo,nPageSize));
			}else{
				return this.getSqlSession().selectList(queryname, param,new RowBounds(nPageNo,nPageSize));
				 
			}*/
			return this.getSqlSession().selectList(queryname, param,new RowBounds(nPageNo,nPageSize));
		}catch(Exception ee){
			//ee.printStackTrace();
		}
		return null;
	 
	}
    
	/**
	 * 修改记录信息
	 */
	
	public int updateObject(String sqlname, Object param) {
		// TODO Auto-generated method stub
		return this.getSqlSession().update(sqlname, param);
	}
	/**
	 * 根据ID，查询一条记录
	 */
	
	 @Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)  
	public Object getObject(Class clazz, Serializable id) {
		// TODO Auto-generated method stub
		//System.out.println("==========getobject==========null===="+this.getFindQuery(ClassUtils.getShortName(clazz)));
		//System.out.println("==========getobject==========null===="+id);
		Object object = this.getSqlSession().selectOne(this.getFindQuery(ClassUtils.getShortName(clazz)),id);
		if (object == null) {
			//System.out.println("==========getobject==========null====");
			throw new ObjectRetrievalFailureException(ClassUtils.getShortName(clazz), id);
		}
		return object;
	}
	/**
	 * 查询多条记录的结果集
	 */
	
	public List getObjects(Class clazz) {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectList(this.getSelectQuery(ClassUtils.getShortName(clazz)));
	}

	/**
	 * 根据查询条件，查询结果集
	 */
	
	public List getObjects(Class clazz, Object parameters) {
		// TODO Auto-generated method stub
		List queryResult = null;
		try {
			queryResult = getSqlSession().selectList(getSelectQuery(ClassUtils.getShortName(clazz)), parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return queryResult;
	}
	/**
	 * 查询数据总行数
	 */
	
	public int getTotalRow(Class clazz, Object parameters) {
		// TODO Auto-generated method stub
		try{
			Object obj = getSqlSession().selectOne(
					this.getRecountQuery(ClassUtils.getShortName(clazz)),
					parameters);
			if (obj != null) {
				return Integer.parseInt(obj.toString());
			} else {
				return 0;
			}
		}catch(Exception ee){
			return 0;
		}
	}
	/**
	 * 查询数据总行数
	 */
	
	public int getTotalRow(String sname, Object parameters) {
		// TODO Auto-generated method stub
		try{
			Object obj = getSqlSession().selectOne(
					this.getRecountQuery(sname),
					parameters);
			if (obj != null) {
				return Integer.parseInt(obj.toString());
			} else {
				return 0;
			}
		}catch(Exception ee){
			return 0;
		}
	}
	/**
	 * 根据KEY名称,生成ID
	 */
	
	public String createKeyID(String keyname) {
		// TODO Auto-generated method stub
		if(position>10000){
			position = 0;
		}else{
			position++;
		}
		String nextKey = String.valueOf(position);
		while(nextKey.length()<5){
			nextKey = "0" + nextKey;
		}
		java.util.Date date = new java.util.Date();
		java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyMMddhhmmssSSS");
		nextKey = format.format(date).trim()+nextKey;
		return nextKey;
	}
	/**
	 * 调用存储过程
	 * @param sqlname
	 * @param parameters
	 * @return 数据集
	 */
	
	public Map callProc(String sqlname, Map parameters) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 增加记录
	 */
	
	public int insertObject(Object o) {
		// TODO Auto-generated method stub
		String className = ClassUtils.getShortName(o.getClass());
		this.getSqlSession().insert(getInsertQuery(className), o);
		return 1;
	}
	/**
	 * 修改记录
	 */
	
	public int updateObject(Object o) {
		// TODO Auto-generated method stub
		String className = ClassUtils.getShortName(o.getClass());
		int retI = getSqlSession().update(getUpdateQuery(className), o);
		return retI;
	}
	/**
	 * 删除记录
	 */
	
	public int deleteObject(Class clazz, Serializable id) {
		// TODO Auto-generated method stub
		int retI = getSqlSession().update(
				getDeleteQuery(ClassUtils.getShortName(clazz)), id);
		return retI;
	}
	
	/**
	 * @return Returns the search list query name.
	 */
	private String getSelectQuery(String className) {
		return className + "_list";
	}

	/**
	 * @return Returns the search info query name.
	 */
	private String getFindQuery(String className) {
		return className + "_info";
	}

	/**
	 * @return Returns the insert query name.
	 */
	private String getInsertQuery(String className) {
		return className + "_insert";
	}

	/**
	 * @return Returns the update query name.
	 */
	private String getUpdateQuery(String className) {
		return className + "_update";
	}
	/**
	 * @return Returns the delete query name.
	 */
	private String getDeleteQuery(String className) {
		return className + "_delete";
	}
	/**
	 * @return Returns the recount query name.
	 */
	private String getRecountQuery(String className) {
		return className + "_totalrow";
	}

}