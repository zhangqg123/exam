package com.jeecg.exam.service;

import java.util.List;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.pojo.MiniDaoPage;

import com.jeecg.exam.entity.LhQuestionEntity;

/**
 * 描述：试题表
 * @author: www.jeecg.org
 * @since：2018年12月24日 09时58分22秒 星期一 
 * @version:1.0
 */
public interface LhQuestionService {
	public LhQuestionEntity get(String id);

	public int update(LhQuestionEntity lhQuestion);

	public void insert(LhQuestionEntity lhQuestion);

	public MiniDaoPage<LhQuestionEntity> getAll(LhQuestionEntity lhQuestion,int page,int rows);

	public void delete(String id);
	
	public void batchDelete(String[] ids);

	public List<LhQuestionEntity> questionByExamId(String examId);
	
}
