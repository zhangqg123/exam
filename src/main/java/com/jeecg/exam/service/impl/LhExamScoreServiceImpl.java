package com.jeecg.exam.service.impl;

import javax.annotation.Resource;

import java.util.UUID;

import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Service;

import com.jeecg.exam.dao.LhExamScoreDao;
import com.jeecg.exam.entity.LhExamScoreEntity;
import com.jeecg.exam.service.LhExamScoreService;

/**
 * 描述：得分表
 * @author: www.jeecg.org
 * @since：2019年01月04日 13时21分36秒 星期五 
 * @version:1.0
 */

@Service("lhExamScoreService")
public class LhExamScoreServiceImpl implements LhExamScoreService {
	@Resource
	private LhExamScoreDao lhExamScoreDao;

	@Override
	public LhExamScoreEntity get(String id) {
		return lhExamScoreDao.get(id);
	}

	@Override
	public int update(LhExamScoreEntity lhExamScore) {
		return lhExamScoreDao.update(lhExamScore);
	}

	@Override
	public void insert(LhExamScoreEntity lhExamScore) {
		String randomSeed = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
		lhExamScore.setId(randomSeed);
		lhExamScoreDao.insert(lhExamScore);
		
	}

	@Override
	public MiniDaoPage<LhExamScoreEntity> getAll(LhExamScoreEntity lhExamScore, int page, int rows) {
		return lhExamScoreDao.getAll(lhExamScore, page, rows);
	}

	@Override
	public void delete(String id) {
		lhExamScoreDao.delete(id);
		
	}
	
	@Override
	public void batchDelete(String[] ids) {
		for(int i = 0; i < ids.length; i++) {
			String id = ids[i];
			lhExamScoreDao.deleteById(id);
		}
	}

	@Override
	public LhExamScoreEntity getByOpenIdExamId(String openId,String examId) {
		// TODO Auto-generated method stub
		return lhExamScoreDao.getByOpenIdExamId(openId,examId);
	}
}
