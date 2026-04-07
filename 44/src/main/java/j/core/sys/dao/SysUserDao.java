package j.core.sys.dao;

import j.common.base.BaseDao;
import j.core.sys.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Auther: Aaron
 * @Date: 2018-08-29 11:37:56
 * @Description: ${comment}
 */
@Mapper
public interface SysUserDao extends BaseDao<SysUserEntity> {
	
}
