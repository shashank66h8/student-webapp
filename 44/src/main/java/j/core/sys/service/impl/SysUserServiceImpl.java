package j.core.sys.service.impl;

import j.core.sys.dao.SysUserDao;
import j.core.sys.entity.SysUserEntity;
import j.core.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @Auther: Aaron
 * @Date: 2018-08-29 11:37:56
 * @Description: 系统用户
 */

@Service("sysuserService")
public class SysUserServiceImpl implements SysUserService {
	@Autowired
	private SysUserDao sysuserDao;
	
	@Override
	public SysUserEntity queryObject(Long userId){
		return sysuserDao.queryObject(userId);
	}
	
	@Override
	public List<SysUserEntity> queryList(Map<String, Object> map){
		return sysuserDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return sysuserDao.queryTotal(map);
	}
	
	@Override
    @Transactional
	public void save(SysUserEntity sysuser){
		sysuserDao.save(sysuser);
	}
	
	@Override
    @Transactional
	public void update(SysUserEntity sysuser){
		sysuserDao.update(sysuser);
	}
	
	@Override
    @Transactional
	public void delete(Long userId){
		sysuserDao.delete(userId);
	}
	
	@Override
    @Transactional
	public void deleteBatch(Long[] userIds){
		sysuserDao.deleteBatch(userIds);
	}
	
}
