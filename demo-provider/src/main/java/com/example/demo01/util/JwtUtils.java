package com.example.demo01.util;

/**
 * @Author: lifengsheng
 * @Date: 2023/1/12 21:42
 * @Desc:
 */
public class JwtUtils {
    // JWT String=Base64(Header).Base64(Payload).HMACSHA256(base64UrlEncode(header)+"."+base64UrlEncode(payload),secret)











    public static void main(String[] args) {
        String[] strings = str.split(System.lineSeparator());
        System.out.println(strings.length);

        StringBuilder builder = new StringBuilder("'");
        for (String string : strings) {
            builder.append(string).append("'").append(",").append("'");
        }
        System.out.println(builder);
    }

    public static String str =
                    "15133\n" +
                    "15619\n" +
                    "17258\n" +
                    "15954\n" +
                    "17259\n" +
                    "15396\n" +
                    "17697\n" +
                    "17280\n" +
                    "15193\n" +
                    "8873\n" +
                    "15196\n" +
                    "14336\n" +
                    "15190\n" +
                    "15405\n" +
                    "15179\n" +
                    "16607\n" +
                    "16558\n" +
                    "15703\n" +
                    "15365\n" +
                    "17467\n" +
                    "16905\n" +
                    "16282\n" +
                    "17509\n" +
                    "17333";
}
