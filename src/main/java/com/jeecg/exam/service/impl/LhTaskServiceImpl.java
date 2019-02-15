package com.jeecg.exam.service.impl;

import javax.annotation.Resource;
import java.util.UUID;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Service;

import com.jeecg.exam.dao.LhTaskDao;
import com.jeecg.exam.entity.LhTaskEntity;
import com.jeecg.exam.service.LhTaskService;

/**
 * 描述：作业表
 * @author: www.jeecg.org
 * @since：2019年02月13日 09时42分47秒 星期三 
 * @version:1.0
 */

@Service("lhTaskService")
public class LhTaskServiceImpl implements LhTaskService {
	@Resource
	private LhTaskDao lhTaskDao;

	@Override
	public LhTaskEntity get(String id) {
		return lhTaskDao.get(id);
	}

	@Override
	public int update(LhTaskEntity lhTask) {
		return lhTaskDao.update(lhTask);
	}

	@Override
	public void insert(LhTaskEntity lhTask) {
		String randomSeed = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
		lhTask.setId(randomSeed);
		lhTaskDao.insert(lhTask);
		
	}

	@Override
	public MiniDaoPage<LhTaskEntity> getAll(LhTaskEntity lhTask, int page, int rows) {
		return lhTaskDao.getAll(lhTask, page, rows);
	}

	@Override
	public void delete(String id) {
		lhTaskDao.delete(id);
		
	}
	
	@Override
	public void batchDelete(String[] ids) {
		for(int i = 0; i < ids.length; i++) {
			String id = ids[i];
			lhTaskDao.deleteById(id);
		}
	}
}
