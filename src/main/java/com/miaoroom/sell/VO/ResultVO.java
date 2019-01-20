package com.miaoroom.sell.VO;

import lombok.Data;

/**
 * @Description: http请求返回的最外层对象
 * @create: 2019/1/20 16:35
 * @author: znnnnn
 */
@Data
public class ResultVO<T> {
    /**
     * 状态码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 返回的具体内容
     */
    private T data;
}
