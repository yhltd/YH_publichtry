package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.Column;

@Data
@TableName("tuihuo")
public class Thjlcx {
    /**
     * id自增列
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 退货客户
     */
    private String C;
    /**
     * 退货电话
     */
    private String D;
    /**
     * 退货日期
     */
    private String E;
    /**
     * 回厂日期
     */
    private String W;
    /**
     * 退货单号
     */
    private String F;
    /**
     * 合同号
     */
    private String G;
    /**
     * 任务号
     */
    private String H;
    /**
     * 产品名称
     */
    private String I;
    /**
     * 图号
     */
    private String J;
    /**
     * 单位
     */
    private String K;
    /**
     * 数量
     */
    private String L;
    /**
     * 单价
     */
    private String M;
    /**
     * 金额
     */
    private String N;
    /**
     * 材质
     */
    private String O;
    /**
     * 重量
     */
    private String P;
    /**
     * 退货原因
     */
    private String Q;
    /**
     * 备注
     */
    private String U;
    /**
     * 地址
     */
    private String R;
    /**
     * 客户签字
     */
    private String S;
    /**
     * 电话
     */
    private String T;
    private String V;
}
