package cn.wwl520.es.constant;

/**
 * @author wangweili
 * @version 1.0
 * @date 2021/1/27 11:37 下午
 */
public class RestConstant {

    public static final String MAPPING_CONSTANT = "{\n" +
            "    \"properties\": {\n" +
            "        \"id\": {\n" +
            "            \"type\": \"keyword\"\n" +
            "        },\n" +
            "        \"name\": {\n" +
            "            \"type\": \"text\",\n" +
            "            \"analyzer\": \"ik_max_word\"\n" +
            "        },\n" +
            "        \"num\": {\n" +
            "            \"type\": \"long\",\n" +
            "            \"index\": \"false\"\n" +
            "        },\n" +
            "        \"update_time\": {\n" +
            "            \"type\": \"date\",\n" +
            "            \"index\": \"false\"\n" +
            "        },\n" +
            "        \"category_id\": {\n" +
            "            \"type\": \"long\",\n" +
            "            \"index\": \"false\"\n" +
            "        },\n" +
            "        \"category_name\": {\n" +
            "           \"type\": \"text\",\n" +
            "           \"analyzer\": \"ik_max_word\"\n" +
            "        },\n" +
            "        \"brand_name\": {\n" +
            "            \"type\": \"text\",\n" +
            "            \"analyzer\": \"ik_max_word\"\n" +
            "        },\n" +
            "        \"sale_num\": {\n" +
            "            \"type\": \"long\",\n" +
            "            \"index\": \"false\"\n" +
            "        },\n" +
            "        \"comment_num\": {\n" +
            "            \"type\": \"long\",\n" +
            "            \"index\": \"false\"\n" +
            "        }\n" +
            "    }\n" +
            "}";
}
