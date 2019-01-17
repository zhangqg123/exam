package com.jeecg.exam.service;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.pojo.MiniDaoPage;

import com.alibaba.fastjson.JSONArray;
import com.jeecg.exam.entity.LhExamEntity;
import com.jeecg.exam.entity.LhExamScoreEntity;

/**
 * 描述：考试表
 * @author: www.jeecg.org
 * @since：2018年12月26日 07时46分03秒 星期三 
 * @version:1.0
 */
public interface LhExamService {
	public LhExamEntity get(String id);

	public int update(LhExamEntity lhExam);

	public void insert(LhExamEntity lhExam);

	public MiniDaoPage<LhExamEntity> getAll(LhExamEntity lhExam,int page,int rows);

	public void delete(String id);
	
	public void batchDelete(String[] ids);

	public JSONArray countScore(String param, String openId, String examId);

	public LhExamScoreEntity queryScore(String openId, String examId);
	
}
