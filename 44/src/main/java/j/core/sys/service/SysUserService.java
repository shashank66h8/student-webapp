package j.core.sys.service;

import j.core.sys.entity.SysUserEntity;

import java.util.List;
import java.util.Map;

/**
 * @Auther: Aaron
 * @Date: 2018-08-29 11:37:56
 * @Description: ${comment}
 */
public interface SysUserService {
	
	SysUserEntity queryObject(Long userId);
	
	List<SysUserEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SysUserEntity sysuser);
	
	void update(SysUserEntity sysuser);
	
	void delete(Long userId);
	
	void deleteBatch(Long[] userIds);
}
