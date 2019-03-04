package com.jeecg.exam.web.api;

import java.util.List;

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
import com.jeecg.exam.entity.LhQuestionColumnEntity;
import com.jeecg.exam.entity.LhQuestionEntity;
import com.jeecg.exam.entity.LhTaskEntity;
import com.jeecg.exam.service.LhExamScoreService;
import com.jeecg.exam.service.LhExamService;
import com.jeecg.exam.service.LhQuestionColumnService;
import com.jeecg.exam.service.LhQuestionService;
import com.jeecg.exam.service.LhTaskService;
import com.jeecg.lhs.entity.LhSUserEntity;
import com.jeecg.lhs.service.LhSUserService;

 /**
 * 描述：考试表
 * @author: www.jeecg.org
 * @since：2018年12月26日 07时46分03秒 星期三 
 * @version:1.0
 */
@Controller
@RequestMapping("/work/exam")
public class LhWorkExamController extends BaseController{
  @Autowired
  private LhExamService lhExamService;
  @Autowired
  private LhQuestionService lhQuestionService;
  @Autowired
  private LhQuestionColumnService lhQuestionColumnService;
  @Autowired
  private LhExamScoreService lhExamScoreService;
  @Autowired
  private LhTaskService lhTaskService;
  @Autowired
  private LhSUserService lhSUserService;

	@RequestMapping(value="/columnList")
	public @ResponseBody String columnList(@ModelAttribute LhQuestionColumnEntity query, HttpServletRequest request, HttpServletResponse response) throws Exception {
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
	public @ResponseBody AjaxJson examList(@ModelAttribute LhExamEntity query, HttpServletRequest request, HttpServletResponse response ,
			@RequestParam(required = false, value = "pageNumber", defaultValue = "1") int pageNo,
			@RequestParam(required = false, value = "pageSize", defaultValue = "6") int pageSize) throws Exception {
		AjaxJson j = new AjaxJson();
		String guideStatus = request.getParameter("guide_status");
		String questionColumn = request.getParameter("category_id");
		if(questionColumn!=null && questionColumn!="" && !questionColumn.equals("all")){
			query.setQuestionColumn(questionColumn);
		}
		MiniDaoPage<LhExamEntity> list = lhExamService.getAll(query, pageNo, pageSize);
		// 分页数据
//		List<?> resut = list.getResults();
		j.setObj(list.getResults());
		return j;
	}
	
	@RequestMapping(value="/assignList")
	public @ResponseBody AjaxJson assignList(@ModelAttribute LhTaskEntity query, HttpServletRequest request, HttpServletResponse response ,
			@RequestParam(required = false, value = "pageNumber", defaultValue = "1") int pageNo,
			@RequestParam(required = false, value = "pageSize", defaultValue = "6") int pageSize) throws Exception {
		AjaxJson j = new AjaxJson();
		String id = request.getHeader("login-code");
		LhSUserEntity lhSUser = lhSUserService.get(id);
		if(lhSUser!=null){
			String assign = lhSUser.getDeptid();
			if(assign!=null&&assign!=""){
				query.setAssign(assign);
				MiniDaoPage<LhTaskEntity> list = lhTaskService.getAll(query, pageNo, pageSize);
				// 分页数据
		//		List<?> resut = list.getResults();
				j.setObj(list.getResults());
			}
		}
		return j;
	}
	
	@RequestMapping(value="/questionList")
	public @ResponseBody String questionList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String examId = request.getParameter("examId");
		List<LhQuestionEntity> result = lhQuestionService.questionByExamId(examId);
		return JSONArray.toJSONString(result);
	}
	
	
	@RequestMapping(value="/scoreList")
	public @ResponseBody AjaxJson scoreList(@ModelAttribute LhExamScoreEntity query, HttpServletRequest request, HttpServletResponse response,
			@RequestParam(required = false, value = "pageNumber", defaultValue = "1") int pageNo,
			@RequestParam(required = false, value = "pageSize", defaultValue = "6") int pageSize) throws Exception {
			//分页数据
		AjaxJson j = new AjaxJson();
		MiniDaoPage<LhExamScoreEntity> list =  lhExamScoreService.getAll(query, pageNo, pageSize);
		j.setObj(list.getResults());
		return j;
	}

	@RequestMapping(value="/queryScore")
	public @ResponseBody String queryScore(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String openId = request.getParameter("openId");
		String examId = request.getParameter("examId");
		LhExamScoreEntity lhExamScore = lhExamService.queryScore(openId,examId);
		String retScore="fail";
		if(lhExamScore!=null){
			retScore=lhExamScore.getScore().toString();
			return String.valueOf(retScore);
		}
		return retScore;
	}
	

}

