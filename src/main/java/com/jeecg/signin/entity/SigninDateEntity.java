package com.jeecg.signin.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 描述：签到表
 * @author: www.jeecg.org
 * @since：2018年12月18日 15时22分19秒 星期二 
 * @version:1.0
 */
public class SigninDateEntity implements Serializable{
	private static final long serialVersionUID = 1L;
		/**	 *id	 */	private String id;	/**	 *openid	 */	private String openid;	/**	 *年	 */	private Integer year;	/**	 *月	 */	private Integer month;	/**	 *日	 */	private Integer day;	/**	 *日期	 */	private Date time;	public String getId() {	    return this.id;	}	public void setId(String id) {	    this.id=id;	}	public String getOpenid() {	    return this.openid;	}	public void setOpenid(String openid) {	    this.openid=openid;	}	public Integer getYear() {	    return this.year;	}	public void setYear(Integer year) {	    this.year=year;	}	public Integer getMonth() {	    return this.month;	}	public void setMonth(Integer month) {	    this.month=month;	}	public Integer getDay() {	    return this.day;	}	public void setDay(Integer day) {	    this.day=day;	}	public Date getTime() {	    return this.time;	}	public void setTime(Date time) {	    this.time=time;	}
}

