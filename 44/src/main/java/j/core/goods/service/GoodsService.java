package j.core.goods.service;

import j.core.goods.entity.GoodsEntity;

import java.util.List;
import java.util.Map;

/**
 * @Auther: Aaron
 * @Date: 2018-08-29 11:41:54
 * @Description: ${comment}
 */
public interface GoodsService {
	
	GoodsEntity queryObject(Long goodsId);
	
	List<GoodsEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(GoodsEntity goods);
	
	void update(GoodsEntity goods);
	
	void delete(Long goodsId);
	
	void deleteBatch(Long[] goodsIds);
}
