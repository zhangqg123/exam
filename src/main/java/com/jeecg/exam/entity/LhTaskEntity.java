package com.jeecg.exam.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 描述：作业表
 * @author: www.jeecg.org
 * @since：2019年02月13日 09时42分47秒 星期三 
 * @version:1.0
 */
public class LhTaskEntity implements Serializable{
	private static final long serialVersionUID = 1L;
		/**	 *题目ID	 */	private String id;	/**	 *作业名称	 */	private String taskName;	/**	 *简介	 */	private String summary;	/**	 * 考试类型	 */	private String examType;	/**	 *考试	 */	private String examId;	/**	 *类型	 */	private String type;	/**	 *创建人id	 */	private String createBy;	/**	 *创建日期	 */	private Date createDate;	/**	 *作业分派	 */	private String assign;	/**	 *作业日期	 */	private Date assignDate;	public String getId() {	    return this.id;	}	public void setId(String id) {	    this.id=id;	}	public String getTaskName() {	    return this.taskName;	}	public void setTaskName(String taskName) {	    this.taskName=taskName;	}	public String getSummary() {	    return this.summary;	}	public void setSummary(String summary) {	    this.summary=summary;	}	public String getExamType() {	    return this.examType;	}	public void setExamType(String examType) {	    this.examType=examType;	}	public String getExamId() {	    return this.examId;	}	public void setExamId(String examId) {	    this.examId=examId;	}	public String getType() {	    return this.type;	}	public void setType(String type) {	    this.type=type;	}	public String getCreateBy() {	    return this.createBy;	}	public void setCreateBy(String createBy) {	    this.createBy=createBy;	}	public Date getCreateDate() {	    return this.createDate;	}	public void setCreateDate(Date createDate) {	    this.createDate=createDate;	}	public String getAssign() {	    return this.assign;	}	public void setAssign(String assign) {	    this.assign=assign;	}	public Date getAssignDate() {	    return this.assignDate;	}	public void setAssignDate(Date assignDate) {	    this.assignDate=assignDate;	}
}

