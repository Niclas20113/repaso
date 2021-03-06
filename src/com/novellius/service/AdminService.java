package com.novellius.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.novellius.dao.AdminDao;
import com.novellius.pojo.Admin;

@Service
public class AdminService {

	@Autowired
	private AdminDao adminDao;

	public List<Admin> finAllAd() {
		// TODO Auto-generated method stub
		return adminDao.findAllAd();
	}

	public boolean saveOrUpdateAd(Admin adminForm) {
		if (adminForm.getIdAd() == 0) {
			adminForm.setCreation_date(new Timestamp(new Date().getTime()));
			return adminDao.saveAd(adminForm);
		} else {
			return adminDao.updateAd(adminForm);
		}
	}

	public Admin findByIdAd(int idAd) {
		return adminDao.findByIdAd(idAd);
	}

	public boolean delete(int idAd) {
		// TODO Auto-generated method stub
		return adminDao.deleteAd(idAd);
	}

}
