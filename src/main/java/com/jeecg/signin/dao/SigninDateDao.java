package com.jeecg.signin.dao;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.annotation.Sql;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Repository;

import com.jeecg.signin.entity.SigninDateEntity;

/**
 * 描述：签到表
 * @author：www.jeecg.org
 * @since：2018年12月18日 15时22分19秒 星期二 
 * @version:1.0
 */
@Repository
public interface SigninDateDao{

    /**
	 * 查询返回Java对象
	 * @param id
	 * @return
	 */
	@Sql("SELECT * FROM signin_date WHERE ID = :id")
	SigninDateEntity get(@Param("id") String id);
	
	/**
	 * 修改数据
	 * @param signinDate
	 * @return
	 */
	int update(@Param("signinDate") SigninDateEntity signinDate);
	
	/**
	 * 插入数据
	 * @param act
	 */
	void insert(@Param("signinDate") SigninDateEntity signinDate);
	
	/**
	 * 通用分页方法，支持（oracle、mysql、SqlServer、postgresql）
	 * @param signinDate
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResultType(SigninDateEntity.class)
	public MiniDaoPage<SigninDateEntity> getAll(@Param("signinDate") SigninDateEntity signinDate,@Param("page")  int page,@Param("rows") int rows);
	
	@Sql("DELETE from signin_date WHERE ID = :id")
	public void delete(@Param("id") String id);
	
	/**
	 * 根据ID删除
	 * @param id
	 */
	 @Sql("DELETE from signin_date WHERE ID = :id")
	 public void deleteById(@Param("id") String id);
	
}

