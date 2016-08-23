package com.orgz.dao;

import java.util.List;
import java.util.Map;

import com.orgz.base.SearchConditonOfSociety;
import com.orgz.domain.Society;


public interface SocietyDao {

	public Society findSocietyById(Map<String, Object> params);
	/**
	 * 
	 * @param society
	 * @return 返回插入社团的id
	 */
	public int insertSociety(Society society);
	/**
	 * 
	 * @param userId
	 * @return 根据userId返回用户自己创建的社团
	 */
	public List<Society> findByUserId(int userId);
	/**
	 * 根据userId返回自己加入的社团
	 * @param userId
	 * @return
	 */
	public List<Society> findAllJionByUserId(int userId);
	/**
	 * 根据userId查找加入或者创建的社团
	 * @param userId
	 * @return
	 */
	public List<Society> findAllByUserId(int userId);
	/**
	 * 查找热门社团
	 * @return
	 */
	public List<Society> findHot();
	public List<Society> findCountMax();
	public int updateStatus(int id, int status);
	public int updatePeopleCount(int societyId);
	public int updatePeopleCountReduce(int societyId);
	public int updateActivityCount(int societyId);
	public int updateActivityCountReduce(int societyId);
	public int updateSociety(Society society);
	/**
	 * 
	 * @param property 官方是0 , 个人是1,  2是所有社团
	 * @param status 状态，是否审核 0审核 1未审核
	 * @return
	 */
	public int getSocietyCount(SearchConditonOfSociety sc);
	/**
	 * 通过多条件查询社团
	 * @param sc
	 * @return
	 */
	public List<Society> listSocoietyByCondition(SearchConditonOfSociety sc);
	public int batchUpdareStatus(Map<String, Object> params);
	
}
