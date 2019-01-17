package com.jeecg.exam.dao;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.annotation.Sql;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Repository;

import com.jeecg.exam.entity.LhExamStudentEntity;

/**
 * 描述：学生表
 * @author：www.jeecg.org
 * @since：2019年01月04日 12时45分42秒 星期五 
 * @version:1.0
 */
@Repository
public interface LhExamStudentDao{

    /**
	 * 查询返回Java对象
	 * @param id
	 * @return
	 */
	@Sql("SELECT * FROM lh_exam_student WHERE ID = :id")
	LhExamStudentEntity get(@Param("id") String id);
	
	/**
	 * 修改数据
	 * @param lhExamStudent
	 * @return
	 */
	int update(@Param("lhExamStudent") LhExamStudentEntity lhExamStudent);
	
	/**
	 * 插入数据
	 * @param act
	 */
	void insert(@Param("lhExamStudent") LhExamStudentEntity lhExamStudent);
	
	/**
	 * 通用分页方法，支持（oracle、mysql、SqlServer、postgresql）
	 * @param lhExamStudent
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResultType(LhExamStudentEntity.class)
	public MiniDaoPage<LhExamStudentEntity> getAll(@Param("lhExamStudent") LhExamStudentEntity lhExamStudent,@Param("page")  int page,@Param("rows") int rows);
	
	@Sql("DELETE from lh_exam_student WHERE ID = :id")
	public void delete(@Param("id") String id);
	
	/**
	 * 根据ID删除
	 * @param id
	 */
	 @Sql("DELETE from lh_exam_student WHERE ID = :id")
	 public void deleteById(@Param("id") String id);
	
}

