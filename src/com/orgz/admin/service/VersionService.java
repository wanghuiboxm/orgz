package com.orgz.admin.service;

import java.util.List;

import com.orgz.domain.Version;

public interface VersionService {
	public boolean checkUpdate(int versionId);
	public Version getLatestVersion();
	public List<Version> findAll();
	public int addVersion(Version version);
}
