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
import com.jeecg.exam.service.LhExamService;
import com.jeecg.exam.service.LhQuestionColumnService;
import com.jeecg.exam.service.LhQuestionService;

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
	public @ResponseBody String examList(@ModelAttribute LhExamEntity query, HttpServletRequest request, HttpServletResponse response ,
			@RequestParam(required = false, value = "pageNumber", defaultValue = "1") int pageNo,
			@RequestParam(required = false, value = "pageSize", defaultValue = "6") int pageSize) throws Exception {
		String guideStatus = request.getParameter("guide_status");
		String questionColumn = request.getParameter("category_id");
		if(questionColumn!=null && questionColumn!="" && !questionColumn.equals("all")){
			query.setQuestionColumn(questionColumn);
		}
		MiniDaoPage<LhExamEntity> list = lhExamService.getAll(query, pageNo, pageSize);
		// 分页数据
		List<?> resut = list.getResults();
		return JSONArray.toJSONString(resut);
	}
	
	@RequestMapping(value="/questionList")
	public @ResponseBody String questionList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String examId = request.getParameter("examId");
		List<LhQuestionEntity> result = lhQuestionService.questionByExamId(examId);
		return JSONArray.toJSONString(result);
	}
	
//	@RequestMapping(value="/subChoose")
//	public @ResponseBody String subChoose(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		String param = request.getParameter("param");
//		String openId = request.getParameter("openId");
//		String examId = request.getParameter("examId");
//		int totalScore = lhExamService.countScore(param,openId,examId);
////		List<LhQuestionEntity> result = lhQuestionService.questionByExamId(examId);
//		return JSONArray.toJSONString(totalScore);
//	}
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

