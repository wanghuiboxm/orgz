package com.orgz.service.impl;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;
import javax.mail.Session;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.orgz.base.SearchConditonOfSociety;
import com.orgz.dao.SocietyDao;
import com.orgz.domain.PageBean;
import com.orgz.domain.Society;
import com.orgz.domain.User;
import com.orgz.service.SocietyService;
import com.orgz.utils.Mail;
import com.orgz.utils.MailUtils;

@Repository
@Transactional
public class SocietyServiceImpl implements SocietyService, Serializable {
	private static final long serialVersionUID = 1L;
	@Resource
	SocietyDao societyDao;

	@Override
	public Society findSocietyById(int societyId, int userId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("societyId", societyId);
		params.put("userId", userId);
		return societyDao.findSocietyById(params);
	}

	/**
	 * 创建个人社团
	 */
	@Override
	public int createPersonalSociety(Society society, User user) {
		// 补齐数据,个人社团默认审核通过
		society.setFounder(user);
		society.setStatus(0);
		// 向数据库插入数据
		int societyId = societyDao.insertSociety(society);
		// 如果用户有邮箱
//		sendEmail(user, society.getSocietyName());

		return societyId;
	}

	/**
	 * 创建官方社团
	 */
	@Override
	public int createOfficialSociety(Society society, User user) {
		// 补齐数据,官方社团默认审核不通过
		society.setFounder(user);
		society.setStatus(1);
		// 向数据库插入数据
		int societyId = societyDao.insertSociety(society);
		// 向用户发送邮件
//		sendEmail(user, society.getSocietyName());

		return societyId;
	}

	public void sendEmail(User user, String societyName) {
		// 如果用户有邮箱，发送邮件
		if (user.getEmail() != null) {
			// 向用户发送注册成功邮件
			Properties prop = new Properties();
			try {
				prop.load(this
						.getClass()
						.getClassLoader()
						.getResourceAsStream(
								"email_personal_society.properties"));
				// 登录邮件服务器
				String host = prop.getProperty("host");
				String username = prop.getProperty("username");
				String password = prop.getProperty("password");
				Session session = MailUtils.createSession(host, username,
						password);
				// 创建mail对象
				String from = prop.getProperty("from");
				String to = user.getEmail();
				String subject = prop.getProperty("subject");
				// 得到内容并注入参数
				String content = MessageFormat.format(
						prop.getProperty("content"), user.getUserName(),
						societyName);
				Mail mail = new Mail(from, to, subject, content);
				// 发送邮件
				MailUtils.send(session, mail);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public int checkPass(int id, int status) {
		return societyDao.updateStatus(id, status);
	}

	@Override
	public List<Society> findAllByUserId(int userId) {
		List<Society> list = societyDao.findAllByUserId(userId);
		return list;
	}

	@Override
	public int updatePeopleCount(int societyId) {
		return societyDao.updatePeopleCount(societyId);
	}

	@Override
	public int updateActivityCount(int societyId) {
		return societyDao.updateActivityCount(societyId);
	}

	@Override
	public List<Society> findAllJionByUserId(int userId) {
		return societyDao.findAllJionByUserId(userId);
	}

	@Override
	public List<Society> findByUserId(int userId) {
		return societyDao.findByUserId(userId);
	}

	@Override
	public PageBean getPageBean(SearchConditonOfSociety sc, int numPerPage, int pageNum) {
		//根据条件查询记录数
		int recordCount = societyDao.getSocietyCount(sc);
		//补全分页条件
		sc.setStart((pageNum-1)*numPerPage);
		sc.setSize(numPerPage);
		//查询结果
		List recordList = societyDao.listSocoietyByCondition(sc);
		
		return new PageBean(pageNum, numPerPage, recordCount, recordList);
	}

	@Override
	public int updateSociety(Society society) {
		return societyDao.updateSociety(society);
	}

	@Override
	public int batchUpdateStatus(int[] ids, int status) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ids", ids);
		params.put("status", status);
		return societyDao.batchUpdareStatus(params);
	}

	@Override
	public int updatePeopleCountReduce(int societyId) {
		return societyDao.updatePeopleCountReduce(societyId);
	}

	@Override
	public int updateActivityCountReduce(int societyId) {
		return societyDao.updateActivityCountReduce(societyId);
	}

	@Override
	public List<Society> findHot() {
		List<Society> hot = societyDao.findHot();
		List<Society> countHot = new ArrayList<Society>();
		//如果最近一月里活动发布数不足三条
		if(hot == null || hot.size() < 3) {
			//找出总活动数最多的社团
			countHot = societyDao.findCountMax();
			hot = mergeCollection(hot, countHot);
		}
		return  hot;
	}

	private List<Society> mergeCollection(List<Society> hot, List<Society> countHot) {
		if(hot.size() == 0)
			return countHot;
		Iterator<Society> itr = countHot.iterator();
		while(itr.hasNext() && hot.size() < 3) {
			Society s = itr.next();
			insert2List(hot, s);
		}
		return hot;
	}
	
	private void insert2List(List<Society> hot, Society s) {
		Iterator<Society> itr = hot.iterator();
		boolean isEqual = false;
		while(itr.hasNext()) {
			Society v = itr.next();
			if(v.getSocietyId() == s.getSocietyId()){
				isEqual = true;
				break;	
			}
		}
		if(!isEqual)
			hot.add(s);
	}
}
