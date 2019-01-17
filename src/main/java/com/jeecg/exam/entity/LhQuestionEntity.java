package com.jeecg.exam.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 描述：试题表
 * @author: www.jeecg.org
 * @since：2018年12月24日 09时58分22秒 星期一 
 * @version:1.0
 */
public class LhQuestionEntity implements Serializable{
	private static final long serialVersionUID = 1L;
		/**	 *题目ID	 */	private String id;	/**	 *题目内容	 */	private String subject;	/**	 *简介	 */	private String summary;	/**	 *选择答案	 */	private String chooseAnswer;	/**	 *选择个数	 */	private Integer chooseNumber;	/**	 *分类	 */	private String columnId;	/**	 *题目类型	 */	private String type;	/**	 *正确答案	 */	private String rightAnswer;	/**	 *出题次数	 */	private Integer number;	/**	 *创建人id	 */	private String createBy;	/**	 *创建日期	 */	private Date createDate;	/**	 *备注	 */	private String remark;	public String getId() {	    return this.id;	}	public void setId(String id) {	    this.id=id;	}	public String getSubject() {	    return this.subject;	}	public void setSubject(String subject) {	    this.subject=subject;	}	public String getSummary() {	    return this.summary;	}	public void setSummary(String summary) {	    this.summary=summary;	}	public String getChooseAnswer() {	    return this.chooseAnswer;	}	public void setChooseAnswer(String chooseAnswer) {	    this.chooseAnswer=chooseAnswer;	}	public Integer getChooseNumber() {	    return this.chooseNumber;	}	public void setChooseNumber(Integer chooseNumber) {	    this.chooseNumber=chooseNumber;	}	public String getColumnId() {	    return this.columnId;	}	public void setColumnId(String columnId) {	    this.columnId=columnId;	}	public String getType() {	    return this.type;	}	public void setType(String type) {	    this.type=type;	}	public String getRightAnswer() {	    return this.rightAnswer;	}	public void setRightAnswer(String rightAnswer) {	    this.rightAnswer=rightAnswer;	}	public Integer getNumber() {	    return this.number;	}	public void setNumber(Integer number) {	    this.number=number;	}	public String getCreateBy() {	    return this.createBy;	}	public void setCreateBy(String createBy) {	    this.createBy=createBy;	}	public Date getCreateDate() {	    return this.createDate;	}	public void setCreateDate(Date createDate) {	    this.createDate=createDate;	}	public String getRemark() {	    return this.remark;	}	public void setRemark(String remark) {	    this.remark=remark;	}
}

