package com.ky.flowable.util;

import java.util.UUID;

/**
 * @author ky
 * @description
 * @date 2023-12-14 16:13
 */
public class UUIDUtils {

    public static String[] chars = new String[]{"a", "b", "c", "d", "e", "f",
            "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
            "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z"};

    public static String getUuid() {
        return UUID.randomUUID().toString();
    }

    public static String getUuid32() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static String getUuid8() {
        StringBuilder shortBuffer = new StringBuilder();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        // 分为8组
        for (int i = 0; i < 8; i++) {
            // 每组4位
            String str = uuid.substring(i * 4, i * 4 + 4);
            // 将4位str转化为int 16进制下的表示
            int x = Integer.parseInt(str, 16);
            // 用该16进制数取模62（十六进制表示为314（14即E）），结果作为索引取出字符
            shortBuffer.append(chars[x % 0x3E]);
        }
        return shortBuffer.toString();
    }
}
