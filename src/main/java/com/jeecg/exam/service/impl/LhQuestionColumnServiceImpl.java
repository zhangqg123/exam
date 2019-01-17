package com.jeecg.exam.service.impl;

import javax.annotation.Resource;
import java.util.UUID;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Service;

import com.jeecg.exam.dao.LhQuestionColumnDao;
import com.jeecg.exam.entity.LhQuestionColumnEntity;
import com.jeecg.exam.service.LhQuestionColumnService;

/**
 * 描述：试题分类表
 * @author: www.jeecg.org
 * @since：2018年12月27日 06时15分19秒 星期四 
 * @version:1.0
 */

@Service("lhQuestionColumnService")
public class LhQuestionColumnServiceImpl implements LhQuestionColumnService {
	@Resource
	private LhQuestionColumnDao lhQuestionColumnDao;

	@Override
	public LhQuestionColumnEntity get(String id) {
		return lhQuestionColumnDao.get(id);
	}

	@Override
	public int update(LhQuestionColumnEntity lhQuestionColumn) {
		return lhQuestionColumnDao.update(lhQuestionColumn);
	}

	@Override
	public void insert(LhQuestionColumnEntity lhQuestionColumn) {
		String randomSeed = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
		lhQuestionColumn.setId(randomSeed);
		lhQuestionColumnDao.insert(lhQuestionColumn);
		
	}

	@Override
	public MiniDaoPage<LhQuestionColumnEntity> getAll(LhQuestionColumnEntity lhQuestionColumn, int page, int rows) {
		return lhQuestionColumnDao.getAll(lhQuestionColumn, page, rows);
	}

	@Override
	public void delete(String id) {
		lhQuestionColumnDao.delete(id);
		
	}
	
	@Override
	public void batchDelete(String[] ids) {
		for(int i = 0; i < ids.length; i++) {
			String id = ids[i];
			lhQuestionColumnDao.deleteById(id);
		}
	}
}
