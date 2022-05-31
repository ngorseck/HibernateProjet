package sn.isi.dto;

import java.util.ArrayList;
import java.util.List;

import sn.isi.dao.AppRoleImpl;
import sn.isi.dao.AppUserImpl;
import sn.isi.entities.AppRole;
import sn.isi.entities.AppUser;


public class AppRoleDto {

	private int id;
	private String nom;
	private List<String> appUsers = new ArrayList<String>();
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public List<String> getAppUsers() {
		return appUsers;
	}
	public void setAppUsers(List<String> appUsers) {
		this.appUsers = appUsers;
	}
	
	
}
