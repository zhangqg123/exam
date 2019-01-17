package com.jeecg.exam.service.impl;

import javax.annotation.Resource;

import java.util.List;
import java.util.UUID;

import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeecg.exam.dao.LhExamQuestionDao;
import com.jeecg.exam.entity.LhExamQuestionEntity;
import com.jeecg.exam.service.LhExamQuestionService;

/**
 * 描述：考试试题表
 * @author: www.jeecg.org
 * @since：2018年12月28日 08时22分27秒 星期五 
 * @version:1.0
 */

@Service("lhExamQuestionService")
public class LhExamQuestionServiceImpl implements LhExamQuestionService {
	@Resource
	private LhExamQuestionDao lhExamQuestionDao;

	@Override
	public LhExamQuestionEntity get(String id) {
		return lhExamQuestionDao.get(id);
	}

	@Override
	public int update(LhExamQuestionEntity lhExamQuestion) {
		return lhExamQuestionDao.update(lhExamQuestion);
	}

	@Override
	public void insert(LhExamQuestionEntity lhExamQuestion) {
		String randomSeed = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
		lhExamQuestion.setId(randomSeed);
		lhExamQuestionDao.insert(lhExamQuestion);
		
	}

	@Override
	public MiniDaoPage<LhExamQuestionEntity> getAll(LhExamQuestionEntity lhExamQuestion, int page, int rows) {
		return lhExamQuestionDao.getAll(lhExamQuestion, page, rows);
	}

	@Override
	public void delete(String id) {
		lhExamQuestionDao.delete(id);
		
	}
	
	@Override
	public void batchDelete(String[] ids) {
		for(int i = 0; i < ids.length; i++) {
			String id = ids[i];
			lhExamQuestionDao.deleteById(id);
		}
	}

	@Override
	@Transactional
	public void batchSelect(String[] ids,String examId) {
		for(int i = 0; i < ids.length; i++) {
			String id = ids[i];
			LhExamQuestionEntity lhExamQuestion =new LhExamQuestionEntity();
			lhExamQuestion.setExamId(examId);
			lhExamQuestion.setQuestionId(id);
			MiniDaoPage<LhExamQuestionEntity> list = this.getAll(lhExamQuestion, 1, 10);
			if(list.getResults().size()==0){
				this.insert(lhExamQuestion);
			}
		}
	}

	@Override
	public List<LhExamQuestionEntity> getExamIds(String ids) {

		List<LhExamQuestionEntity> list=lhExamQuestionDao.getExamIds(ids);
		return list;		
	}

	@Override
	public List<LhExamQuestionEntity> getQuestionIds(String ids) {
		List<LhExamQuestionEntity> list=lhExamQuestionDao.getQuestionIds(ids);
		return list;		
	}
}
