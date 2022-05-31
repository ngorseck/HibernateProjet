package sn.isi.service;

import java.util.List;

import sn.isi.dto.AppRoleDto;

public interface IAppRoleDto {

	public int add(AppRoleDto appRoleDto);
	public int delete(int id);
	public int update(AppRoleDto appRoleDto);
	public List<AppRoleDto> list();
	public AppRoleDto get(int id);
}
