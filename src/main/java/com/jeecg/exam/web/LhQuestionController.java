package com.jeecg.exam.web;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.VelocityContext;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.jeecgframework.p3.core.common.utils.AjaxJson;
import org.jeecgframework.p3.core.page.SystemTools;
import org.jeecgframework.p3.core.util.plugin.ViewVelocity;
import org.jeecgframework.p3.core.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeecg.exam.entity.LhExamEntity;
import com.jeecg.exam.entity.LhExamQuestionEntity;
import com.jeecg.exam.entity.LhQuestionColumnEntity;
import com.jeecg.exam.entity.LhQuestionEntity;
import com.jeecg.exam.service.LhExamQuestionService;
import com.jeecg.exam.service.LhExamService;
import com.jeecg.exam.service.LhQuestionColumnService;
import com.jeecg.exam.service.LhQuestionService;

 /**
 * 描述：试题表
 * @author: www.jeecg.org
 * @since：2018年12月24日 09时58分22秒 星期一 
 * @version:1.0
 */
@Controller
@RequestMapping("/jeecg/lhQuestion")
public class LhQuestionController extends BaseController{
  @Autowired
  private LhQuestionService lhQuestionService;
  @Autowired
  private LhQuestionColumnService lhQuestionColumnService;
  @Autowired
  private LhExamService lhExamService;
  @Autowired
  private LhExamQuestionService lhExamQuestionService;
   
