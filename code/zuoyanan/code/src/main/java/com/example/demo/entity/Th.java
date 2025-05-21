package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author hui
 * @date 2025/5/9 14:59
 */
@Data
@TableName("tuihuo")
public class Th {
    @TableId(value = "id" ,type = IdType.AUTO)
    private Integer id;

    //合同号-备注G - S  13   其他C-F 4 T-X 5
    //退货客户
    private String C;

    //退货电话
    private String D;

    //退货日期
    private String E;

    //No
    private String F;

    //合同号
    private String G;

    //任务号
    private String H;

    //产品名称
    private String I;

    //图号
    private String J;

    //单位
    private String K;

    //数量
    private String L;

    //单价
    private String M;

    //金额
    private String N;

    //材质
    private String O;

    //重量
    private String P;

    //回厂日期
    private String Q;

    //退货原因
    private String R;

    //备注
    private String S;

    //合计金额（大写）    //合计金额小写
    private String T;
    //地址
    private String U;

    //电话
    private String V;
    //客户签字
    private String W;
    //大写金额
    private String X;
}
