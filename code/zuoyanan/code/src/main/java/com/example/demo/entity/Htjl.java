package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
@Data
@TableName("hetong_jilu")
public class Htjl {
    /**
     * id自增列
     */
    @TableId(value = "id" , type = IdType.AUTO)
    private Integer id;
    /**
     * 业务单位
     */
    private String C;
    /**
     * 合同号
     */
    private String D;
    /**
     * 任务号
     */
    private String E;
    /**
     * 工艺规程状态
     */
    private String F;
    /**
     * 工序
     */
    private String G;
    /**
     * 名称
     */
    private String H;
    /**
     * 图号
     */
    private String I;
    /**
     * 单位
     */
    private String J;
    /**
     * 数量
     */
    private String K;
    /**
     * 材质
     */
    private String L;
    /**
     * 序合计
     */
    private String M;
    /**
     * 重量
     */
    private String N;
    /**
     * 工件
     */
    private String O;
    /**
     * 单元价
     */
    private String P;
    /**
     * 合计金额
     */
    private String Q;
    /**
     * 铣工时/40
     */
    private String R;
    /**
     * 铣单价
     */
    private String S;
    /**
     * 车工时/40
     */
    private String T;
    /**
     * 车单价/34
     */
    private String U;
    /**
     * 钳工时/40
     */
    private String V;
    /**
     * 钳单价
     */
    private String W;
    /**
     * 整件外委工时
     */
    private String X;
    /**
     * 整件外委单价
     */
    private String Y;
    /**
     * 外委工时/48
     */
    private String Z;
    /**
     * 外委单价
     */
    private String AA;
    /**
     * 镗工时/73
     */
    private String AB;
    /**
     * 镗单价
     */
    private String AC;
    /**
     * 割工时/24
     */
    private String AD;

    /**
     * 割单价
     */
    private String AE;
    /**
     * 磨工时/42
     */
    private String AF;
    /**
     * 磨单价
     */
    private String AG;
    /**
     * 数控铣工时/69
     */
    private String AH;
    /**
     * 数控铣单价
     */
    private String AI;

    /**
     * 立车/71
     */
    private String AJ;
    /**
     * 立车单价
     */
    private String AK;
    /**
     * 电火花/42
     */
    private String AL;
    /**
     * 电火花单价
     */
    private String AM;
    /**
     * 中走私/38
     */
    private String AN;

    /**
     * 中走丝单价
     */
    private String AO;
    /**
     * 下料
     */
    private String AP;
    /**
     * 深孔钻
     */
    private String AQ;
    /**
     * 回厂日期
     */
    private String AR;
    /**
     * 出厂日期
     */
    private String AS;

    /**
     * 订单要求交货时间
     */
    private String AT;
    /**
     * 铣
     */
    private String hetongZhuangtai ;
    /**
     * 车
     */
    private String AU;
    /**
     * 登记员
     */
    private String AV;
    /**
     * 备注
     */
    private String AW;
}
