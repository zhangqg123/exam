package com.jeecg.exam.service;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import com.jeecg.exam.entity.LhExamStudentEntity;

/**
 * 描述：学生表
 * @author: www.jeecg.org
 * @since：2019年01月04日 12时45分42秒 星期五 
 * @version:1.0
 */
public interface LhExamStudentService {
	public LhExamStudentEntity get(String id);

	public int update(LhExamStudentEntity lhExamStudent);

	public void insert(LhExamStudentEntity lhExamStudent);

	public MiniDaoPage<LhExamStudentEntity> getAll(LhExamStudentEntity lhExamStudent,int page,int rows);

	public void delete(String id);
	
	public void batchDelete(String[] ids);
	
}
