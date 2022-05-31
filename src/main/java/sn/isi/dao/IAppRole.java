package sn.isi.dao;

import sn.isi.entities.AppRole;


public interface IAppRole extends Repository<AppRole> {

	public AppRole getByNom(String email);
}
