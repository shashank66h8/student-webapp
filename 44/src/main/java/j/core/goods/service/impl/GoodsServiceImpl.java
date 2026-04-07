package j.core.goods.service.impl;

import j.core.goods.dao.GoodsDao;
import j.core.goods.entity.GoodsEntity;
import j.core.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @Auther: Aaron
 * @Date: 2018-08-29 11:41:54
 * @Description: 商品表
 */

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {
	@Autowired
	private GoodsDao goodsDao;
	
	@Override
	public GoodsEntity queryObject(Long goodsId){
		return goodsDao.queryObject(goodsId);
	}
	
	@Override
	public List<GoodsEntity> queryList(Map<String, Object> map){
		return goodsDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return goodsDao.queryTotal(map);
	}
	
	@Override
    @Transactional
	public void save(GoodsEntity goods){
		goodsDao.save(goods);
	}
	
	@Override
    @Transactional
	public void update(GoodsEntity goods){
		goodsDao.update(goods);
	}
	
	@Override
    @Transactional
	public void delete(Long goodsId){
		goodsDao.delete(goodsId);
	}
	
	@Override
    @Transactional
	public void deleteBatch(Long[] goodsIds){
		goodsDao.deleteBatch(goodsIds);
	}
	
}
