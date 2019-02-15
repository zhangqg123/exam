package com.jeecg.exam.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 描述：考试分类表
 * @author: www.jeecg.org
 * @since：2019年02月13日 09时07分44秒 星期三 
 * @version:1.0
 */
public class LhExamTypeEntity implements Serializable{
	private static final long serialVersionUID = 1L;
		/**	 *id	 */	private String id;	/**	 *name	 */	private String name;	public String getId() {	    return this.id;	}	public void setId(String id) {	    this.id=id;	}	public String getName() {	    return this.name;	}	public void setName(String name) {	    this.name=name;	}
}

