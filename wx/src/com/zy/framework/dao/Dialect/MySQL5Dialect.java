package com.zy.framework.dao.Dialect;
/**
 * mysql 分页
 * @author grq
 *
 */
public class MySQL5Dialect implements Dialect {
    public String getPaginationSql(String sql, int offset, int limit) {
       return sql + " limit " + offset + "," + limit;
    }
}
