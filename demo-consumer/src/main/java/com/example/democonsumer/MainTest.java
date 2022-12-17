package com.example.democonsumer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.democonsumer.entity.JsonBody;
import com.example.democonsumer.entity.User;
import com.example.democonsumer.entity.UserEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Stream;

/**
 * @Author: lifengsheng
 * @Date: 2022/11/22 11:31
 * @Desc:
 */
public class MainTest {

    @Test
    public void test02() {
        System.out.printf("abcefg%sccc%n", 123);
    }

    @Test
    public void test01() {
        String str = "jdbc:mysql://12121212:3306/data/ee";
        //int splitPoint = str.lastIndexOf("/");

        int splitPoint = str.indexOf("/", 18);
        System.out.println(splitPoint);

        System.out.println(str.substring(0, splitPoint));
        System.out.println(str.substring(splitPoint + 1));
    }






    public static void main(String[] args) {
        // 模拟接口返回数据 -> map
        UserEntity entity = new UserEntity();
        entity.setId(1L);
        entity.setAge(23);
        entity.setUsername("张三");

        Map<String, String> map2 = new HashMap<>();
        map2.put("name", "张三");

        Map<String, Object> map = new HashMap<>();
        map.put("result", entity);

        String str = "{\n" +
                "    \"result\": {\n" +
                "        \"0301002\": {\n" +
                "            \"current\": 1,\n" +
                "            \"orders\": [],\n" +
                "            \"pages\": 2,\n" +
                "            \"records\": [\n" +
                "                {\n" +
                "                    \"assets\": [\n" +
                "                        {\n" +
                "                            \"astNature\": \"01\",\n" +
                "                            \"stationType\": \"03\",\n" +
                "                            \"lastSynchronizationTime\": 1658050479883,\n" +
                "                            \"province\": \"057252DF34F345E6E050007F01007437\",\n" +
                "                            \"astType\": \"0000000\",\n" +
                "                            \"ctime\": 1657869581000,\n" +
                "                            \"elevation\": 0.0,\n" +
                "                            \"astNature#Name\": \"国家电网公司\",\n" +
                "                            \"equipCode\": \"05M00000053392539\",\n" +
                "                            \"hisFloodingDesc\": \"0\",\n" +
                "                            \"astType#Name\": \"\",\n" +
                "                            \"astId\": \"b32804a3598afcdcde58b05e270158b327bfc75a5e\",\n" +
                "                            \"objId\": \"057252DF34F345E6E050007F0100743730000001-444295\",\n" +
                "                            \"stationType#Name\": \"换流站\",\n" +
                "                            \"deployState#Name\": \"运行\",\n" +
                "                            \"provinceName\": \"国网山西省电力公司\",\n" +
                "                            \"operateDate\": 1498752000000,\n" +
                "                            \"deployState\": \"02\",\n" +
                "                            \"isFloodBaffle\": \"\",\n" +
                "                            \"lastUpdateTime\": 1657869581000\n" +
                "                        }\n" +
                "                    ],\n" +
                "                    \"id\": \"30000001-444295\",\n" +
                "                    \"modelId\": \"zf02Z\",\n" +
                "                    \"resource\": {\n" +
                "                        \"maintOrg\": \"8afcd98d5832eef301586adf6cb02125\",\n" +
                "                        \"stationType\": \"03\",\n" +
                "                        \"maintGroupName\": \"变电运维一班\",\n" +
                "                        \"voltageLevel#Name\": \"直流800kV\",\n" +
                "                        \"supplyArea\": \"\",\n" +
                "                        \"contaminationLevel#Name\": \"d级\",\n" +
                "                        \"fireAcceptance\": \"\",\n" +
                "                        \"maintOrgName\": \"±800kV特高压雁门关换流站\",\n" +
                "                        \"arrangement\": \"01\",\n" +
                "                        \"regionalism#Name\": \"农村\",\n" +
                "                        \"coverArea\": 211100.0,\n" +
                "                        \"province\": \"057252DF34F345E6E050007F01007437\",\n" +
                "                        \"isRural\": \"0\",\n" +
                "                        \"isRural#Name\": \"否\",\n" +
                "                        \"ctime\": 1657869581000,\n" +
                "                        \"isSmartStation#Name\": \"是\",\n" +
                "                        \"dutyMode#Name\": \"有人值班\",\n" +
                "                        \"converterStationType#Name\": \"\",\n" +
                "                        \"isAvc#Name\": \"是\",\n" +
                "                        \"arrangement#Name\": \"常规\",\n" +
                "                        \"psrId\": \"30000001-444295\",\n" +
                "                        \"telephone\": \"18903511656\",\n" +
                "                        \"isFirts#Name\": \"是\",\n" +
                "                        \"isN1#Name\": \"是\",\n" +
                "                        \"astId\": \"b32804a3598afcdcde58b05e270158b327bfc75a5e\",\n" +
                "                        \"isSmartStation\": \"1\",\n" +
                "                        \"maintOrg#Name\": \"±800kV特高压雁门关换流站\",\n" +
                "                        \"objId\": \"057252DF34F345E6E050007F0100743730000001-444295\",\n" +
                "                        \"name\": \"±800kV特高压雁门关换流站\",\n" +
                "                        \"isAvc\": \"1\",\n" +
                "                        \"isGis\": \"1\",\n" +
                "                        \"provinceName\": \"国网山西省电力公司\",\n" +
                "                        \"converterStationType\": 3.0,\n" +
                "                        \"lastUpdateTime\": 1657869581000,\n" +
                "                        \"altitude\": 1500.0,\n" +
                "                        \"psrState\": \"02\",\n" +
                "                        \"regionalism\": \"05\",\n" +
                "                        \"city\": \"057252DF485045E6E050007F01007437\",\n" +
                "                        \"psrType\": \"0301002\",\n" +
                "                        \"isCentralMonitor\": \"0\",\n" +
                "                        \"highestDispatchJurisdiction\": \"国调\",\n" +
                "                        \"lastSynchronizationTime\": 1658050479883,\n" +
                "                        \"cityName\": \"国网山西省电力公司超高压变电公司\",\n" +
                "                        \"runDevName\": \"±800kV特高压雁门关换流站\",\n" +
                "                        \"psrState#Name\": \"运行\",\n" +
                "                        \"startTime\": 1498752000000,\n" +
                "                        \"pubPrivFlag\": \"0\",\n" +
                "                        \"isCentralMonitor#Name\": \"否\",\n" +
                "                        \"address\": \"山西省朔州市平鲁区\",\n" +
                "                        \"maintGroup#Name\": \"变电运维一班\",\n" +
                "                        \"maintGroup\": \"8afcd98d5832eef301586af6cdf52128\",\n" +
                "                        \"isGis#Name\": \"是\",\n" +
                "                        \"contaminationLevel\": \"04\",\n" +
                "                        \"city#Name\": \"国网山西省电力公司检修分公司\",\n" +
                "                        \"isJunctionStation#Name\": \"是\",\n" +
                "                        \"voltageLevel\": \"0190\",\n" +
                "                        \"isFirts\": \"1\",\n" +
                "                        \"psrType#Name\": \"换流站\",\n" +
                "                        \"fireType\": \"\",\n" +
                "                        \"dutyMode\": \"01\",\n" +
                "                        \"isJunctionStation\": \"1\",\n" +
                "                        \"stationType#Name\": \"换流站\",\n" +
                "                        \"isN1\": \"1\"\n" +
                "                    }\n" +
                "                },\n" +
                "                {\n" +
                "                    \"assets\": [\n" +
                "                        {\n" +
                "                            \"astNature\": \"01\",\n" +
                "                            \"stationType\": \"03\",\n" +
                "                            \"astOrg#Name\": \"8a812897493378a0014955ddce5f5937\",\n" +
                "                            \"lastSynchronizationTime\": 1657829789681,\n" +
                "                            \"astOrg\": \"8a812897493378a0014955ddce5f5937\",\n" +
                "                            \"astOrgName\": \"国家电网公司\",\n" +
                "                            \"province\": \"14383AB1ACC0422DE0541CC1DE1077D5\",\n" +
                "                            \"astType\": \"0000000\",\n" +
                "                            \"ctime\": 1657707794000,\n" +
                "                            \"elevation\": 0.0,\n" +
                "                            \"astNature#Name\": \"国家电网公司\",\n" +
                "                            \"equipCode\": \"32M00000005749095\",\n" +
                "                            \"hisFloodingDesc\": \"0\",\n" +
                "                            \"astType#Name\": \"\",\n" +
                "                            \"astId\": \"B9A23EB3-73DE-4678-B48D-90A9C3C30B32-00124\",\n" +
                "                            \"objId\": \"14383AB1ACC0422DE0541CC1DE1077D530000001-234818\",\n" +
                "                            \"stationType#Name\": \"换流站\",\n" +
                "                            \"deployState#Name\": \"运行\",\n" +
                "                            \"provinceName\": \"国网辽宁省电力公司\",\n" +
                "                            \"operateDate\": 1227542400000,\n" +
                "                            \"deployState\": \"02\",\n" +
                "                            \"isFloodBaffle\": \"\",\n" +
                "                            \"lastUpdateTime\": 1657707794000\n" +
                "                        }\n" +
                "                    ],\n" +
                "                    \"id\": \"30000001-234818\",\n" +
                "                    \"modelId\": \"zf02Z\",\n" +
                "                    \"resource\": {\n" +
                "                        \"maintOrg\": \"14383AB1BEA3422DE0541CC1DE1077D5\",\n" +
                "                        \"stationType\": \"03\",\n" +
                "                        \"maintGroupName\": \"高岭变电运维班\",\n" +
                "                        \"voltageLevel#Name\": \"直流125kV\",\n" +
                "                        \"supplyArea\": \"\",\n" +
                "                        \"buildingArea\": 8276.0,\n" +
                "                        \"contaminationLevel#Name\": \"c级\",\n" +
                "                        \"fireAcceptance\": \"\",\n" +
                "                        \"maintOrgName\": \"高岭换流站\",\n" +
                "                        \"arrangement\": \"01\",\n" +
                "                        \"regionalism#Name\": \"农村\",\n" +
                "                        \"coverArea\": 248176.0,\n" +
                "                        \"province\": \"14383AB1ACC0422DE0541CC1DE1077D5\",\n" +
                "                        \"isRural\": \"0\",\n" +
                "                        \"isRural#Name\": \"否\",\n" +
                "                        \"ctime\": 1657707794000,\n" +
                "                        \"isSmartStation#Name\": \"否\",\n" +
                "                        \"dutyMode#Name\": \"有人值班\",\n" +
                "                        \"converterStationType#Name\": \"\",\n" +
                "                        \"isAvc#Name\": \"是\",\n" +
                "                        \"arrangement#Name\": \"常规\",\n" +
                "                        \"psrId\": \"30000001-234818\",\n" +
                "                        \"telephone\": \"0429-6982098\",\n" +
                "                        \"isFirts#Name\": \"是\",\n" +
                "                        \"isN1#Name\": \"是\",\n" +
                "                        \"astId\": \"B9A23EB3-73DE-4678-B48D-90A9C3C30B32-00124\",\n" +
                "                        \"isSmartStation\": \"0\",\n" +
                "                        \"maintOrg#Name\": \"高岭换流站\",\n" +
                "                        \"objId\": \"14383AB1ACC0422DE0541CC1DE1077D530000001-234818\",\n" +
                "                        \"name\": \"高岭换流站\",\n" +
                "                        \"isAvc\": \"1\",\n" +
                "                        \"isGis\": \"0\",\n" +
                "                        \"provinceName\": \"国网辽宁省电力公司\",\n" +
                "                        \"converterStationType\": 3.0,\n" +
                "                        \"lastUpdateTime\": 1657707794000,\n" +
                "                        \"altitude\": 198.0,\n" +
                "                        \"psrState\": \"02\",\n" +
                "                        \"regionalism\": \"05\",\n" +
                "                        \"city\": \"14383AB1BE1C422DE0541CC1DE1077D5\",\n" +
                "                        \"psrType\": \"0301002\",\n" +
                "                        \"isCentralMonitor\": \"1\",\n" +
                "                        \"highestDispatchJurisdiction\": \"国家电网调度\",\n" +
                "                        \"lastSynchronizationTime\": 1657829789681,\n" +
                "                        \"cityName\": \"国网辽宁省电力有限公司检修分公司\",\n" +
                "                        \"runDevName\": \"085981010001\",\n" +
                "                        \"psrState#Name\": \"运行\",\n" +
                "                        \"startTime\": 1227542400000,\n" +
                "                        \"pubPrivFlag\": \"0\",\n" +
                "                        \"isCentralMonitor#Name\": \"是\",\n" +
                "                        \"address\": \"辽宁省葫芦岛市绥中县高岭镇\",\n" +
                "                        \"maintGroup#Name\": \"高岭变电运维班\",\n" +
                "                        \"maintGroup\": \"14383AB1BEA4422DE0541CC1DE1077D5\",\n" +
                "                        \"isGis#Name\": \"否\",\n" +
                "                        \"contaminationLevel\": \"03\",\n" +
                "                        \"city#Name\": \"国网辽宁省电力有限公司超高压分公司\",\n" +
                "                        \"isJunctionStation#Name\": \"是\",\n" +
                "                        \"voltageLevel\": \"0176\",\n" +
                "                        \"isFirts\": \"1\",\n" +
                "                        \"psrType#Name\": \"换流站\",\n" +
                "                        \"fireType\": \"\",\n" +
                "                        \"dutyMode\": \"01\",\n" +
                "                        \"isJunctionStation\": \"1\",\n" +
                "                        \"stationType#Name\": \"换流站\",\n" +
                "                        \"isN1\": \"1\"\n" +
                "                    }\n" +
                "                }\n" +
                "            ],\n" +
                "            \"searchCount\": true,\n" +
                "            \"size\": 50,\n" +
                "            \"total\": 79\n" +
                "        }\n" +
                "    },\n" +
                "    \"message\": \"success\",\n" +
                "    \"errors\": \"success\",\n" +
                "    \"status\": \"000000\"\n" +
                "}";
        JSONObject jsonObject = JSONObject.parseObject(str);

        String records = jsonObject.getObject("result", JSONObject.class)
                .getObject("0301002", JSONObject.class)
                .getString("records");

        List<JSONObject> recordList = JSONObject.parseArray(records, JSONObject.class);
        recordList.forEach(item -> {
            // assets集合
            String assets = item.getString("assets");
            List<JSONObject> assetList = JSONObject.parseArray(assets, JSONObject.class);

            assetList.forEach(it -> {
                //System.out.println(it.toJSONString());
                //Asert asert = JSONObject.parseObject(it.toJSONString(), Asert.class);
            });

            // resource
            String resource = item.getString("resource");
            JsonBody jsonBody = JSONObject.parseObject(resource, JsonBody.class);
            ZoneId zoneId = ZoneId.systemDefault();
            LocalDateTime startTime = jsonBody.getStartTime();
            Instant instant = startTime.atZone(zoneId).toInstant();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String format1 = format.format(Date.from(instant));
            System.out.println(format1);
        });




    }

    private static List<Pojo> createPojoLists() {
        Pojo pojo = new Pojo();
        Pojo pojo2 = new Pojo();
        Pojo pojo3 = new Pojo();
        Pojo pojo4 = new Pojo();

        pojo.setH1("pojo.h1");
        pojo.setH2("pojo.h2");
        pojo2.setH1("pojo2.h1");
        pojo2.setH2("pojo2.h2");
        pojo3.setH1("pojo3.h1");
        pojo3.setH2("pojo3.h2");
        pojo4.setH1("pojo4.h1");
        pojo4.setH2("pojo4.h2");

        return Arrays.asList(pojo, pojo2, pojo3, pojo4);
    }

    @Data
    public static class Pojo {
        private String h1;

        private String h2;
    }
}


