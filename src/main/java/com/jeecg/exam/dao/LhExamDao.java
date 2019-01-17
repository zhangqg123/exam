package com.jeecg.exam.dao;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.annotation.Sql;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Repository;

import com.jeecg.exam.entity.LhExamEntity;

/**
 * 描述：考试表
 * @author：www.jeecg.org
 * @since：2018年12月26日 07时46分03秒 星期三 
 * @version:1.0
 */
@Repository
public interface LhExamDao{

    /**
	 * 查询返回Java对象
	 * @param id
	 * @return
	 */
	@Sql("SELECT * FROM lh_exam WHERE ID = :id")
	LhExamEntity get(@Param("id") String id);
	
	/**
	 * 修改数据
	 * @param lhExam
	 * @return
	 */
	int update(@Param("lhExam") LhExamEntity lhExam);
	
	/**
	 * 插入数据
	 * @param act
	 */
	void insert(@Param("lhExam") LhExamEntity lhExam);
	
	/**
	 * 通用分页方法，支持（oracle、mysql、SqlServer、postgresql）
	 * @param lhExam
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResultType(LhExamEntity.class)
	public MiniDaoPage<LhExamEntity> getAll(@Param("lhExam") LhExamEntity lhExam,@Param("page")  int page,@Param("rows") int rows);
	
	@Sql("DELETE from lh_exam WHERE ID = :id")
	public void delete(@Param("id") String id);
	
	/**
	 * 根据ID删除
	 * @param id
	 */
	 @Sql("DELETE from lh_exam WHERE ID = :id")
	 public void deleteById(@Param("id") String id);
	
}

