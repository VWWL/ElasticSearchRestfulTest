package cn.wwl520.es.controller;

import cn.wwl520.es.config.RestHighLevelClientRegister;
import cn.wwl520.es.constant.RestConstant;
import cn.wwl520.es.po.Sku;
import cn.wwl520.es.service.SkuService;
import com.alibaba.fastjson.JSON;
import lombok.SneakyThrows;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangweili
 * @version 1.0
 * @date 2021/1/27 9:21 下午
 */
@RestController
@RequestMapping("/goods")
public class EsController {

    @Autowired
    private SkuService skuService;

    @SneakyThrows
    @PostMapping("/init")
    public String init() {
        GetIndexRequest getIndexRequest = new GetIndexRequest("sku");
        if (RestHighLevelClientRegister.client.indices().exists(getIndexRequest, RequestOptions.DEFAULT)) {
            DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest("sku");
            AcknowledgedResponse delete = RestHighLevelClientRegister.client.indices().delete(deleteIndexRequest, RequestOptions.DEFAULT);
            System.out.println("delete = " + delete.isAcknowledged());
        }
        CreateIndexRequest request = new CreateIndexRequest("sku");
        request.mapping(RestConstant.MAPPING_CONSTANT, XContentType.JSON);
        CreateIndexResponse response = RestHighLevelClientRegister.client.indices().create(request, RequestOptions.DEFAULT);
        System.out.println("response = " + response.isAcknowledged());
        Integer totalNum = skuService.countAll();
        int total = totalNum / 1000;
        for (int i = 0; i < total; i++) {
            List<Sku> skus = new ArrayList<>(skuService.findOne(i + 1));
            BulkRequest bulkRequest = new BulkRequest();
            for (Sku sku : skus) {
                bulkRequest.add(new IndexRequest("sku")
                        .id(sku.getId())
                        .source(JSON.toJSONString(sku), XContentType.JSON)
                );
            }
            BulkResponse bulkResponse = RestHighLevelClientRegister.client.bulk(bulkRequest, RequestOptions.DEFAULT);
            System.out.println("status: " + bulkResponse.status());
        }
        return "初始化成功！";
    }

}
