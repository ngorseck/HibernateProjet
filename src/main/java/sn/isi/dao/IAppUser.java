package sn.isi.dao;


import sn.isi.entities.AppUser;

public interface IAppUser extends Repository<AppUser> {

	public AppUser getByEmail(String email);
}
