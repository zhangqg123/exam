package com.jeecg.exam.dao;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.annotation.Sql;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Repository;

import com.jeecg.exam.entity.LhExamTypeEntity;

/**
 * 描述：考试分类表
 * @author：www.jeecg.org
 * @since：2019年02月13日 09时07分44秒 星期三 
 * @version:1.0
 */
@Repository
public interface LhExamTypeDao{

    /**
	 * 查询返回Java对象
	 * @param id
	 * @return
	 */
	@Sql("SELECT * FROM lh_exam_type WHERE ID = :id")
	LhExamTypeEntity get(@Param("id") String id);
	
	/**
	 * 修改数据
	 * @param lhExamType
	 * @return
	 */
	int update(@Param("lhExamType") LhExamTypeEntity lhExamType);
	
	/**
	 * 插入数据
	 * @param act
	 */
	void insert(@Param("lhExamType") LhExamTypeEntity lhExamType);
	
	/**
	 * 通用分页方法，支持（oracle、mysql、SqlServer、postgresql）
	 * @param lhExamType
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResultType(LhExamTypeEntity.class)
	public MiniDaoPage<LhExamTypeEntity> getAll(@Param("lhExamType") LhExamTypeEntity lhExamType,@Param("page")  int page,@Param("rows") int rows);
	
	@Sql("DELETE from lh_exam_type WHERE ID = :id")
	public void delete(@Param("id") String id);
	
	/**
	 * 根据ID删除
	 * @param id
	 */
	 @Sql("DELETE from lh_exam_type WHERE ID = :id")
	 public void deleteById(@Param("id") String id);
	
}

