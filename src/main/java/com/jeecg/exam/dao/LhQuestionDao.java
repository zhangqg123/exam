package com.jeecg.exam.dao;

import java.util.List;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.annotation.Sql;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Repository;

import com.jeecg.exam.entity.LhQuestionEntity;

/**
 * 描述：试题表
 * @author：www.jeecg.org
 * @since：2018年12月24日 09时58分22秒 星期一 
 * @version:1.0
 */
@Repository
public interface LhQuestionDao{

    /**
	 * 查询返回Java对象
	 * @param id
	 * @return
	 */
	@Sql("SELECT * FROM lh_question WHERE ID = :id")
	LhQuestionEntity get(@Param("id") String id);
	
	/**
	 * 修改数据
	 * @param lhQuestion
	 * @return
	 */
	int update(@Param("lhQuestion") LhQuestionEntity lhQuestion);
	
	/**
	 * 插入数据
	 * @param act
	 */
	void insert(@Param("lhQuestion") LhQuestionEntity lhQuestion);
	
	/**
	 * 通用分页方法，支持（oracle、mysql、SqlServer、postgresql）
	 * @param lhQuestion
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResultType(LhQuestionEntity.class)
	public MiniDaoPage<LhQuestionEntity> getAll(@Param("lhQuestion") LhQuestionEntity lhQuestion,@Param("page")  int page,@Param("rows") int rows);
	
	@Sql("DELETE from lh_question WHERE ID = :id")
	public void delete(@Param("id") String id);
	
	/**
	 * 根据ID删除
	 * @param id
	 */
	@Sql("DELETE from lh_question WHERE ID = :id")
	public void deleteById(@Param("id") String id);
	
	@Sql("SELECT lq.id,lq.subject,lq.type,lq.choose_answer,lq.right_answer FROM lh_exam_question leq left join lh_question lq on leq.question_id = lq.id WHERE leq.exam_id = :examId")
	List<LhQuestionEntity> questionByExamId(@Param("examId") String examId);
	
}

