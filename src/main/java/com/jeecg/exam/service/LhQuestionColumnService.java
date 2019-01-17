package com.jeecg.exam.service;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import com.jeecg.exam.entity.LhQuestionColumnEntity;

/**
 * 描述：试题分类表
 * @author: www.jeecg.org
 * @since：2018年12月27日 06时15分19秒 星期四 
 * @version:1.0
 */
public interface LhQuestionColumnService {
	public LhQuestionColumnEntity get(String id);

	public int update(LhQuestionColumnEntity lhQuestionColumn);

	public void insert(LhQuestionColumnEntity lhQuestionColumn);

	public MiniDaoPage<LhQuestionColumnEntity> getAll(LhQuestionColumnEntity lhQuestionColumn,int page,int rows);

	public void delete(String id);
	
	public void batchDelete(String[] ids);
	
}
