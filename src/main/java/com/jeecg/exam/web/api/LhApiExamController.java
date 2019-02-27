package com.jeecg.exam.web.api;

import java.net.URLDecoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JsonConfig;

import org.apache.velocity.VelocityContext;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.jeecgframework.p3.core.common.utils.AjaxJson;
import org.jeecgframework.p3.core.page.SystemTools;
import org.jeecgframework.p3.core.util.plugin.ViewVelocity;
import org.jeecgframework.p3.core.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jeecg.exam.entity.LhExamEntity;
import com.jeecg.exam.entity.LhExamScoreEntity;
import com.jeecg.exam.entity.LhExamStudentEntity;
import com.jeecg.exam.entity.LhQuestionColumnEntity;
import com.jeecg.exam.entity.LhQuestionEntity;
import com.jeecg.exam.service.LhExamService;
import com.jeecg.exam.service.LhExamStudentService;
import com.jeecg.exam.service.LhQuestionColumnService;
import com.jeecg.exam.service.LhQuestionService;
import com.jeecg.lhs.entity.LhSAccountEntity;
import com.jeecg.lhs.entity.LhSDeptEntity;
import com.jeecg.lhs.entity.LhSUserEntity;
import com.jeecg.lhs.service.LhSAccountService;
import com.jeecg.lhs.service.LhSDeptService;
import com.jeecg.lhs.service.LhSUserService;
import com.jeecg.lhs.utils.AES128Util;
import com.jeecg.lhs.utils.PasswordUtil;

 /**
 * 描述：考试表
 * @author: www.jeecg.org
 * @since：2018年12月26日 07时46分03秒 星期三 
 * @version:1.0
 */
@Controller
@RequestMapping("/api/exam")
public class LhApiExamController extends BaseController{
  @Autowired
  private LhExamService lhExamService;
  @Autowired
  private LhExamStudentService lhExamStudentService;
  @Autowired
  private LhQuestionService lhQuestionService;
  @Autowired
  private LhQuestionColumnService lhQuestionColumnService;
	@Autowired
	private LhSUserService lhSUserService;
	@Autowired
	private LhSAccountService lhSAccountService;
	@Autowired
	private LhSDeptService lhSDeptService;
  
	@RequestMapping(value="/columnList")
	public @ResponseBody String columnList(@ModelAttribute LhQuestionColumnEntity query, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String createBy=request.getParameter("createBy");
		if(createBy!=null&&createBy!=""){
			query.setOwner(createBy);
		}
		MiniDaoPage<LhQuestionColumnEntity> list = lhQuestionColumnService.getAll(query, 1, 199);
		// 分页数据
		List<?> resut = list.getResults();
		return JSONArray.toJSONString(resut);
	}
	/**
	  * 考试列表
	  * @return
	  */

	@RequestMapping(value="/examList")
	public @ResponseBody String examList(@ModelAttribute LhExamEntity query, HttpServletRequest request, HttpServletResponse response) throws Exception {
		MiniDaoPage<LhExamEntity> list = lhExamService.getAll(query, 1, 199);
		// 分页数据
		List<?> resut = list.getResults();
		return JSONArray.toJSONString(resut);
	}
	
