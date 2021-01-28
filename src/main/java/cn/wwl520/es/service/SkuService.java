package cn.wwl520.es.service;

import cn.wwl520.es.po.Sku;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author wangweili
 * @version 1.0
 * @date 2021/1/27 11:41 下午
 */
public interface SkuService extends IService<Sku> {

    List<Sku> findOne(Integer number);

    Integer countAll();

}
