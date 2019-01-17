package com.jeecg.exam.web;

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
import com.jeecg.exam.entity.LhQuestionEntity;
import com.jeecg.exam.service.LhExamQuestionService;
import com.jeecg.exam.service.LhExamService;
import com.jeecg.exam.service.LhQuestionService;

 /**
 * 描述：考试试题表
 * @author: www.jeecg.org
 * @since：2018年12月28日 08时22分27秒 星期五 
 * @version:1.0
 */
@Controller
@RequestMapping("/jeecg/lhExamQuestion")
public class LhExamQuestionController extends BaseController{
  @Autowired
  private LhExamQuestionService lhExamQuestionService;
  @Autowired
  private LhExamService lhExamService;
  @Autowired
  private LhQuestionService lhQuestionService;
 
	/**
	  * 列表页面
	  * @return
	  */
	@RequestMapping(params = "list",method = {RequestMethod.GET,RequestMethod.POST})
	public void list(@ModelAttribute LhExamQuestionEntity query,HttpServletRequest request,HttpServletResponse response,
			@RequestParam(required = false, value = "pageNo", defaultValue = "1") int pageNo,
			@RequestParam(required = false, value = "pageSize", defaultValue = "10") int pageSize) throws Exception{
			try {
			 	LOG.info(request, " back list");
			 	//分页数据
				MiniDaoPage<LhExamQuestionEntity> list =  lhExamQuestionService.getAll(query,pageNo,pageSize);
				LhExamEntity exam = lhExamService.get(query.getExamId());
				MiniDaoPage<LhQuestionEntity> quList =  lhQuestionService.getAll(new LhQuestionEntity(),1,9999);
				VelocityContext velocityContext = new VelocityContext();
				velocityContext.put("exam",exam);
				velocityContext.put("questionList",quList.getResults());
				velocityContext.put("pageInfos",SystemTools.convertPaginatedList(list));
				String viewName = "jeecg/exam/lhExamQuestion-list.vm";
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
	public void lhExamQuestionDetail(@RequestParam(required = true, value = "id" ) String id,HttpServletResponse response,HttpServletRequest request)throws Exception{
			VelocityContext velocityContext = new VelocityContext();
			String viewName = "jeecg/exam/lhExamQuestion-detail.vm";
			LhExamQuestionEntity lhExamQuestion = lhExamQuestionService.get(id);
			velocityContext.put("lhExamQuestion",lhExamQuestion);
			ViewVelocity.view(request,response,viewName,velocityContext);
	}

	/**
	 * 跳转到添加页面
	 * @return
	 */
	@RequestMapping(params = "toAdd",method ={RequestMethod.GET, RequestMethod.POST})
	public void toAddDialog(HttpServletRequest request,HttpServletResponse response)throws Exception{
		 VelocityContext velocityContext = new VelocityContext();
		 String viewName = "jeecg/exam/lhExamQuestion-add.vm";
		 ViewVelocity.view(request,response,viewName,velocityContext);
	}

	/**
	 * 保存信息
	 * @return
	 */
	@RequestMapping(params = "doAdd",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson doAdd(@ModelAttribute LhExamQuestionEntity lhExamQuestion){
		AjaxJson j = new AjaxJson();
		try {
			lhExamQuestionService.insert(lhExamQuestion);
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
			 VelocityContext velocityContext = new VelocityContext();
			 LhExamQuestionEntity lhExamQuestion = lhExamQuestionService.get(id);
			 velocityContext.put("lhExamQuestion",lhExamQuestion);
			 String viewName = "jeecg/exam/lhExamQuestion-edit.vm";
			 ViewVelocity.view(request,response,viewName,velocityContext);
	}

	/**
	 * 编辑
	 * @return
	 */
	@RequestMapping(params = "doEdit",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson doEdit(@ModelAttribute LhExamQuestionEntity lhExamQuestion){
		AjaxJson j = new AjaxJson();
		try {
			lhExamQuestionService.update(lhExamQuestion);
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
				lhExamQuestionService.delete(id);
				j.setMsg("删除成功");
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
			lhExamQuestionService.batchDelete(ids);
			j.setMsg("批量删除成功");
		} catch(Exception e) {
			j.setSuccess(false);
			j.setMsg("批量删除失败");
			e.printStackTrace();
		}
		return j;
	}

	@RequestMapping(params="batchSelect",method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson batchSelect(@RequestParam(required = true, value = "ids") String[] ids,@RequestParam(required = true, value = "examId") String examId) {
		AjaxJson j = new AjaxJson();
		try {
			lhExamQuestionService.batchSelect(ids,examId);
			j.setMsg("选题成功");
		} catch(Exception e) {
			j.setSuccess(false);
			j.setMsg("选题失败");
			e.printStackTrace();
		}
		return j;
	}
}

