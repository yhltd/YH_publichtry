package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.Column;

@Data
@TableName("gongyi_guicheng")
public class Gygc {
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
     *工序名称
     */
    private String J;
    /**
     * 工序内容
     */
    private String K;
    /**
     * 合计工时
     */
    private String L;
    /**
     * 员工签名
     */
    private String M;
    /**
     * 完工时间
     */
    private String N;
    /**
     * 检验盖章
     */
    private String O;
    /**
     * 备注
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
