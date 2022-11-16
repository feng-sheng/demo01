package com.example.democonsumer.common;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public enum CityEnum {
    HE_FEI(1, "合肥"),
    CHU_ZHOU(2, "滁州"),
    WU_HU(3, "芜湖"),
    AN_QING(4, "安庆");

    private Integer order;
    private String cityName;

    private static CityEnum getCityByName(String cityName) {
        return Arrays.stream(CityEnum.values())
                .filter(item -> Objects.equals(cityName, item.getCityName()))
                .findFirst().orElse(null);
    }

    public static Integer getOrderByName(String cityName) {
        return Optional.ofNullable(getCityByName(cityName).getOrder()).orElse(10000);
    }

    CityEnum(Integer order, String cityName) {
        this.order = order;
        this.cityName = cityName;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
