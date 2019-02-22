package com.jeecg.exam.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 描述：得分表
 * @author: www.jeecg.org
 * @since：2019年01月04日 13时21分36秒 星期五 
 * @version:1.0
 */
public class LhExamScoreEntity implements Serializable{
	private static final long serialVersionUID = 1L;
		/**	 *题目ID	 */	private String id;	/**	 *考试编号	 */	private String examId;
	private String examName;	/**	 *openId	 */	private String openId;	/**	 *分数	 */	private Integer score;
	
	private Integer number;
	private Date createDate;
		public String getId() {	    return this.id;	}	public void setId(String id) {	    this.id=id;	}	public String getExamId() {	    return this.examId;	}	public void setExamId(String examId) {	    this.examId=examId;	}	public String getOpenId() {	    return this.openId;	}	public void setOpenId(String openId) {	    this.openId=openId;	}	public Integer getScore() {	    return this.score;	}	public void setScore(Integer score) {	    this.score=score;	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getExamName() {
		return examName;
	}
	public void setExamName(String examName) {
		this.examName = examName;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}

