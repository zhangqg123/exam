package com.jeecg.exam.dao;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.annotation.Sql;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Repository;

import com.jeecg.exam.entity.LhExamScoreEntity;

/**
 * 描述：得分表
 * @author：www.jeecg.org
 * @since：2019年01月04日 13时21分36秒 星期五 
 * @version:1.0
 */
@Repository
public interface LhExamScoreDao{

    /**
	 * 查询返回Java对象
	 * @param id
	 * @return
	 */
	@Sql("SELECT * FROM lh_exam_score WHERE ID = :id")
	LhExamScoreEntity get(@Param("id") String id);
	
	/**
	 * 修改数据
	 * @param lhExamScore
	 * @return
	 */
	int update(@Param("lhExamScore") LhExamScoreEntity lhExamScore);
	
	/**
	 * 插入数据
	 * @param act
	 */
	void insert(@Param("lhExamScore") LhExamScoreEntity lhExamScore);
	
	/**
	 * 通用分页方法，支持（oracle、mysql、SqlServer、postgresql）
	 * @param lhExamScore
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResultType(LhExamScoreEntity.class)
	public MiniDaoPage<LhExamScoreEntity> getAll(@Param("lhExamScore") LhExamScoreEntity lhExamScore,@Param("page")  int page,@Param("rows") int rows);
	
	@Sql("DELETE from lh_exam_score WHERE ID = :id")
	public void delete(@Param("id") String id);
	
	/**
	 * 根据ID删除
	 * @param id
	 */
	 @Sql("DELETE from lh_exam_score WHERE ID = :id")
	 public void deleteById(@Param("id") String id);
	 
	 @Sql("SELECT * FROM lh_exam_score WHERE open_id = :openId and exam_id = :examId")
	 LhExamScoreEntity getByOpenIdExamId(@Param("openId") String openId,@Param("examId") String examId);
	
}

