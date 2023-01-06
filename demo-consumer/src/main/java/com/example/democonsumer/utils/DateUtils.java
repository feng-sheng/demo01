package com.example.democonsumer.utils;

import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * @Author: lifengsheng
 * @Date: 2023/1/6 10:24
 * @Desc:
 */
public class DateUtils {
    public static final String SHORT_FORMAT = "yyyy-MM-dd";
    public static final String LONG_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static String formatDate(Date date, String format) {
        if (Objects.isNull(date) || StringUtils.isBlank(format)) {
            return "";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(date);
    }
}
