package main;

import sn.isi.dao.AppRoleImpl;
import sn.isi.dao.AppUserImpl;
import sn.isi.dao.IAppUser;
import sn.isi.dto.AppRoleDto;
import sn.isi.dto.AppUserDto;
import sn.isi.entities.AppUser;
import sn.isi.service.AppRoleDtoImpl;
import sn.isi.service.IAppRoleDto;

public class Test {

	public static void main(String[] args) {

		/*
		AppUser appUser = new AppUser();
		appUser.setPassword("passer1234$#@!");
		appUser.setEmail("mboup3@isi.sn");
		
		IAppUser udao = new AppUserImpl();
		int result = udao.add(appUser);
		//System.out.println(result);
		udao.delete(1, appUser);
		//udao.update(user);
		udao.list(appUser).stream()
				.forEach(u->System.out.println("ID : " + u.getId() + " , Email : " + u.getEmail()));
		*/
		AppRoleDto appRoleDto = new AppRoleDto();
		appRoleDto.setNom("USER");
		
		
		IAppRoleDto rdao = new AppRoleDtoImpl();
		//int result = rdao.add(appRoleDto);
		//System.out.println(result);
		//rdao.list().stream()
				//.forEach(r->System.out.println("ID : " + r.getId() + " , Nom : " + r.getNom()));
	
		System.out.println(new AppRoleImpl().getByNom("USER").getId());
	}
}