	/**
	  * 列表页面
	  * @return
	  */
	@RequestMapping(params = "list",method = {RequestMethod.GET,RequestMethod.POST})
	public void list(@ModelAttribute LhQuestionEntity query,HttpServletRequest request,HttpServletResponse response,
			@RequestParam(required = false, value = "pageNo", defaultValue = "1") int pageNo,
			@RequestParam(required = false, value = "pageSize", defaultValue = "10") int pageSize) throws Exception{
			try {
			 	LOG.info(request, " back list");
			 	//分页数据
				MiniDaoPage<LhQuestionEntity> list =  lhQuestionService.getAll(query,pageNo,pageSize);
				VelocityContext velocityContext = new VelocityContext();
				MiniDaoPage<LhQuestionColumnEntity> colList =  lhQuestionColumnService.getAll(new LhQuestionColumnEntity(),1,199);
				List<LhQuestionColumnEntity> columnList = colList.getResults();
				velocityContext.put("columnList",columnList);
				velocityContext.put("lhQuestion",query);
				velocityContext.put("pageInfos",SystemTools.convertPaginatedList(list));
				String viewName = "jeecg/exam/lhQuestion-list.vm";
				ViewVelocity.view(request,response,viewName,velocityContext);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	@RequestMapping(params = "questionList",method = {RequestMethod.GET,RequestMethod.POST})
	public void questionList(@ModelAttribute LhQuestionEntity query,HttpServletRequest request,HttpServletResponse response,
			@RequestParam(required = false, value = "pageNo", defaultValue = "1") int pageNo,
			@RequestParam(required = false, value = "pageSize", defaultValue = "10") int pageSize) throws Exception{
			try {
			 	LOG.info(request, " back list");
			 	String examId = request.getParameter("examId");
			 	if(examId!=null){
				 	LhExamEntity exam = lhExamService.get(examId);
				 	query.setColumnId(exam.getQuestionColumn());
			 	}
			 	//分页数据
				MiniDaoPage<LhQuestionEntity> list =  lhQuestionService.getAll(query,pageNo,pageSize);
				VelocityContext velocityContext = new VelocityContext();
				MiniDaoPage<LhQuestionColumnEntity> colList =  lhQuestionColumnService.getAll(new LhQuestionColumnEntity(),1,199);
				List<LhQuestionColumnEntity> columnList = colList.getResults();
				velocityContext.put("columnList",columnList);
				velocityContext.put("lhQuestion",query);
				velocityContext.put("pageInfos",SystemTools.convertPaginatedList(list));
				String viewName = "jeecg/exam/questionList.vm";
				ViewVelocity.view(request,response,viewName,velocityContext);
			} catch (Exception e) {
				e.printStackTrace();
			}
}

	 /**
	  * 详情
	  * @return
	  */
	@RequestMapping(params="toDetail",method = RequestMethod.GET)
	public void lhQuestionDetail(@RequestParam(required = true, value = "id" ) String id,HttpServletResponse response,HttpServletRequest request)throws Exception{
			VelocityContext velocityContext = new VelocityContext();
			String viewName = "jeecg/exam/lhQuestion-detail.vm";
			LhQuestionEntity lhQuestion = lhQuestionService.get(id);
			velocityContext.put("lhQuestion",lhQuestion);
			ViewVelocity.view(request,response,viewName,velocityContext);
	}

	/**
	 * 跳转到添加页面
	 * @return
	 */
	@RequestMapping(params = "toAdd",method ={RequestMethod.GET, RequestMethod.POST})
	public void toAddDialog(HttpServletRequest request,HttpServletResponse response)throws Exception{
		MiniDaoPage<LhQuestionColumnEntity> list =  lhQuestionColumnService.getAll(new LhQuestionColumnEntity(),1,199);
		List<LhQuestionColumnEntity> columnList = list.getResults();
		VelocityContext velocityContext = new VelocityContext();
		velocityContext.put("columnList",columnList);
		String viewName = "jeecg/exam/lhQuestion-add.vm";
		ViewVelocity.view(request,response,viewName,velocityContext);
	}

	/**
	 * 保存信息
	 * @return
	 */
	@RequestMapping(params = "doAdd",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson doAdd(HttpServletRequest request ,@ModelAttribute LhQuestionEntity lhQuestion){
		AjaxJson j = new AjaxJson();
		String userName=(String) request.getSession().getAttribute("loginUserName");		
		lhQuestion.setCreateBy(userName);
		lhQuestion.setCreateDate(new Date());
		try {
			lhQuestionService.insert(lhQuestion);
			j.setMsg("保存成功");
		} catch (Exception e) {
			j.setSuccess(false);
			j.setMsg("保存失败");
		    e.printStackTrace();
		}
		return j;
	}

	/**
	 * 跳转到编辑页面
	 * @return
	 */
	@RequestMapping(params="toEdit",method = RequestMethod.GET)
	public void toEdit(@RequestParam(required = true, value = "id" ) String id,HttpServletResponse response,HttpServletRequest request) throws Exception{
		MiniDaoPage<LhQuestionColumnEntity> list =  lhQuestionColumnService.getAll(new LhQuestionColumnEntity(),1,199);
		List<LhQuestionColumnEntity> columnList = list.getResults();
		 VelocityContext velocityContext = new VelocityContext();
		 LhQuestionEntity lhQuestion = lhQuestionService.get(id);
		 String[] questionList = null;
		 if(lhQuestion!=null){
			 questionList = lhQuestion.getChooseAnswer().split("\\$\\$");
		 }
		 velocityContext.put("questionList",questionList);			 
		 velocityContext.put("columnList",columnList);			 
		 velocityContext.put("lhQuestion",lhQuestion);
		 String viewName = "jeecg/exam/lhQuestion-edit.vm";
		 ViewVelocity.view(request,response,viewName,velocityContext);
	}

	/**
	 * 编辑
	 * @return
	 */
	@RequestMapping(params = "doEdit",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson doEdit(@ModelAttribute LhQuestionEntity lhQuestion){
		AjaxJson j = new AjaxJson();
		if(lhQuestion.getType().equals("formula")){
			lhQuestion.setChooseAnswer("");
		}
		try {
			lhQuestionService.update(lhQuestion);
			j.setMsg("编辑成功");
		} catch (Exception e) {
			j.setSuccess(false);
			j.setMsg("编辑失败");
		    e.printStackTrace();
		}
		return j;
	}


	/**
	 * 删除
	 * @return
	 */
	@RequestMapping(params="doDelete",method = RequestMethod.GET)
	@ResponseBody
	public AjaxJson doDelete(@RequestParam(required = true, value = "id" ) String id){
			AjaxJson j = new AjaxJson();
			try {
				List<LhExamQuestionEntity> list=lhExamQuestionService.getQuestionIds(id);
				if(list.size()>0){
					j.setMsg("题目已被采用");
				}else{
					lhQuestionService.delete(id);
					j.setMsg("删除成功");
				}
			} catch (Exception e) {
				j.setSuccess(false);
				j.setMsg("删除失败");
			    e.printStackTrace();
			}
			return j;
	}
	
	/**
	 * 批量删除数据
	 * @param ids
	 * @return
	 */
	@RequestMapping(params="batchDelete",method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson batchDelete(@RequestParam(required = true, value = "ids") String[] ids) {
		AjaxJson j = new AjaxJson();
		try {
			StringBuffer sb = new StringBuffer();

			for (String string : ids) {
		        sb.append(string);
			    sb.append(",");
		    }
			String str = sb.toString().substring(0,sb.toString().length()-1);
			List<LhExamQuestionEntity> list=lhExamQuestionService.getQuestionIds(str);
			if(list.size()>0){
				j.setMsg("有 "+list.size()+" 道试题已被采用");				
			}else{
				lhQuestionService.batchDelete(ids);
				j.setMsg("批量删除成功");
			}
		} catch(Exception e) {
			j.setSuccess(false);
			j.setMsg("批量删除失败");
			e.printStackTrace();
		}
		return j;
	}

}

