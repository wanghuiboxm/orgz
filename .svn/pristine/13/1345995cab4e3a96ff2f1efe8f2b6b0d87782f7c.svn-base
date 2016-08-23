package com.orgz.admin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.orgz.admin.dao.VersionDao;
import com.orgz.admin.service.VersionService;
import com.orgz.domain.Version;

@Service
@Transactional
public class VersionServiceImpl implements VersionService {
	@Resource
	VersionDao versionDao;
	
	@Override
	public boolean checkUpdate(int versionId) {
		Version version = getLatestVersion();
		return version.getVersionId() == versionId ? true : false;
	}

	@Override
	public Version getLatestVersion() {
		return versionDao.checkUpdate();
	}

	@Override
	public int addVersion(Version version) {
		return versionDao.insertVersion(version);
	}

	@Override
	public List<Version> findAll() {
		return versionDao.findAll();
	}

}
