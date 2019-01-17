package com.jeecg.exam.service.impl;

import javax.annotation.Resource;

import java.util.List;
import java.util.UUID;

import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Service;

import com.jeecg.exam.dao.LhQuestionDao;
import com.jeecg.exam.entity.LhQuestionEntity;
import com.jeecg.exam.service.LhQuestionService;

/**
 * 描述：试题表
 * @author: www.jeecg.org
 * @since：2018年12月24日 09时58分22秒 星期一 
 * @version:1.0
 */

@Service("lhQuestionService")
public class LhQuestionServiceImpl implements LhQuestionService {
	@Resource
	private LhQuestionDao lhQuestionDao;

	@Override
	public LhQuestionEntity get(String id) {
		return lhQuestionDao.get(id);
	}

	@Override
	public int update(LhQuestionEntity lhQuestion) {
		return lhQuestionDao.update(lhQuestion);
	}

	@Override
	public void insert(LhQuestionEntity lhQuestion) {
		String randomSeed = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
		lhQuestion.setId(randomSeed);
		lhQuestionDao.insert(lhQuestion);
		
	}

	@Override
	public MiniDaoPage<LhQuestionEntity> getAll(LhQuestionEntity lhQuestion, int page, int rows) {
		return lhQuestionDao.getAll(lhQuestion, page, rows);
	}

	@Override
	public void delete(String id) {
		lhQuestionDao.delete(id);
		
	}
	
	@Override
	public void batchDelete(String[] ids) {
		for(int i = 0; i < ids.length; i++) {
			String id = ids[i];
			lhQuestionDao.deleteById(id);
		}
	}

	@Override
	public List<LhQuestionEntity> questionByExamId(String examId) {
		// TODO Auto-generated method stub
		return lhQuestionDao.questionByExamId(examId);
	}
}
