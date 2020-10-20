package org.influxdb;

import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;
import org.influxdb.impl.InfluxDBMapper;
import org.influxdb.impl.InfluxDBResultMapper;
import org.influxdb.vo.TestInflux;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestMain {
    public static void main(String[] args) {
        InfluxDB influxDB = InfluxDBFactory.connect("http://192.168.1.168:8086", "", "");
        Query query = new Query("SELECT * FROM cq WHERE time > now() - 5m", "_internal");
        QueryResult resultDb = influxDB.query(query);
        QueryResult.Result result = resultDb.getResults().get(0);
        if (result.getSeries() != null) {
            List<List<Object>> listStream = result.getSeries().stream().map(QueryResult.Series::getValues)
                    .collect(Collectors.toList()).get(0);
            if (listStream != null && listStream.size() > 0) {
                for (List<Object> value : listStream) {
                    Map<String, String> map = new HashMap<String, String>();
                    // 数据库中字段1取值
                    String field1 = value.get(0) == null ? null : value.get(0).toString();
                    // 数据库中字段2取值
                    String field2 = value.get(1) == null ? null : value.get(1).toString();
                    // TODO 用取出的字段做你自己的业务逻辑……
                    System.out.println(field1+"====="+field2);
                }
            }
        }
    }
}
