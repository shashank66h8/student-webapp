package j.core.goods;

import j.common.utils.PageUtils;
import j.common.utils.Query;
import j.core.goods.entity.GoodsEntity;
import j.core.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * @Auther: Aaron
 * @Date: 2018-08-29 11:41:54
 * @Description: 商品表
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {
	@Autowired
	private GoodsService goodsService;

    @GetMapping("/goods")
	public ResponseEntity<PageUtils> list(@RequestParam Map<String, Object> params){
		//查询列表数据

        HttpStatus status =  HttpStatus.NOT_FOUND;
        Query query = new Query(params);
        List<GoodsEntity> goodsList = goodsService.queryList(query);
        int total = goodsService.queryTotal(query);
        if(goodsList != null && goodsList.size() >0){
            status = HttpStatus.OK;
        }

        PageUtils pageUtil = new PageUtils(goodsList, total, query.getLimit(), query.getPage());

        return new ResponseEntity<PageUtils>(pageUtil,status);
	}
	
	
	/**
	 * 信息
	 */
	@GetMapping("/goods/{goodsId}")
	public ResponseEntity<GoodsEntity> info(@PathVariable("goodsId") Long goodsId){
		GoodsEntity goods = goodsService.queryObject(goodsId);
        HttpStatus status = goods !=null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<GoodsEntity>(goods,status);
	}
	
	/**
	 * 保存
	 */
	@PostMapping("/goods")
	public ResponseEntity<GoodsEntity> save(@RequestBody GoodsEntity goods){

	    goodsService.save(goods);
        HttpStatus status =  HttpStatus.CREATED;
        return new ResponseEntity(goods,status);
	}
	
	/**
	 * 修改
	 */
	@PatchMapping("/goods/{goodsId}")
	public ResponseEntity update(@RequestBody GoodsEntity goods){
        HttpStatus status =  HttpStatus.NO_CONTENT;
        goodsService.update(goods);
        return new ResponseEntity(status);
	}
	
	/**
	 * 删除
	 */
	@DeleteMapping("/goods")
	public ResponseEntity delete(@RequestBody Long[] goodsIds){


        HttpStatus status =  HttpStatus.NO_CONTENT;
        goodsService.deleteBatch(goodsIds);
        return new ResponseEntity(status);
	}
	
}
