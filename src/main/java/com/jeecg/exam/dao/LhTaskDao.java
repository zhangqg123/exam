package com.jeecg.exam.dao;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.annotation.Sql;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Repository;

import com.jeecg.exam.entity.LhTaskEntity;

/**
 * 描述：作业表
 * @author：www.jeecg.org
 * @since：2019年02月13日 09时42分47秒 星期三 
 * @version:1.0
 */
@Repository
public interface LhTaskDao{

    /**
	 * 查询返回Java对象
	 * @param id
	 * @return
	 */
	@Sql("SELECT * FROM lh_task WHERE ID = :id")
	LhTaskEntity get(@Param("id") String id);
	
	/**
	 * 修改数据
	 * @param lhTask
	 * @return
	 */
	int update(@Param("lhTask") LhTaskEntity lhTask);
	
	/**
	 * 插入数据
	 * @param act
	 */
	void insert(@Param("lhTask") LhTaskEntity lhTask);
	
	/**
	 * 通用分页方法，支持（oracle、mysql、SqlServer、postgresql）
	 * @param lhTask
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResultType(LhTaskEntity.class)
	public MiniDaoPage<LhTaskEntity> getAll(@Param("lhTask") LhTaskEntity lhTask,@Param("page")  int page,@Param("rows") int rows);
	
	@Sql("DELETE from lh_task WHERE ID = :id")
	public void delete(@Param("id") String id);
	
	/**
	 * 根据ID删除
	 * @param id
	 */
	 @Sql("DELETE from lh_task WHERE ID = :id")
	 public void deleteById(@Param("id") String id);
	
}