	@RequestMapping(value="/questionList")
	public @ResponseBody AjaxJson questionList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		AjaxJson j = new AjaxJson();
		String examId = request.getParameter("examId");
		List<LhQuestionEntity> result = lhQuestionService.questionByExamId(examId);
		j.setObj(result);
		Map<String,Object> attributes=new HashMap<String,Object>();
		attributes.put("startTime", System.currentTimeMillis());
		j.setAttributes(attributes);
		return j;
	}
	
	@RequestMapping(value="/dept")
	public @ResponseBody AjaxJson dept(HttpServletRequest request, HttpServletResponse response) throws Exception {
		AjaxJson j = new AjaxJson();
		MiniDaoPage<LhSDeptEntity> list = lhSDeptService.getAll(new LhSDeptEntity(), 1, 100);
		j.setObj(list.getResults());
		return j;
	}
	
	@RequestMapping(value="/userPhone")
	public @ResponseBody AjaxJson userPhone(HttpServletRequest request, HttpServletResponse response) throws Exception {
		AjaxJson j = new AjaxJson();
		j.setSuccess(false);
		String phone = request.getParameter("phone");
		String xcxId = request.getParameter("xcxId");
		if(phone!=null&&xcxId!=null){
			LhSAccountEntity lhSAccount=new LhSAccountEntity();
			lhSAccount.setPhone(phone);
			lhSAccount.setAppId(xcxId);
			MiniDaoPage<LhSAccountEntity> list = lhSAccountService.getAll(lhSAccount, 1, 100);
			if(list.getResults()!=null&&list.getResults().size()>0){
				j.setSuccess(true);
				j.setObj(list.getResults().get(0));
			}
		}
		return j;
	}
	
	@RequestMapping(value="/userList")
	public @ResponseBody AjaxJson userList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		AjaxJson j = new AjaxJson();
		j.setSuccess(false);
		String deptid = request.getParameter("deptid");
		String xcxId = request.getParameter("xcxId");
		if(deptid!=null&&xcxId!=null){
			LhSUserEntity lhSUser=new LhSUserEntity();
			lhSUser.setDeptid(deptid);
			lhSUser.setXcxid(xcxId);
			MiniDaoPage<LhSUserEntity> list = lhSUserService.getAll(lhSUser, 1, 100);
			if(list.getResults()!=null&&list.getResults().size()>0){
				j.setSuccess(true);
				j.setObj(list.getResults());
			}
		}
		return j;
	}
	
	@RequestMapping(value= "/login", method = RequestMethod.POST)
	public @ResponseBody AjaxJson login(HttpServletRequest request, @RequestBody LhSUserEntity lhSUser) {
		AjaxJson j = new AjaxJson();
		if(lhSUser.getUsername()!=null&&lhSUser.getPassword()!=null){
			String appId=request.getParameter("xcxId");
			String encryptPass="";
			try{
				LhSAccountEntity lhSAccount = lhSAccountService.getByAppId(appId);
				encryptPass = AES128Util.decrypt(lhSUser.getPassword(), lhSAccount.getAesKey() ,lhSAccount.getIvKey());
				lhSUser.setPassword(PasswordUtil.encrypt(lhSUser.getUsername(), encryptPass, PasswordUtil.getStaticSalt()));

				MiniDaoPage<LhSUserEntity> list = lhSUserService.getAll(lhSUser, 1, 10);
				List<LhSUserEntity> lhSUserList = list.getResults();
				if(lhSUserList.size()==1){
					System.out.println("lhSUserList.size:"+lhSUserList.size()+"个");
					lhSUser=lhSUserList.get(0);
					
					Map<String,Object> attributes=new HashMap<String,Object>();
					attributes.put("login_code", lhSUser.getId());
					attributes.put("status", lhSUser.getStatus());
					j.setAttributes(attributes);
					j.setSuccess(true);
				}else{
					j.setSuccess(false);
				}
			} catch (Exception e) {
				e.printStackTrace();
				j.setSuccess(false);
			}
		}else{
			j.setSuccess(false);
		}
		return j;
	}
	
	@RequestMapping("/smsCodeLogin")
	public @ResponseBody AjaxJson smsCodeLogin(HttpServletRequest request, HttpServletResponse response) {
		AjaxJson j = new AjaxJson();
    	String phone=request.getParameter("phone");
    	String userkey=request.getParameter("userkey");
    	String openid=request.getParameter("openId");
    	String xcxId=request.getParameter("xcxId");
    	String usertype=request.getParameter("usertype");
    	LhSUserEntity lhSUser=new LhSUserEntity();
		try {
	    	if(phone!=null&&userkey!=null){
	        	lhSUser.setPhone(phone);
	        	lhSUser.setUserkey(userkey);
	        	lhSUser.setUsertype(usertype);
				MiniDaoPage<LhSUserEntity> list = lhSUserService.getAll(lhSUser, 1, 10);
				List<LhSUserEntity> lhSUserList = list.getResults();
				if(lhSUserList.size()>0){
					lhSUser=lhSUserList.get(0);
					// 2，短信验证码登录
					lhSUser.setStatus(2);
					lhSUser.setOpenid(openid);
					lhSUser.setXcxid(xcxId);
					lhSUserService.update(lhSUser);
					j.setObj(lhSUser.getId());
					Map<String,Object> attributes=new HashMap<String,Object>();
					attributes.put("status", 2);
					j.setAttributes(attributes);
					j.setSuccess(true);
				}else{
					j.setSuccess(false);
				}
	    	}else{
				j.setSuccess(false);	    		
	    	}
		} catch (Exception e) {
			e.printStackTrace();
			j.setSuccess(false);
		}
		return j;
	}
	
	@RequestMapping(value ="/userRegister", method = RequestMethod.POST)
	public @ResponseBody AjaxJson userRegister(HttpServletRequest request, @RequestBody LhSUserEntity lhSUser) {
		AjaxJson j = new AjaxJson();
		String password = lhSUser.getPassword();
		String deptid=lhSUser.getDeptid();
		try {
			lhSUser=lhSUserService.get(lhSUser.getId());
			Map<String,Object> attributes=new HashMap<String,Object>();
			lhSUser.setPassword(PasswordUtil.encrypt(lhSUser.getUsername(), password, PasswordUtil.getStaticSalt()));
			lhSUser.setDeptid(deptid);
			lhSUser.setStatus(3);
			lhSUserService.update(lhSUser);
			j.setObj(lhSUser.getId());
			attributes.put("status", 3);
			j.setAttributes(attributes);
			j.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			j.setSuccess(false);
		}
		return j;
	}
	
	@RequestMapping("/changeDept")
	public @ResponseBody AjaxJson changeDept(HttpServletRequest request, HttpServletResponse response) {
		AjaxJson j = new AjaxJson();
    	String deptid=request.getParameter("deptid");
		String id = request.getHeader("login-code");
		try {
			LhSUserEntity lhSUser = lhSUserService.get(id);
			lhSUser.setDeptid(deptid);
			lhSUserService.update(lhSUser);
			j.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			j.setSuccess(false);
		}
		return j;
	}
	
	@RequestMapping("/registerCode")
	public @ResponseBody AjaxJson registerCode(HttpServletRequest request, HttpServletResponse response) {
		AjaxJson j = new AjaxJson();
		String id = request.getHeader("login-code");
		LhSUserEntity lhSUser=new LhSUserEntity();
		lhSUser.setId(id);
		try {
			MiniDaoPage<LhSUserEntity> list = lhSUserService.getAll(lhSUser, 1, 10);
			List<LhSUserEntity> lhSUserList = list.getResults();
			if(lhSUserList.size()==1){
				lhSUser=lhSUserList.get(0);
				Map<String,Object> attributes=new HashMap<String,Object>();
				attributes.put("status", lhSUser.getStatus());
				j.setAttributes(attributes);
				j.setSuccess(true);
			}else{
				j.setSuccess(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			j.setSuccess(false);
		}
		return j;
	}

	@RequestMapping("/idCardLogin")
	public @ResponseBody AjaxJson idCardLogin(HttpServletRequest request, HttpServletResponse response) {
		//TODO 验证身份证号接口
		
		AjaxJson j = new AjaxJson();
		try {
    		LhSUserEntity lhSUser=new LhSUserEntity();
			String idcard=request.getParameter("idcard");
			String usertype=request.getParameter("usertype");
			lhSUser.setIdcard(idcard);
			lhSUser.setUsertype(usertype);
			MiniDaoPage<LhSUserEntity> list = lhSUserService.getAll(lhSUser, 1, 10);
			List<LhSUserEntity> lhSUserList = list.getResults();
			if(lhSUserList.size()>0){
				j.setSuccess(false);
				j.setMsg("身份证号已注册");
				return j;
			}
    		String id = request.getHeader("login-code");
    		lhSUser.setId(id);
			String realname= URLDecoder.decode(request.getParameter("realname"),"utf-8");
			
			lhSUser=lhSUserService.get(lhSUser.getId());
			lhSUser.setRealname(realname);
			lhSUser.setIdcard(idcard);
			// 4，身份证验证通过
			lhSUser.setStatus(4);
			lhSUserService.update(lhSUser);
			j.setObj(lhSUser.getId());
			Map<String,Object> attributes=new HashMap<String,Object>();
			attributes.put("status", 4);
			j.setAttributes(attributes);
			j.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			j.setSuccess(false);
		}
		return j;
	}
	
	@RequestMapping("/userInfo")
	public @ResponseBody AjaxJson userInfo(HttpServletRequest request, HttpServletResponse response) {
		AjaxJson j = new AjaxJson();
		String id = request.getHeader("login-code");
		if(id!=null&&id!=""){
			try {
	    		System.out.println("id:"+id);
	    		LhSUserEntity lhSUser=new LhSUserEntity();
	    		lhSUser.setId(id);
				MiniDaoPage<LhSUserEntity> list = lhSUserService.getAll(lhSUser, 1, 10);
				List<LhSUserEntity> lhSUserList = list.getResults();
				if(lhSUserList.size()>0){
		    		System.out.println("lhSUserList.size():-----"+lhSUserList.size());
					lhSUser=lhSUserList.get(0);
	//				Map<String,Object> attributes=new HashMap<String,Object>();
	//				attributes.put("status", lhSUser.getStatus());
	//				j.setAttributes(attributes);
					j.setObj(lhSUser);
					j.setSuccess(true);
				}else{
					j.setSuccess(false);
				}
			} catch (Exception e) {
				e.printStackTrace();
				j.setSuccess(false);
			}
		}else{
			j.setSuccess(false);
		}
		return j;
	}
	
//	@RequestMapping("/userInfo")
//	public @ResponseBody AjaxJson userInfo(HttpServletRequest request, HttpServletResponse response) {
//		AjaxJson j = new AjaxJson();
//		String id = request.getHeader("login-code");
//		if(id!=null&&id!=""){
//			try {
//	    		System.out.println("id:"+id);
//				LhExamStudentEntity examStudent = lhExamStudentService.get(id);
//				j.setObj(examStudent);
//				j.setSuccess(true);
//			} catch (Exception e) {
//				e.printStackTrace();
//				j.setSuccess(false);
//			}
//		}else{
//			j.setSuccess(false);
//		}
//		return j;
//	}
	
	@RequestMapping("/follow")
	public @ResponseBody AjaxJson follow(HttpServletRequest request, HttpServletResponse response) {
		AjaxJson j = new AjaxJson();
    	String phone=request.getParameter("phone");
    	String userkey=request.getParameter("userkey");
    	String openid=request.getParameter("openId");
    	String usertype=request.getParameter("usertype");
    	LhSUserEntity lhSUser=new LhSUserEntity();
		try {
	    	if(phone!=null&&userkey!=null){
	        	lhSUser.setPhone(phone);
	        	lhSUser.setUserkey(userkey);
	        	lhSUser.setUsertype(usertype);
				MiniDaoPage<LhSUserEntity> list = lhSUserService.getAll(lhSUser, 1, 10);
				List<LhSUserEntity> lhSUserList = list.getResults();
				if(lhSUserList.size()>0){
					lhSUser=lhSUserList.get(0);
					String follow = lhSUser.getParent();
					if(follow==null||follow.equals("")){
						lhSUser.setParent(openid);
					}else{
						if(!follow.contains(openid)){
							lhSUser.setParent(follow+","+openid);
						}
					}
					lhSUserService.update(lhSUser);
					j.setObj(lhSUser);
					j.setSuccess(true);
				}else{
					j.setSuccess(false);
				}
	    	}else{
				j.setSuccess(false);	    		
	    	}
		} catch (Exception e) {
			e.printStackTrace();
			j.setSuccess(false);
		}
		return j;
	}
	@RequestMapping("/followCancel")
	public @ResponseBody AjaxJson followCancel(HttpServletRequest request, HttpServletResponse response) {
		AjaxJson j = new AjaxJson();
//    	String phone=request.getParameter("phone");
    	String soid=request.getParameter("soid");
    	String poid=request.getParameter("poid");
    	String usertype=request.getParameter("usertype");
    	LhSUserEntity lhSUser=new LhSUserEntity();
		try {
	    	if(soid!=null&&poid!=null){
	        	lhSUser.setOpenid(soid);
	        	lhSUser.setParent(poid);
	        	lhSUser.setUsertype(usertype);
				MiniDaoPage<LhSUserEntity> list = lhSUserService.getAll(lhSUser, 1, 10);
				List<LhSUserEntity> lhSUserList = list.getResults();
				if(lhSUserList.size()>0){
					lhSUser=lhSUserList.get(0);
					String follow = lhSUser.getParent();
					if(follow.split(",").length==1){
						lhSUser.setParent(follow.replace(poid, ""));
					}
					if(follow.contains(","+poid)){
						lhSUser.setParent(follow.replace(","+poid, ""));
					}
					if(follow.contains(poid+",")){
						lhSUser.setParent(follow.replace(poid+",", ""));
					}
					lhSUserService.update(lhSUser);
					j.setSuccess(true);
				}else{
					j.setSuccess(false);
				}
	    	}else{
				j.setSuccess(false);	    		
	    	}
		} catch (Exception e) {
			e.printStackTrace();
			j.setSuccess(false);
		}
		return j;
	}
	
	@RequestMapping("/userFollow")
	public @ResponseBody AjaxJson userFollow(HttpServletRequest request, HttpServletResponse response) {
		AjaxJson j = new AjaxJson();
		String openId = request.getParameter("openId");
		if(openId!=null&&openId!=""){
			try {
	    		LhSUserEntity lhSUser=new LhSUserEntity();
	    		lhSUser.setParent(openId);
				MiniDaoPage<LhSUserEntity> list = lhSUserService.getAll(lhSUser, 1, 10);
				List<LhSUserEntity> lhSUserList = list.getResults();
				if(lhSUserList.size()>0){
					lhSUser=lhSUserList.get(0);
					j.setObj(lhSUser);
					j.setSuccess(true);
				}else{
					j.setSuccess(false);
				}
			} catch (Exception e) {
				e.printStackTrace();
				j.setSuccess(false);
			}
		}else{
			j.setSuccess(false);
		}
		return j;
	}

}

