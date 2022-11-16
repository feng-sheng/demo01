package com.example.democonsumer.common;

import lombok.Data;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: lifengsheng
 * @Date: 2022/11/3 19:20
 * @Desc:
 */
public class TestMain {


    public static void main(String[] args) {
        List<Record> records = getRecords();
        List<Record> sortedRecordList = records.stream()
                .sorted(Comparator.comparing(item -> sortRule().indexOf(item.getCityName())))
                .collect(Collectors.toList());
        System.out.println(sortedRecordList);
    }

    private static List<String> sortRule() {
        return Arrays.asList("合肥", "滁州", "北京", "天津", "芜湖", "安庆");
    }

    private static List<Record> getRecords() {
        Record record = new Record("安庆");
        Record record2 = new Record("滁州");
        Record record3 = new Record("合肥");
        Record record4 = new Record("芜湖");
        return Arrays.asList(record, record2, record3, record4);
    }

    @Data
    public static class Record {
        private String cityName;

        public Record(String cityName) {
            this.cityName = cityName;
        }

        public Record() {
        }
    }
}


