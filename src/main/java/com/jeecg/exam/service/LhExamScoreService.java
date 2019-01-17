package com.jeecg.exam.service;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.pojo.MiniDaoPage;

import com.jeecg.exam.entity.LhExamScoreEntity;

/**
 * 描述：得分表
 * @author: www.jeecg.org
 * @since：2019年01月04日 13时21分36秒 星期五 
 * @version:1.0
 */
public interface LhExamScoreService {
	public LhExamScoreEntity get(String id);

	public int update(LhExamScoreEntity lhExamScore);

	public void insert(LhExamScoreEntity lhExamScore);

	public MiniDaoPage<LhExamScoreEntity> getAll(LhExamScoreEntity lhExamScore,int page,int rows);

	public void delete(String id);
	
	public void batchDelete(String[] ids);

	public LhExamScoreEntity getByOpenIdExamId(String openId,String examId);
	
}
