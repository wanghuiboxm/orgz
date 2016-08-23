package com.orgz.admin.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.orgz.admin.dao.AdminDao;
import com.orgz.admin.domain.Admin;
import com.orgz.base.BaseDaoImpl;

@Repository
public class AdminDaoImpl extends BaseDaoImpl implements AdminDao {

	@Override
	public Admin selectByName(Admin admin) {
		return getSession().selectOne("com.orgz.admin.dao.AdminMapper.selectByName", admin);
	}

	@Override
	public Admin selectByPhoneNumber(Admin admin) {
		return getSession().selectOne("com.orgz.admin.dao.AdminMapper.selectByPhoneNumber", admin);
	}

	@Override
	public int editPassword(Admin admin) {
		return getSession().update("com.orgz.admin.dao.AdminMapper.updatePassword", admin);
	}

	@Override
	public Admin selectById(int adminId) {
		return getSession().selectOne("com.orgz.admin.dao.AdminMapper.selectById", adminId);
	}

	@Override
	public int insertAdmin(Admin admin) {
		getSession().insert("com.orgz.admin.dao.AdminMapper.insertAdmin", admin);
		return admin.getAdminId();
	}

	@Override
	public List<Admin> listAdmin() {
		return getSession().selectList("com.orgz.admin.dao.AdminMapper.listAdmin");
	}

	@Override
	public int deleteById(int adminId) {
		return getSession().delete("com.orgz.admin.dao.AdminMapper.deleteById", adminId);
	}

	@Override
	public Admin selectByIdAndPassword(Admin admin) {
		return getSession().selectOne("com.orgz.admin.dao.AdminMapper.selectByIdAndPassword", admin);
	}


}
