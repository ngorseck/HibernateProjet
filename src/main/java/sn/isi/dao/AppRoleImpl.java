package sn.isi.dao;

import java.util.ArrayList;
import java.util.List;

import sn.isi.dto.AppRoleDto;
import sn.isi.entities.AppRole;
import sn.isi.entities.AppUser;

public class AppRoleImpl extends RepositoryImpl<AppRole> implements IAppRole {

	@Override
	public AppRole getByNom(String nom) {
		
		return (AppRole) session.createQuery("FROM AppRole role WHERE role.nom = :role_nom")
				.setParameter("role_nom", nom).uniqueResult();
	}
	
	public AppRole appRoleDtoToAppRoleEntity (AppRoleDto appRoleDto) {
		AppRole appRole = new AppRole();
		appRole.setId(appRoleDto.getId());
		appRole.setNom(appRoleDto.getNom());
		if (appRoleDto.getAppUsers() != null) {
			List<AppUser> appUsers = new ArrayList<AppUser>();
			appRoleDto.getAppUsers().forEach(email->{
				AppUser appUser = new AppUserImpl().getByEmail(email);
				appUsers.add(appUser);
			});
			appRole.setAppUsers(appUsers);
		}
		
		return appRole;
	}
	
	public AppRoleDto appRoleEntityToAppRoleDto (AppRole appRole) {
		AppRoleDto appRoleDto = new AppRoleDto();
		appRoleDto.setId(appRole.getId());
		appRoleDto.setNom(appRole.getNom());
		if (appRole.getAppUsers() != null) {
			List<String> emailUsers = new ArrayList<String>();
			appRole.getAppUsers().forEach(user->{
				emailUsers.add(user.getEmail());
			});
			appRoleDto.setAppUsers(emailUsers);
		}
		return appRoleDto;
	}
}
