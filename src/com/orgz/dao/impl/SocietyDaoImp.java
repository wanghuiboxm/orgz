package com.orgz.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.orgz.base.BaseDaoImpl;
import com.orgz.base.SearchConditonOfSociety;
import com.orgz.dao.SocietyDao;
import com.orgz.domain.Society;
@Repository
public class SocietyDaoImp extends BaseDaoImpl implements SocietyDao {

	@Override
	public Society findSocietyById(Map<String, Object> params) {
		Society society = getSession().selectOne("com.orgz.dao.SocietyMapper.selectSocietyById", params);
		return society;
	}

	@Override
	public int insertSociety(Society society) {
		getSession().insert("com.orgz.dao.SocietyMapper.insertSociety", society);
		return society.getSocietyId();
	}

	@Override
	public int updateStatus(int id, int status) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("status", status);
		return getSession().update("com.orgz.dao.SocietyMapper.updateStatus", param);
	}

	@Override
	public List<Society> findAllByUserId(int userId) {
		return getSession().selectList("com.orgz.dao.SocietyMapper.findAllByUserId", userId);
	}

	@Override
	public int updatePeopleCount(int societyId) {
		return getSession().update("com.orgz.dao.SocietyMapper.updatePeopleCount",societyId );
	}

	@Override
	public int updateActivityCount(int societyId) {
		return getSession().update("com.orgz.dao.SocietyMapper.updateActivityCount", societyId);
	}

	@Override
	public List<Society> findAllJionByUserId(int userId) {
		return getSession().selectList("com.orgz.dao.SocietyMapper.findAllJionByUserId", userId);
	}

	@Override
	public List<Society> findByUserId(int userId) {
		return getSession().selectList("com.orgz.dao.SocietyMapper.findByUserId", userId);
	}

	@Override
	public int getSocietyCount(SearchConditonOfSociety sc) {
		return getSession().selectList("com.orgz.dao.SocietyMapper.listSociety", sc).size();
	}

	@Override
	public List<Society> listSocoietyByCondition(SearchConditonOfSociety sc) {
		return getSession().selectList("com.orgz.dao.SocietyMapper.listSociety", sc);
	}

	@Override
	public int updateSociety(Society society) {
		return getSession().update("com.orgz.dao.SocietyMapper.updateSociety", society);
	}

	@Override
	public int batchUpdareStatus(Map<String, Object> params) {
		return getSession().update("com.orgz.dao.SocietyMapper.batchUpdateStatus", params);
	}

	@Override
	public int updatePeopleCountReduce(int societyId) {
		return getSession().update("com.orgz.dao.SocietyMapper.updatePeopleCountReduce", societyId);
	}

	@Override
	public int updateActivityCountReduce(int societyId) {
		return getSession().update("com.orgz.dao.SocietyMapper.updateActivityCountReduce", societyId);
	}

	@Override
	public List<Society> findHot() {
		return getSession().selectList("com.orgz.dao.SocietyMapper.findHot");
	}

	@Override
	public List<Society> findCountMax() {
		return getSession().selectList("com.orgz.dao.SocietyMapper.findCountMax");
	}
}
