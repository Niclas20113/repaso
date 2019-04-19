package com.novellius.pojo;

import java.sql.Timestamp;

public class Admin {

	private int IdAd;
	private String nameAd;
	private String workPositionAd;
	private Timestamp creation_date;

	public Admin() {

	}

	public Admin(String nameAd, String workPositionAd, Timestamp creation_date) {
		this.nameAd = nameAd;
		this.workPositionAd = workPositionAd;
		this.creation_date = creation_date;
	}

	public int getIdAd() {
		return IdAd;
	}

	public void setIdAd(int idAd) {
		IdAd = idAd;
	}

	public String getNameAd() {
		return nameAd;
	}

	public void setNameAd(String nameAd) {
		this.nameAd = nameAd;
	}

	public String getWorkPositionAd() {
		return workPositionAd;
	}

	public void setWorkPositionAd(String workPositionAd) {
		this.workPositionAd = workPositionAd;
	}

	public Timestamp getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Timestamp creation_date) {
		this.creation_date = creation_date;
	}

	@Override
	public String toString() {
		return "Admin [IdAd=" + IdAd + ", nameAd=" + nameAd + ", workPositionAd=" + workPositionAd + ", creation_date="
				+ creation_date + "]";
	}

}
