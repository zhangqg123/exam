package com.jeecg.exam.service.impl;

import javax.annotation.Resource;
import java.util.UUID;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Service;

import com.jeecg.exam.dao.LhExamStudentDao;
import com.jeecg.exam.entity.LhExamStudentEntity;
import com.jeecg.exam.service.LhExamStudentService;

/**
 * 描述：学生表
 * @author: www.jeecg.org
 * @since：2019年01月04日 12时45分42秒 星期五 
 * @version:1.0
 */

@Service("lhExamStudentService")
public class LhExamStudentServiceImpl implements LhExamStudentService {
	@Resource
	private LhExamStudentDao lhExamStudentDao;

	@Override
	public LhExamStudentEntity get(String id) {
		return lhExamStudentDao.get(id);
	}

	@Override
	public int update(LhExamStudentEntity lhExamStudent) {
		return lhExamStudentDao.update(lhExamStudent);
	}

	@Override
	public void insert(LhExamStudentEntity lhExamStudent) {
		String randomSeed = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
		lhExamStudent.setId(randomSeed);
		lhExamStudentDao.insert(lhExamStudent);
		
	}

	@Override
	public MiniDaoPage<LhExamStudentEntity> getAll(LhExamStudentEntity lhExamStudent, int page, int rows) {
		return lhExamStudentDao.getAll(lhExamStudent, page, rows);
	}

	@Override
	public void delete(String id) {
		lhExamStudentDao.delete(id);
		
	}
	
	@Override
	public void batchDelete(String[] ids) {
		for(int i = 0; i < ids.length; i++) {
			String id = ids[i];
			lhExamStudentDao.deleteById(id);
		}
	}
}
