package com.jeecg.exam.dao;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.annotation.Sql;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Repository;

import com.jeecg.exam.entity.LhQuestionColumnEntity;

/**
 * 描述：试题分类表
 * @author：www.jeecg.org
 * @since：2018年12月27日 06时15分19秒 星期四 
 * @version:1.0
 */
@Repository
public interface LhQuestionColumnDao{

    /**
	 * 查询返回Java对象
	 * @param id
	 * @return
	 */
	@Sql("SELECT * FROM lh_question_column WHERE ID = :id")
	LhQuestionColumnEntity get(@Param("id") String id);
	
	/**
	 * 修改数据
	 * @param lhQuestionColumn
	 * @return
	 */
	int update(@Param("lhQuestionColumn") LhQuestionColumnEntity lhQuestionColumn);
	
	/**
	 * 插入数据
	 * @param act
	 */
	void insert(@Param("lhQuestionColumn") LhQuestionColumnEntity lhQuestionColumn);
	
	/**
	 * 通用分页方法，支持（oracle、mysql、SqlServer、postgresql）
	 * @param lhQuestionColumn
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResultType(LhQuestionColumnEntity.class)
	public MiniDaoPage<LhQuestionColumnEntity> getAll(@Param("lhQuestionColumn") LhQuestionColumnEntity lhQuestionColumn,@Param("page")  int page,@Param("rows") int rows);
	
	@Sql("DELETE from lh_question_column WHERE ID = :id")
	public void delete(@Param("id") String id);
	
	/**
	 * 根据ID删除
	 * @param id
	 */
	 @Sql("DELETE from lh_question_column WHERE ID = :id")
	 public void deleteById(@Param("id") String id);
	
}

