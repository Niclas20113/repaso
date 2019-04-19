package com.novellius.dao;

import java.util.List;

import com.novellius.pojo.Admin;

public interface AdminDao {

	public boolean saveAd(Admin admin);

	public List<Admin> findAllAd();

	public Admin findByIdAd(int idAd);

	public List<Admin> findByNameAd(String nameAd);

	public boolean updateAd(Admin Admin);

	public boolean deleteAd(int idAd);
	
	public int[] saveAllAd (List<Admin> saveAdmins);

}
