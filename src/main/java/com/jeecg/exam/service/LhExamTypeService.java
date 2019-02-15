package com.jeecg.exam.service;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import com.jeecg.exam.entity.LhExamTypeEntity;

/**
 * 描述：考试分类表
 * @author: www.jeecg.org
 * @since：2019年02月13日 09时07分44秒 星期三 
 * @version:1.0
 */
public interface LhExamTypeService {
	public LhExamTypeEntity get(String id);

	public int update(LhExamTypeEntity lhExamType);

	public void insert(LhExamTypeEntity lhExamType);

	public MiniDaoPage<LhExamTypeEntity> getAll(LhExamTypeEntity lhExamType,int page,int rows);

	public void delete(String id);
	
	public void batchDelete(String[] ids);
	
}
