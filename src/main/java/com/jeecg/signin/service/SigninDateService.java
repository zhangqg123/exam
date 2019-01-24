package com.jeecg.signin.service;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import com.jeecg.signin.entity.SigninDateEntity;

/**
 * 描述：签到表
 * @author: www.jeecg.org
 * @since：2018年12月18日 15时22分19秒 星期二 
 * @version:1.0
 */
public interface SigninDateService {
	public SigninDateEntity get(String id);

	public int update(SigninDateEntity signinDate);

	public void insert(SigninDateEntity signinDate);

	public MiniDaoPage<SigninDateEntity> getAll(SigninDateEntity signinDate,int page,int rows);

	public void delete(String id);
	
	public void batchDelete(String[] ids);
	
}
