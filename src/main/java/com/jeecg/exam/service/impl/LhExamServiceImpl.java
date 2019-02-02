package com.jeecg.exam.service.impl;

import javax.annotation.Resource;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jeecg.exam.dao.LhExamDao;
import com.jeecg.exam.dao.LhQuestionDao;
import com.jeecg.exam.entity.LhExamEntity;
import com.jeecg.exam.entity.LhExamScoreEntity;
import com.jeecg.exam.entity.LhQuestionEntity;
import com.jeecg.exam.service.LhExamScoreService;
import com.jeecg.exam.service.LhExamService;

/**
 * 描述：考试表
 * @author: www.jeecg.org
 * @since：2018年12月26日 07时46分03秒 星期三 
 * @version:1.0
 */

@Service("lhExamService")
public class LhExamServiceImpl implements LhExamService {
	@Resource
	private LhExamDao lhExamDao;
	@Resource
	private LhQuestionDao lhQuestionDao;
	@Autowired
	private LhExamScoreService lhExamScoreService;

	@Override
	public LhExamEntity get(String id) {
		return lhExamDao.get(id);
	}

	@Override
	public int update(LhExamEntity lhExam) {
		return lhExamDao.update(lhExam);
	}

	@Override
	public void insert(LhExamEntity lhExam) {
		String randomSeed = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
		lhExam.setId(randomSeed);
		lhExamDao.insert(lhExam);
		
	}

	@Override
	public MiniDaoPage<LhExamEntity> getAll(LhExamEntity lhExam, int page, int rows) {
		return lhExamDao.getAll(lhExam, page, rows);
	}

	@Override
	public void delete(String id) {
		lhExamDao.delete(id);
		
	}
	
	@Override
	public void batchDelete(String[] ids) {
		for(int i = 0; i < ids.length; i++) {
			String id = ids[i];
			lhExamDao.deleteById(id);
		}
	}

	@Override
	@Transactional
	public JSONArray countScore(String param,String openId,String examId) {
		JSONArray data = JSONArray.parseArray(param);
	    JSONObject rowData = new JSONObject();
	    int totalScore=0;
	    JSONArray jsonArray = new JSONArray();
	    for(int i=0;i<data.size();i++){
	        rowData = data.getJSONObject(i);
	        String qid=(String) rowData.get("id");
	        Integer choose=(Integer) rowData.get("choose");
	        LhQuestionEntity lhq = lhQuestionDao.get(qid);
        	rowData.put("right", 0);
        	rowData.put("rightAnswer", lhq.getRightAnswer());
	        if(choose!=null){
//		        LhQuestionEntity lhq = lhQuestionDao.get(qid);
		        int right = Integer.valueOf(lhq.getRightAnswer());
		        if(right==(choose+1)){
		        	totalScore=totalScore+10;
		        	rowData.put("right", 1);
		        }
	        }
	        jsonArray.add(i, rowData);
	    }		
	    LhExamScoreEntity lhExamScore=lhExamScoreService.getByOpenIdExamId(openId,examId);
	    if(lhExamScore!=null){
	    	if(totalScore>lhExamScore.getScore()){
	    		lhExamScore.setScore(totalScore);
	    	}
	    	lhExamScore.setNumber(lhExamScore.getNumber()+1);
    		lhExamScoreService.update(lhExamScore);
	    }else{
		    lhExamScore=new LhExamScoreEntity();
		    lhExamScore.setExamId(examId);
		    lhExamScore.setOpenId(openId);
		    lhExamScore.setScore(totalScore);
		    lhExamScore.setNumber(1);
		    lhExamScoreService.insert(lhExamScore);
	    }
	    
		return jsonArray;
		
	}

	@Override
	public LhExamScoreEntity queryScore(String openId, String examId) {
		return lhExamScoreService.getByOpenIdExamId(openId, examId);
	}

	

}
