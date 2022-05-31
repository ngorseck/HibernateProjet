package sn.isi.dao;


import java.util.ArrayList;
import java.util.List;

import sn.isi.dto.AppRoleDto;
import sn.isi.dto.AppUserDto;
import sn.isi.entities.AppRole;
import sn.isi.entities.AppUser;

public class AppUserImpl extends RepositoryImpl<AppUser> implements IAppUser {

	@Override
	public AppUser getByEmail(String email) {
		
		//return (AppUser) session.get(AppUser.class, email); //A revoir
		return (AppUser) session.createQuery("FROM AppUser user WHERE user.email = :user_email")
				.setParameter("user_email", email).uniqueResult();
	}

	public AppUser AppUserDtoToAppUserEntity (AppUserDto appUserDto) {
		AppUser appUser = new AppUser();
		appUser.setId(appUserDto.getId());
		appUser.setEmail(appUserDto.getEmail());
		if (appUserDto.getAppRoles() != null) {
			List<AppRole> appRoles = new ArrayList<AppRole>();
			appUserDto.getAppRoles().forEach(nom->{
				AppRole appRole = new AppRoleImpl().getByNom(nom);
				appRoles.add(appRole);
			});
			appUser.setAppRoles(appRoles);
		}
		
		return appUser;
	}
	
	public AppUserDto AppUserEntityToAppUserDto (AppUser appUser) {
		AppUserDto appUserdto = new AppUserDto();
		appUserdto.setId(appUser.getId());
		appUserdto.setEmail(appUser.getEmail());
		if (appUser.getAppRoles() != null) {
			List<String> nomRoles = new ArrayList<String>();
			appUser.getAppRoles().forEach(roles->{
				nomRoles.add(roles.getNom());
			});
			appUserdto.setAppRoles(nomRoles);
		}
		
		return appUserdto;
	}

}
