package cn.wwl520.es;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wangweili
 * @version 1.0
 * @date 2021/1/27 9:33 下午
 */
@SpringBootApplication
@MapperScan("cn.wwl520.es.mapper")
public class EsApplication {

    public static void main(String[] args) {
        SpringApplication.run(EsApplication.class, args);
    }

}
