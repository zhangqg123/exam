package com.jeecg.exam.service.impl;

import javax.annotation.Resource;
import java.util.UUID;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Service;

import com.jeecg.exam.dao.LhExamTypeDao;
import com.jeecg.exam.entity.LhExamTypeEntity;
import com.jeecg.exam.service.LhExamTypeService;

/**
 * 描述：考试分类表
 * @author: www.jeecg.org
 * @since：2019年02月13日 09时07分44秒 星期三 
 * @version:1.0
 */

@Service("lhExamTypeService")
public class LhExamTypeServiceImpl implements LhExamTypeService {
	@Resource
	private LhExamTypeDao lhExamTypeDao;

	@Override
	public LhExamTypeEntity get(String id) {
		return lhExamTypeDao.get(id);
	}

	@Override
	public int update(LhExamTypeEntity lhExamType) {
		return lhExamTypeDao.update(lhExamType);
	}

	@Override
	public void insert(LhExamTypeEntity lhExamType) {
		String randomSeed = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
		lhExamType.setId(randomSeed);
		lhExamTypeDao.insert(lhExamType);
		
	}

	@Override
	public MiniDaoPage<LhExamTypeEntity> getAll(LhExamTypeEntity lhExamType, int page, int rows) {
		return lhExamTypeDao.getAll(lhExamType, page, rows);
	}

	@Override
	public void delete(String id) {
		lhExamTypeDao.delete(id);
		
	}
	
	@Override
	public void batchDelete(String[] ids) {
		for(int i = 0; i < ids.length; i++) {
			String id = ids[i];
			lhExamTypeDao.deleteById(id);
		}
	}
}
