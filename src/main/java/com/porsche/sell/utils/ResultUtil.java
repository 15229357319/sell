package com.porsche.sell.utils;

import com.porsche.sell.vo.ResultVo;

/**  方法结果集工具类
 * @author XuHao
 * Email 15229357319@sina.cn
 * create on 2018/8/10
 */
public class ResultUtil {

    /**
     * 成功结果（含有数据）
     * @param obj
     * @return
     */
    public static ResultVo success(Object obj){
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(0);
        resultVo.setMsg("success");
        resultVo.setData(obj);
        return  resultVo;
    }

    /**
     * 成功结果
     * @return
     */
    public static ResultVo success(){
        return success(null);
    }

    /**
     * 失败结果
     * @param code
     * @param msg
     * @return
     */
    public static ResultVo error(Integer code, String msg){
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(code);
        resultVo.setMsg(msg);
        return  resultVo;
    }


}
