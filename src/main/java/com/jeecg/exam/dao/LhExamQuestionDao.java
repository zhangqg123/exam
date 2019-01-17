package com.jeecg.exam.dao;

import java.util.List;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.annotation.Sql;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Repository;

import com.jeecg.exam.entity.LhExamQuestionEntity;

/**
 * 描述：考试试题表
 * @author：www.jeecg.org
 * @since：2018年12月28日 08时22分27秒 星期五 
 * @version:1.0
 */
@Repository
public interface LhExamQuestionDao{

    /**
	 * 查询返回Java对象
	 * @param id
	 * @return
	 */
	@Sql("SELECT * FROM lh_exam_question WHERE ID = :id")
	LhExamQuestionEntity get(@Param("id") String id);
	
	/**
	 * 修改数据
	 * @param lhExamQuestion
	 * @return
	 */
	int update(@Param("lhExamQuestion") LhExamQuestionEntity lhExamQuestion);
	
	/**
	 * 插入数据
	 * @param act
	 */
	void insert(@Param("lhExamQuestion") LhExamQuestionEntity lhExamQuestion);
	
	/**
	 * 通用分页方法，支持（oracle、mysql、SqlServer、postgresql）
	 * @param lhExamQuestion
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResultType(LhExamQuestionEntity.class)
	public MiniDaoPage<LhExamQuestionEntity> getAll(@Param("lhExamQuestion") LhExamQuestionEntity lhExamQuestion,@Param("page")  int page,@Param("rows") int rows);
	
	@Sql("DELETE from lh_exam_question WHERE ID = :id")
	public void delete(@Param("id") String id);
	
	/**
	 * 根据ID删除
	 * @param id
	 */
	 @Sql("DELETE from lh_exam_question WHERE ID = :id")
	 public void deleteById(@Param("id") String id);
	 
	 @Sql("SELECT * FROM lh_exam_question WHERE FIND_IN_SET( exam_id, :ids )")
	 List<LhExamQuestionEntity> getExamIds(@Param("ids") String ids);
	 
	 @Sql("SELECT * FROM lh_exam_question WHERE FIND_IN_SET( question_id, :ids )")
	 List<LhExamQuestionEntity> getQuestionIds(@Param("ids") String ids);
	
}

