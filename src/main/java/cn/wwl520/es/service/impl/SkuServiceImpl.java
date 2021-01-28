package cn.wwl520.es.service.impl;

import cn.wwl520.es.mapper.SkuMapper;
import cn.wwl520.es.po.Sku;
import cn.wwl520.es.service.SkuService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wangweili
 * @version 1.0
 * @date 2021/1/27 11:45 下午
 */
@Service
@Transactional
public class SkuServiceImpl extends ServiceImpl<SkuMapper, Sku> implements SkuService {

    @Override
    public Integer countAll() {
        return baseMapper.countAll();
    }

    @Override
    public List<Sku> findOne(Integer number) {
        Page<Sku> skuPage = page(new Page<>(number, 1000));
        return skuPage.getRecords();
    }
}
