package com.jeecg.exam.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 描述：考试试题表
 * @author: www.jeecg.org
 * @since：2018年12月28日 08时22分27秒 星期五 
 * @version:1.0
 */
public class LhExamQuestionEntity implements Serializable{
	private static final long serialVersionUID = 1L;
		/**	 *题目ID	 */	private String id;	/**	 *考试编号	 */	private String examId;	/**	 *题目编号	 */	private String questionId;	public String getId() {	    return this.id;	}	public void setId(String id) {	    this.id=id;	}	public String getExamId() {	    return this.examId;	}	public void setExamId(String examId) {	    this.examId=examId;	}	public String getQuestionId() {	    return this.questionId;	}	public void setQuestionId(String questionId) {	    this.questionId=questionId;	}
}

