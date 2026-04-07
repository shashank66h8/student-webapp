package j.core.sys.controller;

import j.common.utils.PageUtils;
import j.common.utils.Query;
import j.core.sys.entity.SysUserEntity;
import j.core.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * @Auther: Aaron
 * @Date: 2018-08-29 11:37:56
 * @Description: 系统用户
 */
@RestController
@RequestMapping("/sys")
public class SysUserController {
	@Autowired
	private SysUserService sysuserService;

    @GetMapping("/users")
	public ResponseEntity<PageUtils> list(@RequestParam Map<String, Object> params){
		//查询列表数据

        HttpStatus status =  HttpStatus.NOT_FOUND;
        Query query = new Query(params);
        List<SysUserEntity> sysuserList = sysuserService.queryList(query);
        int total = sysuserService.queryTotal(query);
        if(sysuserList != null && sysuserList.size() >0){
            status = HttpStatus.OK;
        }

        PageUtils pageUtil = new PageUtils(sysuserList, total, query.getLimit(), query.getPage());

        return new ResponseEntity<PageUtils>(pageUtil,status);
	}
	
	
	/**
	 * 信息
	 */
	@GetMapping("/users/{userId}")
	public ResponseEntity<SysUserEntity> info(@PathVariable("userId") Long userId){
		SysUserEntity sysuser = sysuserService.queryObject(userId);
        HttpStatus status = sysuser !=null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<SysUserEntity>(sysuser,status);
	}

	/**
	 *
	 * 功能描述:
	 *
	 * 入参测试{
	 "username":"Aaron",
	 "password":"123456",
	 "deptId":1,
	 "mobile":"13578965466",
	 "email":"3434@qq.com",
	 "salt":"3455",
	 "status":1
	 }
	 * @param:  * @param user
	 * @return: io.moria.common.utils.R
	 * @auther: Aaron
	 * @date: 2018/7/10 11:07
	 */
	/**
	 * 保存
	 */
	@PostMapping("/users")
	public ResponseEntity<SysUserEntity> save(@RequestBody SysUserEntity sysuser){

	    sysuserService.save(sysuser);
        HttpStatus status =  HttpStatus.CREATED;
        return new ResponseEntity(sysuser,status);
	}

	/**
	 *
	 * 功能描述: 修改用户
	 *
	 * 入参测试{
	 "userId":2
	 "username":"Test2"
	 }
	 * @param:  * @param user
	 * @return: io.moria.common.utils.R
	 * @auther: Aaron
	 * @date: 2018/7/10 11:07
	 */
	/**
	 * 修改
	 */
	@PatchMapping("/users/{userId}")
	public ResponseEntity update(@RequestBody SysUserEntity sysuser){
        HttpStatus status =  HttpStatus.NO_CONTENT;
        sysuserService.update(sysuser);
        return new ResponseEntity(status);
	}

	/**
	 *
	 * 功能描述: 删除用户
	 *
	 * 入参例子：[2,3]
	 * @param:  * @param userIds
	 * @return: io.moria.common.utils.R
	 * @auther: Aaron
	 * @date: 2018/7/10 11:08
	 */
	/**
	 * 删除
	 */
	@DeleteMapping("/users")
	public ResponseEntity delete(@RequestBody Long[] userIds){


        HttpStatus status =  HttpStatus.NO_CONTENT;
        sysuserService.deleteBatch(userIds);
        return new ResponseEntity(status);
	}
	
}
