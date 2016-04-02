package com.zy.framework.dao.Dialect;
/**
 * sqlserver 分页
 * @author grq
 *
 */
public class SqlServerDialect implements Dialect {
    public String getPaginationSql(String sql, int pageNo, int pageSize) {
       return "select top " + pageSize + " * from (" + sql
              + ") t where t.code not in (select top " + (pageNo-1)*pageSize + " t1.code from ("
              + sql + ") t1)";
    }
}