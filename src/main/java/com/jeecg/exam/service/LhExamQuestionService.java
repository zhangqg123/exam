package com.jeecg.exam.service;

import java.util.List;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.pojo.MiniDaoPage;

import com.jeecg.exam.entity.LhExamQuestionEntity;

/**
 * 描述：考试试题表
 * @author: www.jeecg.org
 * @since：2018年12月28日 08时22分27秒 星期五 
 * @version:1.0
 */
public interface LhExamQuestionService {
	public LhExamQuestionEntity get(String id);

	public int update(LhExamQuestionEntity lhExamQuestion);

	public void insert(LhExamQuestionEntity lhExamQuestion);

	public MiniDaoPage<LhExamQuestionEntity> getAll(LhExamQuestionEntity lhExamQuestion,int page,int rows);

	public void delete(String id);
	
	public void batchDelete(String[] ids);
	
	public void batchSelect(String[] ids, String examId);

	public List<LhExamQuestionEntity> getExamIds(String ids);

	public List<LhExamQuestionEntity> getQuestionIds(String ids);
	
}
