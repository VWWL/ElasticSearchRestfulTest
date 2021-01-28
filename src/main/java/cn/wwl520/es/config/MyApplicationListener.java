package cn.wwl520.es.config;

import cn.wwl520.es.constant.MessageConstant;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author wangweili
 * @version 1.0
 * @date 2021/1/27 9:38 下午
 */
@Component
public class MyApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        RestHighLevelClientRegister.register(MessageConstant.IP_ADDRESS);
        System.out.println("RedisHighLevelClient :" + RestHighLevelClientRegister.client + "registered complete.");
    }
}
