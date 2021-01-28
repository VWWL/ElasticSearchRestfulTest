package cn.wwl520.es.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author wangweili
 * @version 1.0
 * @date 2021/1/26 2:55 下午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_sku")
public class Sku {
    
    private String id;
    
    private String name;
    
    private Integer price;

    private Integer num;
    
    private String image;
    
    private Date updateTime;
    
    private Integer categoryId;
    
    private String categoryName;
    
    private String brandName;
    
    private Integer saleNum;
    
    private Integer commentNum;

}
