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
import com.jeecg.exam.service.LhExamQuestionService;
import com.jeecg.exam.service.LhExamService;
import com.jeecg.exam.service.LhQuestionColumnService;

 /**
 * 描述：考试表
 * @author: www.jeecg.org
 * @since：2018年12月26日 07时46分03秒 星期三 
 * @version:1.0
 */
@Controller
@RequestMapping("/jeecg/lhExam")
public class LhExamController extends BaseController{
  @Autowired
  private LhExamService lhExamService;
  @Autowired
  private LhQuestionColumnService lhQuestionColumnService;
  @Autowired
  private LhExamQuestionService lhExamQuestionService;

	/**
	  * 列表页面
	  * @return
	  */
	@RequestMapping(params = "list",method = {RequestMethod.GET,RequestMethod.POST})
	public void list(@ModelAttribute LhExamEntity query,HttpServletRequest request,HttpServletResponse response,
			@RequestParam(required = false, value = "pageNo", defaultValue = "1") int pageNo,
			@RequestParam(required = false, value = "pageSize", defaultValue = "10") int pageSize) throws Exception{
			try {
			 	LOG.info(request, " back list");
			 	//分页数据
				String rolecodes=(String) request.getSession().getAttribute("rolecodes");
				String userName=(String) request.getSession().getAttribute("loginUserName");
				if(rolecodes.contains("exam")){
					query.setCreateBy(userName);
				}
				MiniDaoPage<LhExamEntity> list =  lhExamService.getAll(query,pageNo,pageSize);
				MiniDaoPage<LhQuestionColumnEntity> qclist =  lhQuestionColumnService.getAll(new LhQuestionColumnEntity(),1,199);
				List<LhQuestionColumnEntity> columnList = qclist.getResults();
				VelocityContext velocityContext = new VelocityContext();
				velocityContext.put("lhExam",query);
				velocityContext.put("columnList",columnList);
				velocityContext.put("pageInfos",SystemTools.convertPaginatedList(list));
				String viewName = "jeecg/exam/lhExam-list.vm";
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
	public void lhExamDetail(@RequestParam(required = true, value = "id" ) String id,HttpServletResponse response,HttpServletRequest request)throws Exception{
			VelocityContext velocityContext = new VelocityContext();
			String viewName = "jeecg/exam/lhExam-detail.vm";
			LhExamEntity lhExam = lhExamService.get(id);
			velocityContext.put("lhExam",lhExam);
			ViewVelocity.view(request,response,viewName,velocityContext);
	}

	/**
	 * 跳转到添加页面
	 * @return
	 */
	@RequestMapping(params = "toAdd",method ={RequestMethod.GET, RequestMethod.POST})
	public void toAddDialog(HttpServletRequest request,HttpServletResponse response)throws Exception{
		String rolecodes=(String) request.getSession().getAttribute("rolecodes");
		String userName=(String) request.getSession().getAttribute("loginUserName");
		LhQuestionColumnEntity lhQuestionColumn=new LhQuestionColumnEntity();
		if(rolecodes.contains("exam")){
			lhQuestionColumn.setOwner(userName);
		}
		MiniDaoPage<LhQuestionColumnEntity> list =  lhQuestionColumnService.getAll(lhQuestionColumn,1,199);
		List<LhQuestionColumnEntity> columnList = list.getResults();
		VelocityContext velocityContext = new VelocityContext();
		velocityContext.put("columnList",columnList);
		String viewName = "jeecg/exam/lhExam-add.vm";
		ViewVelocity.view(request,response,viewName,velocityContext);
	}

	/**
	 * 保存信息
	 * @return
	 */
	@RequestMapping(params = "doAdd",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson doAdd(HttpServletRequest request,@ModelAttribute LhExamEntity lhExam){
		AjaxJson j = new AjaxJson();
		String userName=(String) request.getSession().getAttribute("loginUserName");		
		lhExam.setCreateBy(userName);
		lhExam.setCreateDate(new Date());
		try {
			lhExamService.insert(lhExam);
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
		String rolecodes=(String) request.getSession().getAttribute("rolecodes");
		String userName=(String) request.getSession().getAttribute("loginUserName");
		LhQuestionColumnEntity lhQuestionColumn=new LhQuestionColumnEntity();
		if(rolecodes.contains("exam")){
			lhQuestionColumn.setOwner(userName);
		}
		MiniDaoPage<LhQuestionColumnEntity> list =  lhQuestionColumnService.getAll(lhQuestionColumn,1,199);
		List<LhQuestionColumnEntity> columnList = list.getResults();
		VelocityContext velocityContext = new VelocityContext();
		LhExamEntity lhExam = lhExamService.get(id);
		velocityContext.put("columnList",columnList);
		velocityContext.put("lhExam",lhExam);
		String viewName = "jeecg/exam/lhExam-edit.vm";
		ViewVelocity.view(request,response,viewName,velocityContext);
	}

	/**
	 * 编辑
	 * @return
	 */
	@RequestMapping(params = "doEdit",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson doEdit(HttpServletRequest request,@ModelAttribute LhExamEntity lhExam){
		AjaxJson j = new AjaxJson();
		String userName=(String) request.getSession().getAttribute("loginUserName");		
		lhExam.setCreateBy(userName);
		lhExam.setCreateDate(new Date());
		try {
			lhExamService.update(lhExam);
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
				List<LhExamQuestionEntity> list=lhExamQuestionService.getExamIds(id);
				if(list.size()>0){
					j.setMsg("考试中题目未清空");
				}else{
					lhExamService.delete(id);
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
		StringBuffer sb = new StringBuffer();

		for (String string : ids) {
	        sb.append(string);
		    sb.append(",");
	    }
		String str = sb.toString().substring(0,sb.toString().length()-1);
		try {
			List<LhExamQuestionEntity> list=lhExamQuestionService.getExamIds(str);
			if(list.size()>0){
				j.setMsg("考试中有 "+list.size()+" 道试题未清空");				
			}else{
				lhExamService.batchDelete(ids);
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

