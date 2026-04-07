package j.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Auther: Aaron
 * @Date: 2018/7/10 10:57
 * @Description: 异常处理器
 */
@RestControllerAdvice
public class CustomExceptionHandler {
	private Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 自定义异常
	 */
	@ExceptionHandler(CustomException.class)
	public ResponseEntity handleCustomException(CustomException e){
		return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//		R r = new R();
//		r.put("code", e.getCode());
//		r.put("msg", e.getMessage());

//		return r;
	}

	@ExceptionHandler(DuplicateKeyException.class)
	public ResponseEntity handleDuplicateKeyException(DuplicateKeyException e){
		return new ResponseEntity("数据库中已存在该记录",HttpStatus.INTERNAL_SERVER_ERROR);
//		logger.error(e.getMessage(), e);
//		return R.error("数据库中已存在该记录");
	}


	@ExceptionHandler(Exception.class)
	public ResponseEntity handleException(Exception e){
		logger.error(e.getMessage(), e);
		return new ResponseEntity("未知错误，请联系管理员",HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
