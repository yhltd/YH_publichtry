package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("gongyi_guicheng")
public class Shdp {
    @TableId(value = "id", type = IdType.AUTO)
    private  Integer id;

    //合同记录IDShdp
    private String C;

    //业务单位
    private String D;

    //数量
    private String E;

    //材质
    private String F;

    //零件名称
    private String G;

    //任务号
    private String H;

    //图号
    private String I;

    //工序名称
    private String J;

    //工序内容
    private String K;

    //合计工时
    private String L;

    //员工签名
    private String M;

    //完工时间
    private String N;

    //检验盖章
    private String O;

    //备注
    private String P;

    //工艺员
    private String Q;

    //工艺员日期
    private String R;

    //校对员
    private String S;

    //校对员日期
    private String T;

    //批准员
    private String U;

    //批准员日期
    private String V;
}

