package com.jeecg.exam.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 描述：试题分类表
 * @author: www.jeecg.org
 * @since：2018年12月27日 06时15分19秒 星期四 
 * @version:1.0
 */
public class LhQuestionColumnEntity implements Serializable{
	private static final long serialVersionUID = 1L;
		/**	 *id	 */	private String id;	/**	 *图片地址	 */	private String imageHref;	/**	 *图片名称	 */	private String imageName;	/**	 *类别名称	 */	private String columnName;	/**	 *类型	 */	private String type;	/**	 *父节点	 */	private String parentCode;	/**	 *地址	 */	private String href;	/**	 *owner	 */	private String owner;	public String getId() {	    return this.id;	}	public void setId(String id) {	    this.id=id;	}	public String getImageHref() {	    return this.imageHref;	}	public void setImageHref(String imageHref) {	    this.imageHref=imageHref;	}	public String getImageName() {	    return this.imageName;	}	public void setImageName(String imageName) {	    this.imageName=imageName;	}	public String getColumnName() {	    return this.columnName;	}	public void setColumnName(String columnName) {	    this.columnName=columnName;	}	public String getType() {	    return this.type;	}	public void setType(String type) {	    this.type=type;	}	public String getParentCode() {	    return this.parentCode;	}	public void setParentCode(String parentCode) {	    this.parentCode=parentCode;	}	public String getHref() {	    return this.href;	}	public void setHref(String href) {	    this.href=href;	}	public String getOwner() {	    return this.owner;	}	public void setOwner(String owner) {	    this.owner=owner;	}
}

