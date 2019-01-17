package com.jeecg.exam.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 描述：考试表
 * @author: www.jeecg.org
 * @since：2018年12月26日 07时46分03秒 星期三 
 * @version:1.0
 */
public class LhExamEntity implements Serializable{
	private static final long serialVersionUID = 1L;
		/**	 *题目ID	 */	private String id;	/**	 *考试名称	 */	private String examName;	/**	 *试题编号	 */	private String questionColumn;	/**	 *分数	 */	private Integer score;	/**	 *题目个数	 */	private Integer questionNumber;	/**	 *考试类型	 */	private Integer examType;	/**	 *答题时间	 */	private String answerTime;	/**	 *考试次数	 */	private Integer number;	/**	 *创建人id	 */	private String createBy;	/**	 *创建日期	 */	private Date createDate;	/**	 *备注	 */	private String remark;	/**	 *正确答案	 */	private String rightAnswer;	public String getId() {	    return this.id;	}	public void setId(String id) {	    this.id=id;	}	public String getExamName() {	    return this.examName;	}	public void setExamName(String examName) {	    this.examName=examName;	}	public Integer getScore() {	    return this.score;	}	public void setScore(Integer score) {	    this.score=score;	}	public Integer getQuestionNumber() {	    return this.questionNumber;	}	public void setQuestionNumber(Integer questionNumber) {	    this.questionNumber=questionNumber;	}	public Integer getExamType() {	    return this.examType;	}	public void setExamType(Integer examType) {	    this.examType=examType;	}	public String getAnswerTime() {	    return this.answerTime;	}	public void setAnswerTime(String answerTime) {	    this.answerTime=answerTime;	}	public Integer getNumber() {	    return this.number;	}	public void setNumber(Integer number) {	    this.number=number;	}	public String getCreateBy() {	    return this.createBy;	}	public void setCreateBy(String createBy) {	    this.createBy=createBy;	}	public Date getCreateDate() {	    return this.createDate;	}	public void setCreateDate(Date createDate) {	    this.createDate=createDate;	}	public String getRemark() {	    return this.remark;	}	public void setRemark(String remark) {	    this.remark=remark;	}	public String getRightAnswer() {	    return this.rightAnswer;	}	public void setRightAnswer(String rightAnswer) {	    this.rightAnswer=rightAnswer;	}
	public String getQuestionColumn() {
		return questionColumn;
	}
	public void setQuestionColumn(String questionColumn) {
		this.questionColumn = questionColumn;
	}
}

