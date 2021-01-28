package cn.wwl520.es.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

/**
 * @author wangweili
 * @version 1.0
 * @date 2021/1/27 9:43 下午
 */

public class RestHighLevelClientRegister {

    public static RestHighLevelClient client;

    public static void register(String ipAddress) {
        client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost(ipAddress, 9200, "http"),
                        new HttpHost(ipAddress, 9201, "http"),
                        new HttpHost(ipAddress, 9202, "http")
                )
        );
    }

}
