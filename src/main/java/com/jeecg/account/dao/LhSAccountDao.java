package com.jeecg.account.dao;

import java.util.List;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.annotation.Sql;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Repository;

import com.jeecg.account.entity.LhSAccountEntity;
import com.jeecg.account.entity.User;

/**
 * 描述：账号表
 * @author：www.jeecg.org
 * @since：2019年01月24日 15时03分32秒 星期四 
 * @version:1.0
 */
@Repository
public interface LhSAccountDao{

    /**
	 * 查询返回Java对象
	 * @param id
	 * @return
	 */
	@Sql("SELECT * FROM lh_s_account WHERE ID = :id")
	LhSAccountEntity get(@Param("id") String id);
	
	/**
	 * 修改数据
	 * @param lhSAccount
	 * @return
	 */
	int update(@Param("lhSAccount") LhSAccountEntity lhSAccount);
	
	/**
	 * 插入数据
	 * @param act
	 */
	void insert(@Param("lhSAccount") LhSAccountEntity lhSAccount);
	
	/**
	 * 通用分页方法，支持（oracle、mysql、SqlServer、postgresql）
	 * @param lhSAccount
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResultType(LhSAccountEntity.class)
	public MiniDaoPage<LhSAccountEntity> getAll(@Param("lhSAccount") LhSAccountEntity lhSAccount,@Param("page")  int page,@Param("rows") int rows);
	
	@Sql("DELETE from lh_s_account WHERE ID = :id")
	public void delete(@Param("id") String id);
	
	/**
	 * 根据ID删除
	 * @param id
	 */
	 @Sql("DELETE from lh_s_account WHERE ID = :id")
	 public void deleteById(@Param("id") String id);
	 
	@Sql("SELECT * FROM lh_s_account WHERE app_id = :appId")
	LhSAccountEntity getByAppId(@Param("appId") String appId);
	
	@Sql("SELECT id,userName,realName FROM t_s_base_user where id in (select tsru.userid from t_s_role_user tsru left join t_s_role tsr on tsr.id=tsru.roleid where tsr.rolecode ='exam' or tsr.rolecode='admin') ")
	List<User> getUserList();
	
}

