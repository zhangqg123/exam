package com.jeecg.exam.service;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import com.jeecg.exam.entity.LhTaskEntity;

/**
 * 描述：作业表
 * @author: www.jeecg.org
 * @since：2019年02月13日 09时42分47秒 星期三 
 * @version:1.0
 */
public interface LhTaskService {
	public LhTaskEntity get(String id);

	public int update(LhTaskEntity lhTask);

	public void insert(LhTaskEntity lhTask);

	public MiniDaoPage<LhTaskEntity> getAll(LhTaskEntity lhTask,int page,int rows);

	public void delete(String id);
	
	public void batchDelete(String[] ids);
	
}
