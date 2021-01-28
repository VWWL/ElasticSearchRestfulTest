package cn.wwl520.es.mapper;

import cn.wwl520.es.po.Sku;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author wangweili
 * @version 1.0
 * @date 2021/1/27 11:43 下午
 */
public interface SkuMapper extends BaseMapper<Sku> {

    @Select("select count(*) from tb_sku")
    Integer countAll();
    
}
