package com.orgz.admin.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.orgz.admin.dao.VersionDao;
import com.orgz.base.BaseDaoImpl;
import com.orgz.domain.Version;

@Repository
public class VersionDaoImpl extends BaseDaoImpl implements VersionDao {

	@Override
	public Version checkUpdate() {
		
		return getSession().selectOne("com.orgz.dao.VersionMapper.checkLatestVersion");
	}

	@Override
	public List<Version> findAll() {
		return getSession().selectList("com.orgz.dao.VersionMapper.findAll");
	}

	@Override
	public int insertVersion(Version version) {
		int id = getSession().insert("com.orgz.dao.VersionMapper.insertVersion", version);
		return id;
	}

}
