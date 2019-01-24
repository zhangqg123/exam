package com.jeecg.signin.service.impl;

import javax.annotation.Resource;
import java.util.UUID;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Service;

import com.jeecg.signin.dao.SigninDateDao;
import com.jeecg.signin.entity.SigninDateEntity;
import com.jeecg.signin.service.SigninDateService;

/**
 * 描述：签到表
 * @author: www.jeecg.org
 * @since：2018年12月18日 15时22分19秒 星期二 
 * @version:1.0
 */

@Service("signinDateService")
public class SigninDateServiceImpl implements SigninDateService {
	@Resource
	private SigninDateDao signinDateDao;

	@Override
	public SigninDateEntity get(String id) {
		return signinDateDao.get(id);
	}

	@Override
	public int update(SigninDateEntity signinDate) {
		return signinDateDao.update(signinDate);
	}

	@Override
	public void insert(SigninDateEntity signinDate) {
		String randomSeed = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
		signinDate.setId(randomSeed);
		signinDateDao.insert(signinDate);
		
	}

	@Override
	public MiniDaoPage<SigninDateEntity> getAll(SigninDateEntity signinDate, int page, int rows) {
		return signinDateDao.getAll(signinDate, page, rows);
	}

	@Override
	public void delete(String id) {
		signinDateDao.delete(id);
		
	}
	
	@Override
	public void batchDelete(String[] ids) {
		for(int i = 0; i < ids.length; i++) {
			String id = ids[i];
			signinDateDao.deleteById(id);
		}
	}
}
