package com.porsche.sell.utils;

import java.util.Random;

/**
 * UUID主键
 *
 * @author XuHao
 * Email 15229357319@sina.cn
 * create on 2018/8/13
 */
public class KeyUtil {

    /**
     * 生成UUDID主键
     * 格式：时间 + 随机数
     * @return
     */
    public static synchronized String getUniqueKey(){
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }

}
