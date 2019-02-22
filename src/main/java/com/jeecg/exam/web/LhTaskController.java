package com.jeecg.exam.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.jeecg.exam.entity.LhQuestionColumnEntity;
import com.jeecg.exam.entity.LhTaskEntity;
import com.jeecg.exam.service.LhExamService;
import com.jeecg.exam.service.LhQuestionColumnService;
import com.jeecg.exam.service.LhTaskService;
import com.jeecg.lhs.entity.LhSUserEntity;
import com.jeecg.lhs.service.LhSUserService;

 /**
 * 描述：作业表
 * @author: www.jeecg.org
 * @since：2019年02月13日 09时42分47秒 星期三 
 * @version:1.0
 */
@Controller
@RequestMapping("/jeecg/lhTask")
public class LhTaskController extends BaseController{
  @Autowired
  private LhTaskService lhTaskService;
  @Autowired
  private LhExamService lhExamService;
  @Autowired
  private LhQuestionColumnService lhQuestionColumnService;
  @Autowired
  private LhSUserService lhSUserService;
  
	/**
	  * 列表页面
	  * @return
	  */
	@RequestMapping(params = "list",method = {RequestMethod.GET,RequestMethod.POST})
	public void list(@ModelAttribute LhTaskEntity query,HttpServletRequest request,HttpServletResponse response,
			@RequestParam(required = false, value = "pageNo", defaultValue = "1") int pageNo,
			@RequestParam(required = false, value = "pageSize", defaultValue = "10") int pageSize) throws Exception{
			try {
			 	LOG.info(request, " back list");
			 	//分页数据
				LhSUserEntity lhSUser=new LhSUserEntity();
				MiniDaoPage<LhSUserEntity> slist = lhSUserService.getAll(lhSUser, 1, 200); 
				List<LhSUserEntity> lhSUserList = slist.getResults();
				MiniDaoPage<LhTaskEntity> list =  lhTaskService.getAll(query,pageNo,pageSize);
				VelocityContext velocityContext = new VelocityContext();
				velocityContext.put("lhTask",query);
				velocityContext.put("lhSUserList",lhSUserList);
				velocityContext.put("pageInfos",SystemTools.convertPaginatedList(list));
				String viewName = "jeecg/exam/lhTask-list.vm";
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
	public void lhTaskDetail(@RequestParam(required = true, value = "id" ) String id,HttpServletResponse response,HttpServletRequest request)throws Exception{
			VelocityContext velocityContext = new VelocityContext();
			String viewName = "jeecg/exam/lhTask-detail.vm";
			LhTaskEntity lhTask = lhTaskService.get(id);
			velocityContext.put("lhTask",lhTask);
			ViewVelocity.view(request,response,viewName,velocityContext);
	}

	/**
	 * 跳转到添加页面
	 * @return
	 */
	@RequestMapping(params = "toAdd",method ={RequestMethod.GET, RequestMethod.POST})
	public void toAddDialog(HttpServletRequest request,HttpServletResponse response)throws Exception{
		LhSUserEntity lhSUser=new LhSUserEntity();
		MiniDaoPage<LhSUserEntity> list = lhSUserService.getAll(lhSUser, 1, 200); 
		List<LhSUserEntity> lhSUserList = list.getResults();
		VelocityContext velocityContext = new VelocityContext();
		String viewName = "jeecg/exam/lhTask-add.vm";
		velocityContext.put("lhSUserList",lhSUserList);
		ViewVelocity.view(request,response,viewName,velocityContext);
	}

	/**
	 * 保存信息
	 * @return
	 */
	@RequestMapping(params = "doAdd",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson doAdd(HttpServletRequest request,@ModelAttribute LhTaskEntity lhTask){
		AjaxJson j = new AjaxJson();
		String userName=(String) request.getSession().getAttribute("loginUserName");		
		lhTask.setCreateBy(userName);
		lhTask.setCreateDate(new Date());
		try {
			lhTaskService.insert(lhTask);
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
		LhSUserEntity lhSUser=new LhSUserEntity();
		MiniDaoPage<LhSUserEntity> list = lhSUserService.getAll(lhSUser, 1, 200); 
		List<LhSUserEntity> lhSUserList = list.getResults();
		VelocityContext velocityContext = new VelocityContext();
		LhTaskEntity lhTask = lhTaskService.get(id);
		velocityContext.put("lhTask",lhTask);
		velocityContext.put("lhSUserList",lhSUserList);
		String viewName = "jeecg/exam/lhTask-edit.vm";
		ViewVelocity.view(request,response,viewName,velocityContext);
	}

	/**
	 * 编辑
	 * @return
	 */
	@RequestMapping(params = "doEdit",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson doEdit(@ModelAttribute LhTaskEntity lhTask){
		AjaxJson j = new AjaxJson();
		try {
			lhTaskService.update(lhTask);
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
				lhTaskService.delete(id);
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
			lhTaskService.batchDelete(ids);
			j.setMsg("批量删除成功");
		} catch(Exception e) {
			j.setSuccess(false);
			j.setMsg("批量删除失败");
			e.printStackTrace();
		}
		return j;
	}
	
	@RequestMapping(params="getAuthTree",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson getAuthTree(HttpServletResponse response,HttpServletRequest request ){
		AjaxJson j = new AjaxJson();
		try{
			LhExamEntity lhExam=new LhExamEntity();
			LhQuestionColumnEntity lhqc=new LhQuestionColumnEntity();
			MiniDaoPage<LhQuestionColumnEntity> qcList = lhQuestionColumnService.getAll(lhqc, 1, 100);
			List<LhQuestionColumnEntity> qcAuthList=qcList.getResults();
			List<Map> list=new ArrayList<Map>();
			for (LhQuestionColumnEntity  qc:qcAuthList) {
				String id=qc.getId();
				String parentid = qc.getParentCode();
				String name = qc.getColumnName();
				String open="false";
				Map<String, String> map = new HashMap<String, String>();
				map.put("id", id);
				map.put("pId", parentid);
				map.put("name", name);
				map.put("open",open );
				list.add(map);
			}
			MiniDaoPage<LhExamEntity> allList = lhExamService.getAll(lhExam, 1, 1000);
			List<LhExamEntity> allAuthList=allList.getResults();
			for (LhExamEntity  authList:allAuthList) {
				String id=authList.getId();
				String parentid = authList.getQuestionColumn();
				String name = authList.getExamName();
				String open="false";
				Map<String, String> map = new HashMap<String, String>();
				map.put("id", id);
				map.put("pId", parentid);
				map.put("name", name);
				map.put("open",open );
				list.add(map);
			}
			j.setObj(list);
			
	} catch (Exception e) {
	    log.info(e.getMessage());
		j.setSuccess(false);
		j.setMsg("显示失败!");
	}
		return j;
	
	}

}

