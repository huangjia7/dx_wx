package com.zy.framework.model;
/**
 * 持久化实体bean基类,
 * 持久化对象不强制要求继承该类，但是推荐继承该类
 * @author grq
 * 
 */
public class BaseEntity implements java.io.Serializable  {
	public int getCurrentpage() {
		return currentpage;
	}
	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	private static final long serialVersionUID = 1L;
	private java.util.List clickActionList = null;
	private int startrow = 0;   //开始行
	private int endrow = 18;    //结束行
	private int currentpage = 1; //当前页面
	private int pagesize = 20;   //每页显示记录数量
	private int totalcount=0;
	private String codes="";//多code 集合
	public String getCodes() {
		return codes;
	}
	public void setCodes(String codes) {
		this.codes = codes;
	}
	private String messageinfo="";
	private String errorflag="";
	public String getMessageinfo() {
		return messageinfo;
	}
	public void setMessageinfo(String messageinfo) {
		this.messageinfo = messageinfo;
	}
	public String getErrorflag() {
		return errorflag;
	}
	public void setErrorflag(String errorflag) {
		this.errorflag = errorflag;
	}
	public int getTotalcount() {
		return totalcount;
	}
	public void setTotalcount(int totalcount) {
		this.totalcount = totalcount;
	}
	private String currentColomu;      //当前排序列
	
	private String createEmpID = ""; //创建人
	private String createDate = ""; //创建时间
	private String updateEmpID = ""; //最后修改人
	private String updateDate = ""; //最后修改时间
	private String sysUserID = "";   //系统登录用户
	
	private String sortChoose = "desc";  //排序规则 升序 降序
	private String joinUpdateSQL = "";    //修改关联执行sql
	private String joinUpdateCheckedSQL = "";    //修改关联校验执行sql
	private String joinInsertSQL = "";    //新增关联执行sql
	private String joinInsertCheckedSQL = "";    //新增关联校验执行sql
	private String joinDeleteSQL = "";    //删除关联执行sql
	private String joinDeleteCheckedSQL = "";    //删除关联校验执行sql
	private String[] poplist=null;//要获取数据的属性列表
	private String actiontype="";//操作类型

	public String getActiontype() {
		return actiontype;
	}
	public void setActiontype(String actiontype) {
		this.actiontype = actiontype;
	}
	public String[] getPoplist() {
		return poplist;
	}
	public void setPoplist(String[] poplist) {
		this.poplist = poplist;
	}
	public void afterInsert(){}
	public void afterUpdate(){}
	public void afterDelete(){}
	public void afterInfo(){}
	public String getJoinDeleteSQL() {
		return joinDeleteSQL;
	}

	public void setJoinDeleteSQL(String joinDeleteSQL) {
		this.joinDeleteSQL = joinDeleteSQL;
	}

	public String getJoinInsertSQL() {
		return joinInsertSQL;
	}

	public void setJoinInsertSQL(String joinInsertSQL) {
		this.joinInsertSQL = joinInsertSQL;
	}

	public String getJoinUpdateSQL() {
		return joinUpdateSQL;
	}

	public void setJoinUpdateSQL(String joinUpdateSQL) {
		this.joinUpdateSQL = joinUpdateSQL;
	}

	public String getCurrentColomu() {
		return currentColomu;
	}

	public void setCurrentColomu(String currentColomu) {
		this.currentColomu = currentColomu;
	}

	public String getSortChoose() {
		return sortChoose;
	}

	public void setSortChoose(String sortChoose) {
		this.sortChoose = sortChoose;
	}

	public int getStartrow() {
		return (this.currentpage-1)*this.pagesize;
	}

	public void setStartrow(int startrow) {
		this.startrow = startrow;
	}

	public int getEndrow() {
		return endrow;
	}

	public void setEndrow(int endrow) {
		this.endrow = endrow;
	}

	public String getClickAction(){
		if(clickActionList==null) return "";
		int length = clickActionList.size();
		StringBuffer buffer = new StringBuffer("");
		for(int i=0; i<length; i++){
			String[] params = (String[])clickActionList.get(i);
			if(isAction(params[0])){
				buffer.append("<a href=javascript:" + params[0] + "(\"" + getClickID() + "\")>" + params[1] + "</a>&nbsp;&nbsp;");
			}
		}
		return buffer.toString();
	}
	public boolean isAction(String actiontype){
		return true;
	}
	public void setClickAction(java.util.List l){
		clickActionList = l;
	}
	public String getClickID(){
		return "";
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getCreateEmpID() {
		return createEmpID;
	}
    /*
	public String getCreateEmpName() {
		return getEmployeeName(getCreateEmpID());
	}
	
	protected String getEmployeeName(String eid){
		try{
			BaseService baseService = 
				(BaseService)com.wolf.framework.data.ResourceManager.getInstance().getSpringBean("baseService");
			com.wolf.hr.model.HrEmployeeEntity hre = new com.wolf.hr.model.HrEmployeeEntity();
			hre = (com.wolf.hr.model.HrEmployeeEntity)baseService.getObject(hre.getClass(), eid);
			return hre.getEmployeeName();
		}catch(Exception ee){}
		return "";
	}
	*/
	public void setCreateEmpID(String createEmpID) {
		this.createEmpID = createEmpID;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateEmpID() {
		return updateEmpID;
	}
	public String getUpdateEmpName() {
		//return getEmployeeName(getUpdateEmpID());
		return "";
	}
	public void setUpdateEmpID(String updateEmpID) {
		this.updateEmpID = updateEmpID;
	}

	public String getJoinDeleteCheckedSQL() {
		return joinDeleteCheckedSQL;
	}

	public void setJoinDeleteCheckedSQL(String joinDeleteCheckedSQL) {
		this.joinDeleteCheckedSQL = joinDeleteCheckedSQL;
	}

	public String getJoinInsertCheckedSQL() {
		return joinInsertCheckedSQL;
	}

	public void setJoinInsertCheckedSQL(String joinInsertCheckedSQL) {
		this.joinInsertCheckedSQL = joinInsertCheckedSQL;
	}

	public String getJoinUpdateCheckedSQL() {
		return joinUpdateCheckedSQL;
	}

	public void setJoinUpdateCheckedSQL(String joinUpdateCheckedSQL) {
		this.joinUpdateCheckedSQL = joinUpdateCheckedSQL;
	}
	public String getSysUserID() {
		return sysUserID;
	}
	public void setSysUserID(String sysUserID) {
		this.sysUserID = sysUserID;
	}
}

