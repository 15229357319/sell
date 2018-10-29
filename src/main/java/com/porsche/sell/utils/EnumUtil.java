package com.porsche.sell.utils;

import com.porsche.sell.enums.CodeEnum;

/**
 * @author Xu hao
 * @Description 枚举工具类
 * @Version 1.0
 * Email 15229357319@sina.cn
 * create on 2018/10/29
 */
public class EnumUtil {

    public static <T extends  CodeEnum>T getByCode(Integer code, Class<T> enumClass){
        for (T each: enumClass.getEnumConstants()){
            if (code.equals(each.getCode())){
                return each;
            }
        }
        return null;
    }

}
