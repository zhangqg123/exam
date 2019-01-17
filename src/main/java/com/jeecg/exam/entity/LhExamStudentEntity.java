package com.jeecg.exam.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 描述：学生表
 * @author: www.jeecg.org
 * @since：2019年01月04日 12时45分42秒 星期五 
 * @version:1.0
 */
public class LhExamStudentEntity implements Serializable{
	private static final long serialVersionUID = 1L;
		/**	 *id	 */	private String id;	/**	 *手机	 */	private String phone;	/**	 *用户账号	 */	private String username;	/**	 *密码	 */	private String password;	/**	 *有效状态	 */	private Integer status;	/**	 *openId	 */	private String openid;	/**	 *验证码	 */	private String smscode;	/**	 *用户KEY	 */	private String userkey;	/**	 *身份证号	 */	private String idcard;	/**	 *真实名字	 */	private String realname;	/**	 *性别	 */	private Integer sex;	/**	 *地址	 */	private String address;	public String getId() {	    return this.id;	}	public void setId(String id) {	    this.id=id;	}	public String getPhone() {	    return this.phone;	}	public void setPhone(String phone) {	    this.phone=phone;	}	public String getUsername() {	    return this.username;	}	public void setUsername(String username) {	    this.username=username;	}	public String getPassword() {	    return this.password;	}	public void setPassword(String password) {	    this.password=password;	}	public Integer getStatus() {	    return this.status;	}	public void setStatus(Integer status) {	    this.status=status;	}	public String getOpenid() {	    return this.openid;	}	public void setOpenid(String openid) {	    this.openid=openid;	}	public String getSmscode() {	    return this.smscode;	}	public void setSmscode(String smscode) {	    this.smscode=smscode;	}	public String getUserkey() {	    return this.userkey;	}	public void setUserkey(String userkey) {	    this.userkey=userkey;	}	public String getIdcard() {	    return this.idcard;	}	public void setIdcard(String idcard) {	    this.idcard=idcard;	}	public String getRealname() {	    return this.realname;	}	public void setRealname(String realname) {	    this.realname=realname;	}	public Integer getSex() {	    return this.sex;	}	public void setSex(Integer sex) {	    this.sex=sex;	}	public String getAddress() {	    return this.address;	}	public void setAddress(String address) {	    this.address=address;	}
}

